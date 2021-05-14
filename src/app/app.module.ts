import { Componente2Component } from './compoments/componente2/componente2.component';
import { OrderModule } from 'ngx-order-pipe';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Componente1Component } from './compoments/componente1/componente1.component';
import { ButtonModule } from 'primeng/button';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InputTextModule } from 'primeng/inputtext';
import { Componente3Component } from './compoments/componente3/componente3.component';
import { FileUploadModule } from 'ng2-file-upload';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Componente0Component } from './compoments/componente0/componente0.component';
import { TabMenuModule } from 'primeng/tabmenu';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Componente4Component } from './compoments/componente4/componente4.component';

@NgModule({
  declarations: [
    AppComponent,
    Componente1Component,
    Componente2Component,
    Componente3Component,
    Componente0Component,
    Componente4Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    FormsModule,
    InputTextModule,
    InputTextareaModule,
    ButtonModule,
    FileUploadModule,
    MatInputModule,
    MatButtonModule,
    TabMenuModule,

  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
