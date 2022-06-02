import { Component } from '@angular/core';
import { Location } from '@angular/common';

import { AuthService } from './controller/auth.service';
import { ControllerService } from './controller/controller.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public auth: AuthService, public ctrl: ControllerService, public location: Location) {}

  highlight(paths:string[], highlightClass: string): string {
    let curRoute: string = this.location.path();

    if(paths[0] === '/' && curRoute === '')
      return highlightClass;

    for (const path of paths) {
      if(paths[0]==='/')
        continue;

      if(curRoute.includes(path))
        return highlightClass;
    }

    return '';
  }

}
