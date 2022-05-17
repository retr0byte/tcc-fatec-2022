import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MinhasAulasComponent } from './minhas-aulas/minhas-aulas.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'minhas-aulas', component: MinhasAulasComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
