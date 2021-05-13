import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Servico1Service {

  constructor(private http: HttpClient) { }

  public getLogin(): Observable<any>
    {
      return this.http.get('http://localhost:8080/conta/login');
    }
  public postCadastro(usuario: string, email: string, senha: string): Observable<any>{
    return this.http.get('http://localhost:8080/conta/newcadastro' + usuario + '/' + email + '/' + senha);
  }
/*   public getUsuarioUploads(id): Observable<any>{
    return this.http.get('http://localhost:8080/usuariouploads' + id);

  } */
}
