import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-access',
  templateUrl: './access.component.html',
  styleUrls: ['./access.component.css']
})
export class AccessComponent implements OnInit {
  newUser = false;

  @Input() login: any;

  constructor() { }

  ngOnInit(): void {
  }

  toggleOptions(){
    this.newUser = !this.newUser;
  }

  register(){}

}
