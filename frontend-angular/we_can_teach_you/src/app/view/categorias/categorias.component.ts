import { Component, OnInit } from '@angular/core';
import { AlertsService } from 'src/app/controller/alerts.service';
import { ControllerService } from 'src/app/controller/controller.service';
import { Category } from 'src/app/model/Category';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  visivel:Boolean = false;
  categories: Category | null = null;
  categoryNome: string = '';
  categoryDescricao: string = '';
  

  constructor(public ctrl: ControllerService, public alerts: AlertsService) { }

  ngOnInit(): void {
    this.ctrl.getCategories();
  }

  mostrar(): void {
    this.visivel = ! this.visivel; 
  }

  editar(index: number) {
    const el = document.getElementById(`cat-item-${index}`) as HTMLElement;
    const editWrapper = el.querySelector(`.edit-wrapper`) as HTMLElement;
    const staticWrapper = el.querySelector(`.static-wrapper`) as HTMLElement;

    const btnEdit = el.querySelector(`.btn-edit`) as HTMLElement;
    const btnSave = el.querySelector(`.btn-save`) as HTMLElement;

    if(el.classList.contains("static")) {
      editWrapper!.style.display = "flex";
      staticWrapper!.style.display = "none";
      btnEdit!.style.display = "none";
      btnSave!.style.display = "flex";
      el.classList.remove("static");

    } else {
      editWrapper!.style.display = "none";
      staticWrapper!.style.display = "flex";
      btnEdit!.style.display = "flex";
      btnSave!.style.display = "none";
      el.classList.add("static");

    }
    
  }

  cadCategory() {
    this.ctrl.postCategory({
      nome: this.categoryNome,
      descricao: this.categoryDescricao
    });

    this.categoryNome = '';
    this.categoryDescricao = '';
    this.visivel = false;

  }

}
