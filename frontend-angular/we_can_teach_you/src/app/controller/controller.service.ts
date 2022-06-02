import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { AuthService } from './auth.service';
import { AlertsService } from './alerts.service';

import { Professor } from '../model/Professor';
import { Marcacoes, MarcacoesRequest, MarcacoesResponse } from '../model/Marcacoes';
import { Aula, AulaResponse } from '../model/Aula';

@Injectable({
  providedIn: 'root'
})
export class ControllerService {
  topMenuSearchOpt = false;
  professorsByCategory: Professor[] | null = null;
  appointmentsByClass: MarcacoesResponse[][] | null = null;
  AulaById: AulaResponse[][] | null = null;
  aula: Aula[] | null = null;

  


  constructor(public auth: AuthService, private http: HttpClient, public alerts: AlertsService) { }

  // CRUD PROFESSORS
  getProfessorsByCategory(searchItem: string) {

    if (searchItem == '') {
      this.alerts.showAlertWarning({ title: 'Warning:', message: 'Needed field empty' });
    }

    this.http.get<Professor[]>(
      this.auth.api + '/professores/categoria/' + searchItem, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
        (data) => {
          this.professorsByCategory = data;
        },
        (error) => {
          this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
        }
      );

    return false;
  }

  // CRUD APPOINTMENTS
  getAppointments(classId: string | null) {
    if (classId == '') {
      this.alerts.showAlertWarning({ title: 'Warning:', message: 'Needed field empty' });
    }

    this.http.get<MarcacoesResponse[]>(
      this.auth.api + '/marcacoes/aula/' + classId + '/aluno/' + this.auth.userLogged!.userId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
      (data) => {
        let newArr = [];
        let tempArr: any = [];
        let cont = 0;
        for (const appointment of data) {
          if(cont < 3) {
            tempArr.push(appointment);
            cont++;
          }else{
            newArr.push(tempArr);
            tempArr = [];
            cont=1;
            tempArr.push(appointment);
          }
        }

        if(tempArr.length > 0) {
          newArr.push(tempArr)
          tempArr = [];
        }

        this.appointmentsByClass = newArr;
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );

  }

  postAppointment(appointmentInfo: Marcacoes) {

    const requestPkg: MarcacoesRequest = {
      nome: appointmentInfo.title,
      descricao: appointmentInfo.description,
      momentoMarcacao: appointmentInfo.time,
      aluno: { id: parseInt(this.auth.userLogged!.userId) },
      aula: { id: parseInt(appointmentInfo.classId ? appointmentInfo.classId : '0') }
    };

    this.http.post<MarcacoesResponse>(
      this.auth.api + '/marcacoes', requestPkg, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token },
      }
    ).subscribe(
      (data) => {
        this.getAppointments( appointmentInfo.classId );
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );
  }

  // ! dando erro de cors? (pelo insomnia vai normal e retorna com o allow-origins!?)
  deleteAppointment( appointmentId: number, classId: string | null ) {
    if (appointmentId) {
      this.alerts.showAlertWarning({ title: 'Warning:', message: 'Needed field empty' });
    }

    this.http.delete(
      this.auth.api + '/marcacoes/' + appointmentId + '/aluno/' + this.auth.userLogged!.userId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
      (data) => {
        this.getAppointments( classId );
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );
  }

  // CRUD AULA
  getAula(classId: string | null) {

    if (classId == '') {
      this.alerts.showAlertWarning({ title: 'Warning:', message: 'Needed field empty' });
    }
   
    this.http.get<AulaResponse[]>(
      this.auth.api + '/aulas' + '/aluno/' + this.auth.userLogged!.userId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
      (data) => {
        let newArr = [];
        let tempArr: any = [];
        let cont = 0;
        for (const aula of data) {
          if(cont < 3) {
            tempArr.push(aula);
            cont++;
          }else{
            newArr.push(tempArr);
            tempArr = [];
            cont=1;
            tempArr.push(aula);
          }
        }

        if(tempArr.length > 0) {
          newArr.push(tempArr)
          tempArr = [];
        }

        this.AulaById = newArr;
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );


  }

  getAulaDetalhe(classId: string | null) {
    if (classId == '') {
      this.alerts.showAlertWarning({ title: 'Warning:', message: 'Needed field empty' });
    }

    this.http.get<Aula[]>(
      this.auth.api + '/aulas/' + classId + '/aluno/' + this.auth.userLogged!.userId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
        (data) => {
          this.aula = data;
        },
        (error) => {
          this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
        }
      );

  }


}
