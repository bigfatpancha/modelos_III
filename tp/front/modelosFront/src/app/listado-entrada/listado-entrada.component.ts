import { Component, OnInit } from '@angular/core';

import { HttpService } from '../http.service'
import { Producto, CalcularCantidadResponse, ProductoRequest } from '../model/model'

@Component({
  selector: 'app-listado-entrada',
  templateUrl: './listado-entrada.component.html',
  styleUrls: ['./listado-entrada.component.css']
})
export class ListadoEntradaComponent implements OnInit {

	datos:ProductoRequest;
  response: CalcularCantidadResponse;

  constructor(private _hs: HttpService) {
    this.datos = this._hs.request;
    console.log(this.datos)
  }

  ngOnInit() {
    this._hs.agregarProducto.subscribe((nuevoProducto:Producto) => {
      this.datos.data.push(nuevoProducto);
      this._hs.request = this.datos;
    });
  }

}
