import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Componente2Component } from './componente2/componente2.component';
import { ComponenteServicoComponent } from './componente-servico/componente-servico.component';
import { ComponenteServico2Component } from './componente-servico2/componente-servico2.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    Componente2Component,
    ComponenteServicoComponent,
    ComponenteServico2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
