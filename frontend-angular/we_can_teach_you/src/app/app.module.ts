import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ControllerService } from './controller/controller.service';
import { AuthService } from './controller/auth.service';

import { HomeComponent } from './view/home/home.component';
import { FaqComponent } from './view/faq/faq.component';
import { MinhasAulasComponent } from './view/minhas-aulas/minhas-aulas.component';
import { MarcacoesComponent } from './view/marcacoes/marcacoes.component';
import { AtividadesComponent } from './view/atividades/atividades.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MinhasAulasComponent,
    MarcacoesComponent,
    FaqComponent,
    AtividadesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AuthService, ControllerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
