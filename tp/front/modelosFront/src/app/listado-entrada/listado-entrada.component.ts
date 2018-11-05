import { Component, OnInit } from '@angular/core';

import { HttpService } from '../http.service'

@Component({
  selector: 'app-listado-entrada',
  templateUrl: './listado-entrada.component.html',
  styleUrls: ['./listado-entrada.component.css']
})
export class ListadoEntradaComponent implements OnInit {

	datos: any = {}
  response: CalcularCantidadResponse;

  constructor(private _hs: HttpService) {
    this.datos = this._hs.datos
  }

  ngOnInit() {
    this._hs.agregarProducto.subscribe(nuevoProducto => {
      this.datos.data.push(nuevoProducto);
      this._hs.datos = this.datos;
    });
  }

}
