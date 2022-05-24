import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

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
  // userLogged: any = true; // ? gambi para faciltiar o desenvolvimento
  profiles: UserProfiles[] = [ UserProfiles.ALUNO, UserProfiles.PROFESSOR, UserProfiles.FUNCIONARIO ];
  newUser = false;

  constructor(private http: HttpClient) {}

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

  postLogin( userInfo: Login ){
    this.http.post<Auth>(
      this.api + '/login', userInfo
    ).subscribe( (data: Auth) => {
      this.userLogged = data;
    });
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
      ).subscribe( data => {
        // TODO: alertar se deu certo o cadastro ou não, depois de um tempinho fazer o login (caso sucesso)
        if ( data.nome )
          this.postLogin({ email: requestPkg.email, senha: requestPkg.senha});
        else {
          // TODO: RETORNA ERRO
         }
       });

    } else {
      // TODO: RETORNA ERRO
    }

  }

  logout() {
    this.userLogged = null;
  }
}
