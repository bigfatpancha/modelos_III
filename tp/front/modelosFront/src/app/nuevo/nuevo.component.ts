import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nuevo',
  templateUrl: './nuevo.component.html',
  styleUrls: ['./nuevo.component.css']
})
export class NuevoComponent implements OnInit {

	nuevoProducto: any = {
		"id": "12",
        "descripcion": "",
        "costo": 0,
        "costoAlmacenamiento": 0,
        "costoAgotamiento": 0,
        "costoDeOrden": 0,
        "precioVenta": 0,
        "stock": 0,
        "demandaEstimada": 0

	}

	constructor() { }

	ngOnInit() {
	}

	confirmar() {
		console.log(this.nuevoProducto)
	}

}
