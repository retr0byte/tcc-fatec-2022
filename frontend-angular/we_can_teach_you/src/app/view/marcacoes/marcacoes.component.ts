import { Component, Input, OnInit } from '@angular/core';
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
  appointmentTime: string = '';
  appointmentTitle: string = '';
  appointmentDescription: string = '';

  @Input() classId!: string | null;

  constructor(public ctrl: ControllerService) { }

  ngOnInit(): void {
    this.ctrl.getAppointments( this.classId )
  }

  togleNewAppointment() {
    this.newAppointment = !this.newAppointment;
  }

  cadAppointment() {
    if ( this.appointmentTime == '' || this.appointmentTitle == '' || this.appointmentDescription == '' || this.classId ) {
      // TODO: exibir mensagem de erro para o user
    }

    this.ctrl.postAppointment({
      classId: this.classId,
      time: this.appointmentTime,
      title: this.appointmentTitle,
      description: this.appointmentDescription
    });

    this.appointmentTime = '';
    this.appointmentTitle = '';
    this.appointmentDescription = '';
    this.newAppointment = false;
  }

}
