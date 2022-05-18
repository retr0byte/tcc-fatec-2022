import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccessComponent } from './access/access.component';
import { HomeComponent } from './home/home.component';
<<<<<<< HEAD
import { FaqComponent } from './faq/faq.component';
=======
import { MinhasAulasComponent } from './minhas-aulas/minhas-aulas.component';
>>>>>>> b468918defe928aefd936291ab824dcb3e5e48a0

@NgModule({
  declarations: [
    AppComponent,
    AccessComponent,
    HomeComponent,
<<<<<<< HEAD
    FaqComponent
=======
    MinhasAulasComponent
>>>>>>> b468918defe928aefd936291ab824dcb3e5e48a0
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
