import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { CarouselModule } from 'ngx-owl-carousel-o';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ControllerService } from './controller/controller.service';
import { AuthService } from './controller/auth.service';

import { HomeComponent } from './view/home/home.component';
import { FaqComponent } from './view/faq/faq.component';
import { MinhasAulasComponent } from './view/minhas-aulas/minhas-aulas.component';
import { MarcacoesComponent } from './view/marcacoes/marcacoes.component';
import { AtividadesComponent } from './view/atividades/atividades.component';
import { AulaComponent } from './view/aula/aula.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MinhasAulasComponent,
    MarcacoesComponent,
    FaqComponent,
    AtividadesComponent,
    AulaComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    CarouselModule
  ],
  providers: [AuthService, ControllerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
