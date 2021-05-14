import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api/menuitem';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  items: MenuItem[];
  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.items = [
      { label: 'Início', icon: 'pi pi-fw pi-home', routerLink: ['/'] },
      {
        label: 'Login',
        icon: 'pi pi-fw pi-cog',
        routerLink: ['/login-page'],
      },
      {
        label: 'Cadastro',
        icon: 'pi pi-fw pi-pencil',
        routerLink: ['/newcadastro-page'],
      },
    ];
  }
}
