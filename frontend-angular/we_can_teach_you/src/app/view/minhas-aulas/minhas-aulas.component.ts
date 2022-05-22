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

  d = [{
    id: 1,
    nome: 'Aula 1',
    descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    dataAula: '11/05/2022',
    duracaoAula:'00:30:00',
  },
  {
    id: 2,
    nome: 'Aula2',
    descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    dataAula: '11/05/2022',
    duracaoAula:'00:30:00',
  },
  {
    id: 3,
    nome: 'Aula 3',
    descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    dataAula: '11/05/2022',
    duracaoAula:'00:30:00',
  },
  {
    id: 4,
    nome: 'Aula 4',
    descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    dataAula: '11/05/2022',
    duracaoAula:'00:30:00',
  },
  {
    id: 5,
    nome: 'Aula 5',
    descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    dataAula: '11/05/2022',
    duracaoAula:'00:30:00',
  },
  {
    id: 6,
    nome: 'Aula 6',
    descricao: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    dataAula: '11/05/2022',
    duracaoAula:'00:30:00',
  },
 
  ]
  

  getLista() {
    return this.d;
  }

}
