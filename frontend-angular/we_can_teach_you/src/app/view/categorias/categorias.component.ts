import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  visivel:Boolean = false;
  editVisivel:Boolean = false;
  nome:string = 'Nome categoria';
  descricao:string = 'Descrição categoria';

  constructor() { }

  ngOnInit(): void {}

  mostrar(): void {
    this.visivel = ! this.visivel; 
  }

  editar() {
    this.editVisivel = ! this.editVisivel;
  }

}
