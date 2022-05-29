import { Injectable } from '@angular/core';

import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

import { AlertTypes } from '../enums/AlertTypes';
import { Alerts } from '../model/Alerts';

import { AlertModalComponent } from '../view/alert-modal/alert-modal.component';


@Injectable({
  providedIn: 'root'
})
export class AlertsService {

  constructor(private modalService: BsModalService) { }

  private showAlert(title: string, message: string, type: AlertTypes) {
    const bsModalRef: BsModalRef = this.modalService.show(AlertModalComponent);
    bsModalRef.content.type = type;
    bsModalRef.content.title = title;
    bsModalRef.content.message = message;
  }

  showAlertDanger({ title, message }: Alerts) {
    this.showAlert(title, message, AlertTypes.DANGER);
  }

  showAlertSuccess({ title, message }: Alerts) {
    this.showAlert(title, message, AlertTypes.SUCCESS);
  }

  showAlertWarning({ title, message }: Alerts) {
    this.showAlert(title, message, AlertTypes.WARNING);
  }
}
