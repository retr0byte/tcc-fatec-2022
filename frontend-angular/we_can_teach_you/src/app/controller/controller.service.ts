import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { AuthService } from './auth.service';
import { AlertsService } from './alerts.service';

import { Professor } from '../model/Professor';
import { Marcacoes, MarcacoesRequest, MarcacoesResponse } from '../model/Marcacoes';
import { Aula, AulaResponse } from '../model/Aula';
import { Faq, FaqResponse } from 'src/app/model/Faq';
import { Category, CategoryResponse } from '../model/Category';

@Injectable({
  providedIn: 'root'
})
export class ControllerService {
  topMenuSearchOpt = false;
  professorsByCategory: Professor[] | null = null;
  appointmentsByClass: MarcacoesResponse[][] | null = null;
  AulaById: AulaResponse[][] | null = null;
  faqs: FaqResponse[] | null = null;
  category: CategoryResponse[] | null = null;

  constructor(public auth: AuthService, private http: HttpClient, public alerts: AlertsService) { }

  // CRUD PROFESSORS
  getProfessorsByCategory(searchItem: string) {
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

  deleteAppointment( appointmentId: number, classId: string | null ) {
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
    
  //CRUD FAQ
  getFaqs() {

    this.http.get<FaqResponse[]>(
      this.auth.api + '/faq', {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
        (data) => {
          this.faqs = data;
          
        },
        (error) => {
          this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
        }
      );

    return false;
  }

  postFaq(faqInfo: Faq){

      const requestPkg: Faq = {
        tituloPergunta: faqInfo.tituloPergunta,
        respostaPergunta: faqInfo.respostaPergunta,
        funcionario: { id: parseInt(this.auth.userLogged!.userId) },
      };

      this.http.post<Faq>(
        this.auth.api + '/faq', requestPkg, {
          headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token },
        }
      ).subscribe(
        (data) => {
          this.getFaqs();
        },
        (error) => {
          this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
        }
      );
  }

  deleteFaq( faqId: number) {
    this.http.delete(
      this.auth.api + '/faq/' + faqId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
      (data) => {
        this.getFaqs();
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );
  }

  putFaq(faqInfo: Faq) {
    if(!faqInfo.id) {
      this.alerts.showAlertWarning({ title: "Atenção", message: "Não foi possível atualizar a FAQ." });
    }
    
    const requestPkg: Faq = {
      id: faqInfo.id,
      tituloPergunta: faqInfo.tituloPergunta,
      respostaPergunta: faqInfo.respostaPergunta,
      funcionario: { id: parseInt(this.auth.userLogged!.userId) },
    };

    this.http.put<FaqResponse>(
      this.auth.api + '/faq/' , requestPkg, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token },
      }
    ).subscribe(
      (data) => {
        this.getFaqs();
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

  //CRUD Category
  getCategories() {

    this.http.get<CategoryResponse[]>(
      this.auth.api + '/categorias', {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
        (data) => {
          this.category = data;
        },
        (error) => {
          this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
        }
      );

    return false;
  }

  postCategory(categoryInfo: Category) {

    const requestPkg: Category = {
      nome: categoryInfo.nome,
      descricao: categoryInfo.descricao
    };

    this.http.post<CategoryResponse>(
      this.auth.api + '/categorias', requestPkg, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token },
      }
    ).subscribe(
      (data) => {
        this.getCategories();
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );
  }

  putCategory(categoryInfo: Category) {
    if(!categoryInfo.id) {
      this.alerts.showAlertWarning({ title: "Atenção", message: "Não foi possível atualizar a categoria." });
    }
    this.http.put<CategoryResponse>(
      this.auth.api + '/categorias/' , categoryInfo, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token },
      }
    ).subscribe(
      (data) => {
        this.getCategories();
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );
  }

  deleteCategory( categoryId: number) {
    this.http.delete(
      this.auth.api + '/categorias/' + categoryId, {
        headers: { 'Authorization': 'Bearer ' + this.auth.userLogged!.token }
      }
    ).subscribe(
      (data) => {
        this.getCategories();
      },
      (error) => {
        this.alerts.showAlertDanger({ title: error.statusText, message: error.message });
      }
    );
  }

}
