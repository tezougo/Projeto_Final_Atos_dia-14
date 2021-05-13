import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente3',
  templateUrl: './componente3.component.html',
  styleUrls: ['./componente3.component.css']
})
export class Componente3Component implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  // tslint:disable-next-line:typedef
  inputFileChange(event){ // criando metodo para componente3 html

    if(event.target.file && event.target.file[0]){ // veriica se tem algum arquivo

      const arquivo = event.target.file[0];
      const formData = new FormData();
      formData.append('arquivo', arquivo);

      this.http.post('http://localhost:8080/usuariouploads', formData).subscribe(resposta => console.log('Upload ok!' + arquivo + ''));
    }
  }
}
