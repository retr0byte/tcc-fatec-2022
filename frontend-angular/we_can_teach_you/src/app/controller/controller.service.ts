import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Professor } from '../model/Professor';

import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ControllerService {
  topMenuSearchOpt = true;
  // professorsByCategory: Professor[] | null = null;
  professorsByCategory: any = true; // ? gambi para faciltiar o desenvolvimento

  constructor(public auth: AuthService, private http: HttpClient) { }

  getProfessorsByCategory(searchItem: string) {

    if (searchItem == '') {
      // ! exibir mensagem de erro para o user
    }

    this.http.get<Professor[]>(
      this.auth.api + '/professores/categoria/' + searchItem, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe( data => { this.professorsByCategory = data;});

    return false;
  }




}
