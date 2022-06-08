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
  faqs: Faq | null = null;
  


  constructor(public ctrl: ControllerService, public alerts: AlertsService, public auth: AuthService) { }

  isFuncionario: boolean = ['ALUNO', 'PROFESSOR'].includes(this.auth.userLogged!.profile[0]);

  isVisible: boolean = false;

  isEdit: boolean = false;

  

  ngOnInit(): void {
    this.ctrl.getFaqs()
  }

  show(): void{
    this.isVisible = !this.isVisible;
  }

  showEdit(): void{
    this.isEdit = !this.isEdit;
  }
}
