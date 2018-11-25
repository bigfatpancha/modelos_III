import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service'

import { Producto } from '../model/model'

@Component({
  selector: 'app-nuevo',
  templateUrl: './nuevo.component.html',
  styleUrls: ['./nuevo.component.css']
})
export class NuevoComponent implements OnInit {

	nuevoProducto: Producto = new Producto(12, "", 0, 0, 0, 0, 0, 0)

	constructor(private _hs: HttpService) { }

	ngOnInit() {
	}

	confirmar() {
		console.log(this.nuevoProducto)
		this._hs.agregarNuevoProducto(this.nuevoProducto)
	}

}
