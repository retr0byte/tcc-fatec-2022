import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { AuthService } from './auth.service';

import { Professor } from '../model/Professor';
import { Marcacoes, MarcacoesRequest, MarcacoesResponse } from '../model/Marcacoes';

@Injectable({
  providedIn: 'root'
})
export class ControllerService {
  topMenuSearchOpt = false;
  professorsByCategory: Professor[] | null = null;
  appointmentsByClass: MarcacoesResponse[][] | null = null;

  constructor(public auth: AuthService, private http: HttpClient) { }

  // CRUD PROFESSORS
  getProfessorsByCategory(searchItem: string) {

    if (searchItem == '') {
      // TODO: exibir mensagem de erro para o user
    }

    this.http.get<Professor[]>(
      this.auth.api + '/professores/categoria/' + searchItem, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe( data => { this.professorsByCategory = data; });

    return false;
  }

  // CRUD APPOINTMENTS
  getAppointments(classId: string | null) {
    if (classId == '') {
      // TODO: exibir mensagem de erro para o user
    }

    this.http.get<MarcacoesResponse[]>(
      this.auth.api + '/marcacoes/aula/' + classId + '/aluno/' + this.auth.userLogged!.userId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe( data => {
      let newArr = [];
      let tempArr: any = [];
      let cont = 0;
      for (const appointment of data) {
        if(cont < 2) {
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
    });

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
    ).subscribe( data => {
      if (data.nome) {
        this.getAppointments(appointmentInfo.classId);
      } else {
        // TODO: RETORNA ERRO
      }
    });
  }

  // ! dando erro de cors? (pelo insomnia vai normal e retorna com o allow-origins!?)
  deleteAppointment( appointmentId: number, classId: string | null ) {
    if (appointmentId) {
      // TODO: exibir mensagem de erro para o user
    }

    this.http.delete(
      this.auth.api + '/marcacoes/' + appointmentId + '/aluno/' + this.auth.userLogged!.userId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe( () => {
      this.getAppointments( classId );
    });
  }




}
