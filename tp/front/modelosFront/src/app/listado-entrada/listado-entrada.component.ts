import { Component, OnInit } from '@angular/core';

import { HttpService } from '../http.service'
import { Producto, CalcularCantidadResponse } from '../model/model'

@Component({
  selector: 'app-listado-entrada',
  templateUrl: './listado-entrada.component.html',
  styleUrls: ['./listado-entrada.component.css']
})
export class ListadoEntradaComponent implements OnInit {

	datos:Array<Producto> = []
  response: CalcularCantidadResponse;

  constructor(private _hs: HttpService) {
    this.datos = this._hs.request.data;
    console.log(this.datos)
  }

  ngOnInit() {
    this._hs.agregarProducto.subscribe((nuevoProducto:Producto) => {
      this.datos.push(nuevoProducto);
      this._hs.request.data = this.datos;
    });
  }

}
