import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { AlertsService } from './alerts.service';

import { Auth } from '../model/Auth';
import { Login } from '../model/Login';
import { Profiles } from '../model/Profiles';
import { Register, RegisterRequest, RegisterResponse } from '../model/Register';

import { UserProfiles, UserProfilesTranslations, UserProfilesRoutes } from '../enums/UserProfiles'

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  api = 'http://localhost:8080';
  // api = 'https://wcty-api.herokuapp.com';
  userLogged: Auth | null = null;
  profiles: UserProfiles[] = [ UserProfiles.ALUNO, UserProfiles.PROFESSOR, UserProfiles.FUNCIONARIO ];
  newUser = false;
  isFuncionario: boolean = true;

  constructor(private http: HttpClient, public alerts: AlertsService) {}

  getUserProfile(): string {
    return this.userLogged ? this.userLogged!.profile[0] : '';
  }

  checkIfItsAEmployee(): boolean  {
    const userProfile = this.getUserProfile()
    return userProfile ? ['ADMIN', 'FUNCIONARIO'].includes( userProfile ) : false;
  }

  toggleOptions(){
    this.newUser = !this.newUser;
  }

  getProfileName( profileId: UserProfiles ): string {
    return UserProfilesTranslations[profileId];
  }

  getProfileRoutePath( profileName: string ): string {
    let routePathKey = profileName as 'string';
    let routePath = UserProfilesRoutes[routePathKey as keyof Profiles];

    return routePath;
  }

  postLogin( userInfo: Login, welcomeAlert = true ){
    this.http.post<Auth>(
      this.api + '/login', userInfo
    ).subscribe(
      (data) => {
        if( welcomeAlert )
          this.alerts.showAlertSuccess({
            title: `Bem vindo: ${data.username}`,
            message: 'É bom ter você de volta :)'
          });

        setTimeout(() => {
          this.userLogged = data;
          this.isFuncionario = this.checkIfItsAEmployee();
        }, 1500)
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );
  }

  postRegister( userData: Register ) {
    if ( userData.password === userData.passwordConfirmation ) {
      const requestPkg: RegisterRequest = {
        nome: userData.fullname,
        email: userData.email,
        senha: userData.password,
        perfis: [ parseInt(userData.profile.value) ]
      };

      let path = this.getProfileRoutePath(userData.profile.name);

      this.http.post<RegisterResponse>(
        this.api + `/${path}`, requestPkg
      ).subscribe(
        (data) => {
          this.alerts.showAlertSuccess({
            title: 'Parabéns:',
            message: 'Você efetuou seu cadastro na plataforma e já pode começar a aprender... Em 5s você será redirecionado(a) para a página principal. Obrigado(a)!'
          });
          setTimeout(() => {
            this.postLogin({ email: requestPkg.email, senha: requestPkg.senha}, false);
          }, 5000)
        },
        (error) => {
          this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
        }
       );

    } else {
      this.alerts.showAlertWarning({ title: 'Warning:', message: 'As senhas informadas, não coincidem. Por favor, ajuste-as e tente novamente.' });
    }

  }

  logout() {
    this.userLogged = null;
  }
}
