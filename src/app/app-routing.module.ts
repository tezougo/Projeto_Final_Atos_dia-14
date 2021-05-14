import { Componente0Component } from './compoments/componente0/componente0.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Componente1Component } from './compoments/componente1/componente1.component';
import { Componente2Component } from './compoments/componente2/componente2.component';
import { Componente3Component } from './compoments/componente3/componente3.component';
import { Componente4Component } from './compoments/componente4/componente4.component';

const routes: Routes = [
  { path: '', component: Componente0Component},
  { path: 'login-page', component: Componente1Component },
  { path: 'newcadastro-page', component: Componente2Component },
  { path: 'uploads-page', component: Componente3Component },
  { path: 'tabela', component: Componente4Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})

export class AppRoutingModule { }
