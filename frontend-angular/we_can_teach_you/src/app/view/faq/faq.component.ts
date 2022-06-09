import { Component, OnInit } from '@angular/core';
import { AlertsService } from 'src/app/controller/alerts.service';
import { AuthService } from 'src/app/controller/auth.service';
import { ControllerService } from 'src/app/controller/controller.service';

import { Faq } from 'src/app/model/Faq';


@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
  pergunta: string = '';
  resposta: string = '';

  constructor(public ctrl: ControllerService, public alerts: AlertsService) { }

  isVisible: boolean = false;

  ngOnInit(): void {
    this.ctrl.getFaqs()
  }

  show(): void{
    this.isVisible = !this.isVisible;
  }

  showEdit(index: number) {
    const el = document.getElementById(`faq-item-${index}`) as HTMLElement;
    const editWrapper = el.querySelector(`.edit-wrapper`) as HTMLElement;
    const staticWrapper = el.querySelector(`.static-wrapper`) as HTMLElement;

    const btnEdit = el.querySelector(`.btn-edit`) as HTMLElement;
    const btnSave = el.querySelector(`.btn-save`) as HTMLElement;

    if(el.classList.contains("static")) {
      editWrapper!.style.display = "flex";
      staticWrapper!.style.display = "none";
      btnEdit!.style.display = "none";
      btnSave!.style.display = "flex";
      el.classList.remove("static");

    } else {
      editWrapper!.style.display = "none";
      staticWrapper!.style.display = "flex";
      btnEdit!.style.display = "flex";
      btnSave!.style.display = "none";
      el.classList.add("static");

    }

  }

  cadastroFaq(): void{
    this.ctrl.postFaq({  tituloPergunta: this.pergunta, respostaPergunta: this.resposta});
    this.pergunta = '';
    this.resposta = '';
    this.isVisible = false;
  }

  searchByTitle( searchItem: string ) {
    if(searchItem == '') {
      this.ctrl.getFaqs();
    } else {
      this.ctrl.getFaqsByTitle(searchItem);
    }
  }
}
