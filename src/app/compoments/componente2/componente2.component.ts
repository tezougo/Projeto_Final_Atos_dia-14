import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewCadastro } from 'src/app/models/NewCadastro.model';
import { Servico1Service } from 'src/app/services/servico1.service';

@Component({
  selector: 'app-componente2',
  templateUrl: './componente2.component.html',
  styleUrls: ['./componente2.component.css'],
})
export class Componente2Component implements OnInit {
  error: any;
  router: Router;
  constructor(private servico1: Servico1Service, router: Router) {
    this.router = router;
  }

  newcadastro: boolean;
  usuario: string;
  senha: string;
  email: string;

  ngOnInit(): void {}

  adicionaUsuario() {
    if (this.usuario == null || this.email == null || this.senha == null) {
      this.newcadastro = false;
    } else {
      this.servico1
        .postCadastro(this.usuario, this.email, this.senha)
        .subscribe(
          (data: boolean) => {
            this.newcadastro = data;
            if (this.newcadastro) {
              this.router.navigate(['/login-page']);
            }
          },
          (error: any) => {
            this.error = error;
            console.log('Erro >> ' + this.error);
          }
        );
    }
  }
}
