import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoSalidaComponent } from './listado-salida.component';

describe('ListadoSalidaComponent', () => {
  let component: ListadoSalidaComponent;
  let fixture: ComponentFixture<ListadoSalidaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoSalidaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoSalidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
