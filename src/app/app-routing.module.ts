import { ComponenteServicoComponent } from './componente-servico/componente-servico.component';
import { Componente2Component } from './componente2/componente2.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComponenteServico2Component } from './componente-servico2/componente-servico2.component';

const routes: Routes = [
  {path: 'apresentação', component: Componente2Component},
  {path: 'album', component: ComponenteServicoComponent},
  {path: 'photo', component: ComponenteServico2Component}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})

export class AppRoutingModule { }
