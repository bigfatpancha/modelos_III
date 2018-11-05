import { Component } from '@angular/core';

import { HttpService } from '../http.service'

@Component({
  selector: 'app-listado-entrada',
  templateUrl: './listado-entrada.component.html',
  styleUrls: ['./listado-entrada.component.css']
})
export class ListadoEntradaComponent {

	datos: any = {}
  response: CalcularCantidadResponse;

  constructor(private _hs: HttpService) {
    this.datos = this._hs.datos
  }



}
