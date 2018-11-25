import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service'
import { CalcularCantidadResponse } from '../model/model'

@Component({
  selector: 'app-listado-salida',
  templateUrl: './listado-salida.component.html',
  styleUrls: ['./listado-salida.component.css']
})
export class ListadoSalidaComponent implements OnInit {

	response: CalcularCantidadResponse;

	constructor(private _hs: HttpService) {
		this._hs.consultarCantidades().subscribe((response: CalcularCantidadResponse) => {
			this._hs.response = response;
			this.response = response;
		})
	}

	ngOnInit() {
		this.response = new CalcularCantidadResponse();
	}

}
