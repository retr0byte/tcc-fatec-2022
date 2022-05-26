import { Component, OnInit } from '@angular/core';

import { OwlOptions } from 'ngx-owl-carousel-o';

import { ControllerService } from 'src/app/controller/controller.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: false,
    navSpeed: 700,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      1180: {
        items: 2
      },
      1600: {
        items: 3
      },
      2000: {
        items: 4
      }
    },
    nav: true
  }

  constructor(public ctrl: ControllerService) { }

  ngOnInit(): void {
  }

}
