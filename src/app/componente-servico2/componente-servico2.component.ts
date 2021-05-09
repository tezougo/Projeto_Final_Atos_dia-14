import { Component, OnInit } from '@angular/core';
import { Photo } from '../models/Photo.model';
import { Servico1Service } from '../services/servico1.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-componente-servico2',
  templateUrl: './componente-servico2.component.html',
  styleUrls: ['./componente-servico2.component.css']
})
export class ComponenteServico2Component implements OnInit {

  IDa: string;
  photos: Photo;
  error: any;

  constructor(private photoServico: Servico1Service, private activateRoute: ActivatedRoute ) {
    this.getter();
  }

  ngOnInit(): void {
    this.IDa = this.activateRoute.snapshot.queryParams['albumId'];
    this.getter2();
  }
  getter()
  {
    this.photoServico.getPhoto().subscribe(
      // data =>
      (data: Photo) =>
      {
        this.photos = data;
        console.log('Variavel preenchida:', this.photos)
        console.log('recebido: ', data)
        // }, error =>
      }, (error: any) =>
      {
        this.error = error;
        console.error('ERROOO:', error);
      }
    );
  }

    getter2(){
      console.log('getter2');
      console.log(this.IDa);
      this.photoServico.getPhotosById(this.IDa).subscribe
      (
        (data: Photo) =>
        {
          this.photos = data;
          console.log('O que retornou em data: ', data);
          console.log('Variavel photos: ', this.photos);
        },
        (error: any) =>
        {
          this.error = error;
          console.error('ERRO: ', this.error);

        }
      );
    }



}
