import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccessComponent } from './access/access.component';
import { HomeComponent } from './home/home.component';

import { FaqComponent } from './faq/faq.component';

import { MinhasAulasComponent } from './minhas-aulas/minhas-aulas.component';
import { MarcacoesComponent } from './marcacoes/marcacoes.component';
import { AtividadesComponent } from './atividades/atividades.component';


@NgModule({
  declarations: [
    AppComponent,
    AccessComponent,
    HomeComponent,
    MinhasAulasComponent,
    MarcacoesComponent,
    FaqComponent,
    AtividadesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
