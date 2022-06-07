import { Component } from '@angular/core';

import { AuthService } from './controller/auth.service';
import { ControllerService } from './controller/controller.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public auth: AuthService, public ctrl: ControllerService) {}

  //isFuncionario: boolean = ['ALUNO', 'PROFESSOR'].includes(this.auth.userLogged!.profile[0]);
}
