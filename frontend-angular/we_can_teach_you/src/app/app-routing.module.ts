import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AulaComponent } from './view/aula/aula.component';

import { FaqComponent } from './view/faq/faq.component';
import { HomeComponent } from './view/home/home.component';
import { MinhasAulasComponent } from './view/minhas-aulas/minhas-aulas.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'faq', component: FaqComponent},
  { path: 'minhas-aulas', component: MinhasAulasComponent },
  { path: 'aula/:classId/:subsection', component: AulaComponent },
  { path: 'professor/:professorId/aula/:classId/:subsection', component: AulaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
