import { Component, OnInit } from '@angular/core';
import { ControllerService } from 'src/app/controller/controller.service';
import { Marcacoes } from 'src/app/model/Marcacoes';

@Component({
  selector: 'app-marcacoes',
  templateUrl: './marcacoes.component.html',
  styleUrls: ['./marcacoes.component.css']
})
export class MarcacoesComponent implements OnInit {
  appointments: Marcacoes | null = null;
  newAppointment: boolean = false

  constructor(public ctrl: ControllerService) { }

  ngOnInit(): void {
  }

  togleNewAppointment() {
    this.newAppointment = !this.newAppointment;
  }

}
