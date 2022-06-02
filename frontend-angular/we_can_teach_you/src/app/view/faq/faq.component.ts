import { Component, OnInit } from '@angular/core';
import { AlertsService } from 'src/app/controller/alerts.service';
import { ControllerService } from 'src/app/controller/controller.service';

import { Faq } from 'src/app/model/Faq';


@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
  faqs: Faq | null = null;
  


  constructor(public ctrl: ControllerService, public alerts: AlertsService) { }

  ngOnInit(): void {
    this.ctrl.getFaqs()
  }

}
