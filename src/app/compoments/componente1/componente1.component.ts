import { Component, OnInit } from '@angular/core';
import { NewCadastro } from 'src/app/models/NewCadastro.model';
import { Servico1Service } from 'src/app/services/servico1.service';

@Component({
  selector: 'app-componente1',
  templateUrl: './componente1.component.html',
  styleUrls: ['./componente1.component.css'],
})
export class Componente1Component implements OnInit {
  error: any;
  constructor(private servico1: Servico1Service) {}

  newcadastro: NewCadastro[];
  usuario: string;
  senha: string;
  ngOnInit(): void {}
  // tslint:disable-next-line:typedef
  validaLogin() {
    this.servico1.getLogin().subscribe(
      (data: NewCadastro[]) => {
        this.newcadastro = data;
        console.log('O que retornou em dados: ', data);
        console.log('Variavel cadastro: ', this.newcadastro);
        if (this.newcadastro) {
          for (let aux of this.newcadastro) {
            if (this.usuario == aux.usuario && this.senha == aux.senha) {
              console.log('Usuario validado');
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
