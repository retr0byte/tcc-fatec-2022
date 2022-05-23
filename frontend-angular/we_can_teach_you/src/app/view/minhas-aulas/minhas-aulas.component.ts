import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-minhas-aulas',
  templateUrl: './minhas-aulas.component.html',
  styleUrls: ['./minhas-aulas.component.css']
})
export class MinhasAulasComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  /// uma lista macro
  /// n listas micro, cada uma com 3 objetos
  /// cada objeto representa 1 aula
  aulas = [
    [
      {
        id: 1,
        name: 'Aula 1',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        date: '11/05/2022',
        duration:'00:30:00',
        img: '/assets/images/aula.jpg'
      },
      {
        id: 2,
        name: 'Aula 2',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        date: '11/05/2022',
        duration:'00:30:00',
        img: '/assets/images/aula.jpg'
      },
      {
        id: 3,
        name: 'Aula 3',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        date: '11/05/2022',
        duration:'00:30:00',
        img: '/assets/images/aula.jpg'
      }
    ],
    [
      {
        id: 4,
        name: 'Aula 4',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        date: '11/05/2022',
        duration:'00:30:00',
        img: '/assets/images/aula.jpg'
      },
      {
        id: 5,
        name: 'Aula 5',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        date: '11/05/2022',
        duration:'00:30:00',
        img: '/assets/images/aula.jpg'
      },
      {
        id: 6,
        name: 'Aula 6',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
        date: '11/05/2022',
        duration:'00:30:00',
        img: '/assets/images/aula.jpg'
      }
    ],
  ]



}
