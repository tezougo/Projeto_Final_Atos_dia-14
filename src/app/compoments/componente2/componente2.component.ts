import { Component, OnInit } from '@angular/core';
import { NewCadastro } from 'src/app/models/NewCadastro.model';
import { Servico1Service } from 'src/app/services/servico1.service';

@Component({
  selector: 'app-componente2',
  templateUrl: './componente2.component.html',
  styleUrls: ['./componente2.component.css'],
})
export class Componente2Component implements OnInit {
  error: any;
  constructor(private servico1: Servico1Service) {}

  newcadastro: NewCadastro[];
  usuario: string;
  senha: string;
  email: string;
  ngOnInit(): void {}

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
            }
          }
          this.servico1
            .postCadastro(this.usuario, this.email, this.senha)
            .subscribe();
        }
      },
      (error: any) => {
        this.error = error;
        console.log('Erro: ' + this.error);
      }
    );
  }
}
