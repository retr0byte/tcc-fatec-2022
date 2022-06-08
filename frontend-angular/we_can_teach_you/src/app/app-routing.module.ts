import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AulaComponent } from './view/aula/aula.component';
import { FaqComponent } from './view/faq/faq.component';
import { HomeComponent } from './view/home/home.component';
import { MinhaContaComponent } from './view/minha-conta/minha-conta.component';
import { MinhasAulasComponent } from './view/minhas-aulas/minhas-aulas.component';
import { CategoriasComponent } from './view/categorias/categorias.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'faq', component: FaqComponent},
  { path: 'minhas-aulas', component: MinhasAulasComponent },
  { path: 'minha-conta', component: MinhaContaComponent },
  { path: 'aula/:classId/:subsection', component: AulaComponent },
  { path: 'professor/:professorId/aula/:classId/:subsection', component: AulaComponent },
  { path: 'categorias', component: CategoriasComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
