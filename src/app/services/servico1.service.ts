import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Servico1Service {

  constructor(private http: HttpClient) { }

  public getAlbum(): Observable<any>
    {
      return this.http.get('https://jsonplaceholder.typicode.com/albums');
    }
  public getPhoto(): Observable<any>
  {
    return this.http.get('https://jsonplaceholder.typicode.com/photos');

  }
  public getPhotosById(id): Observable<any>{
    return this.http.get('https://jsonplaceholder.typicode.com/photos?idAlbum=' + id);

  }
}
