import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteServico2Component } from './componente-servico2.component';

describe('ComponenteServico2Component', () => {
  let component: ComponenteServico2Component;
  let fixture: ComponentFixture<ComponenteServico2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteServico2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteServico2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
