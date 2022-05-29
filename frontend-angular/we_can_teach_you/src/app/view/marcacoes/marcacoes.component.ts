import { Component, Input, OnInit } from '@angular/core';

import { AlertsService } from 'src/app/controller/alerts.service';
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

  constructor(public ctrl: ControllerService, public alerts: AlertsService) { }

  ngOnInit(): void {
    this.ctrl.getAppointments( this.classId )
  }

  togleNewAppointment() {
    this.newAppointment = !this.newAppointment;
  }

  cadAppointment() {
    if ( this.appointmentTime == '' || this.appointmentTitle == '' || this.appointmentDescription == '' || this.classId ) {
      this.alerts.showAlertWarning({ title: 'Warning:', message: 'Missing needed data.' });
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
