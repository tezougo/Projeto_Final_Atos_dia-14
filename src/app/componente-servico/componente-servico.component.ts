import { Photo } from './../models/Photo.model';
import { Component, OnInit } from '@angular/core';
import { Servico1Service } from '../services/servico1.service';
import { Album } from '../models/Album.model';

@Component({
  selector: 'app-componente-servico',
  templateUrl: './componente-servico.component.html',
  styleUrls: ['./componente-servico.component.css']
})
export class ComponenteServicoComponent implements OnInit {

  albums: Album;
  error: any;
  idAlbum: number = null;
  photo: Photo;
  idPhoto: number = null;

  constructor(private albumServico: Servico1Service) {
    this.getter();
  }

  ngOnInit(): void { }
    getter(){
      this.albumServico.getAlbum().subscribe
      (
        (data: Album) =>
        {
          this.albums = data;
          console.log('O que retornou em data: ', data);
          console.log('Variavel album: ', this.albums);
        },
        (error: any) =>
        {
          this.error = error;
          console.error('ERRO: ', this.error);
        }
      );
    }
}
