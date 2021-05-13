import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewCadastro } from 'src/app/models/NewCadastro.model';
import { Servico1Service } from 'src/app/services/servico1.service';

@Component({
  selector: 'app-componente1',
  templateUrl: './componente1.component.html',
  styleUrls: ['./componente1.component.css'],
})
export class Componente1Component implements OnInit {
  error: any;
  router: any;
  constructor(private servico1: Servico1Service, router: Router) {
    this.router = router;
  }

  newcadastro: NewCadastro[];
  usuario: string;
  senha: string;
  ngOnInit(): void {}
  // tslint:disable-next-line:typedef
  validaLogin() {
    this.servico1.getLogin().subscribe(
      (data: NewCadastro[]) => {
        this.newcadastro = data;
        console.log('O que retornou em dados "set": ', data);
        console.log('Variavel cadastro: ', this.newcadastro);
        if (this.newcadastro) {
          for (let aux of this.newcadastro) {
            if (this.usuario == aux.usuario && this.senha == aux.senha) {
              console.log('Usuario validado');
              this.router.navigate(['/uploads-page'])
            }else{
              alert("Usuario não cadastrado!");
              this.router.navigate(['/newcadastro-page'])
              break;
            }
          }
        }
      },
      (error: any) => {
        this.error = error;
        console.log('Erro: ' + this.error);
      }
    );
  }
}
