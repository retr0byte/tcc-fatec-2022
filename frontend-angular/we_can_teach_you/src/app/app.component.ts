import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  auth = false;

  login(){
    this.auth = !this.auth;
    console.log(this.auth) // ! ao mudar o auth, deveria mudar a tela seguindo o ngIf
  }
}
