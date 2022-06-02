import { Component, Input, OnInit } from '@angular/core';
import { AlertsService } from 'src/app/controller/alerts.service';
import { ControllerService } from 'src/app/controller/controller.service';

import { Aula } from 'src/app/model/Aula';

@Component({
  selector: 'app-minhas-aulas',
  templateUrl: './minhas-aulas.component.html',
  styleUrls: ['./minhas-aulas.component.css']
})
export class MinhasAulasComponent implements OnInit {
  aulas: Aula | null = null;
  
  @Input() classId!: string | null;
  
  constructor(public ctrl: ControllerService, public alerts: AlertsService) { }

  ngOnInit(): void {
    this.ctrl.getAula(this.classId)
  }


}
