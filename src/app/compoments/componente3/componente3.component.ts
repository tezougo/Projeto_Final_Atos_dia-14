import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { TabMenuModule } from 'primeng/tabmenu';

@Component({
  selector: 'app-componente3',
  templateUrl: './componente3.component.html',
  styleUrls: ['./componente3.component.css'],
})
export class Componente3Component implements OnInit {
  constructor(private http: HttpClient,) {}

    items: MenuItem[];
    activeItem: MenuItem;
    ngOnInit() {
        this.items = [{
            label: 'File',
            items: [
                {label: 'New', icon: 'pi pi-plus', url: 'http://www.primefaces.org/primeng'},
                {label: 'Open', icon: 'pi pi-download', routerLink: ['/pagename']},
                {label: 'Recent Files', icon: 'pi pi-download', routerLink: ['/pagename'], queryParams: {'recent': 'true'}}
            ]
        }]
        this.activeItem = this.items[0];
    }
}
