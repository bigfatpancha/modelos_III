import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { CalcularCantidadResponse } from './model/model'
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

	const httpOptions = {
		headers: new HttpHeaders({ 
			'content-type': 'application/json',
			'accept': 'application/json',
			'Access-Control-Allow-Origin': '*'
		})
	};

	private url = 'http://localhost:8080/local/stock/optimizado';
	datos = {
    "tasaInmovilizacionCapital": 0.01,
    "data": [
	      {
	        "id": "1",
	        "descripcion": "Remeras",
	        "costo": 150,
	        "costoAlmacenamiento": 0.01,
	        "costoAgotamiento": 650,
	        "costoDeOrden": 600,
	        "precioVenta": 650,
	        "stock": 0,
	        "demandaEstimada": 200
	      },
	      {
	        "id": "2",
	        "descripcion": "Musculosas",
	        "costo": 100,
	        "costoAlmacenamiento": 0.01,
	        "costoAgotamiento": 400,
	        "costoDeOrden": 600,
	        "precioVenta": 400,
	        "stock": 0,
	        "demandaEstimada": 120
	      },
	      {
	        "id": "3",
	        "descripcion": "Bermudas",
	        "costo": 200,
	        "costoAlmacenamiento": 0.01,
	        "costoAgotamiento": 800,
	        "costoDeOrden": 600,
	        "precioVenta": 800,
	        "stock": 0,
	        "demandaEstimada": 150
	      },
	      {
	        "id": "4",
	        "descripcion": "Pantalones",
	        "costo": 250,
	        "costoAlmacenamiento": 0.015,
	        "costoAgotamiento": 900,
	        "costoDeOrden": 600,
	        "precioVenta": 900,
	        "stock": 0,
	        "demandaEstimada": 100
	      },
	      {
	        "id": "5",
	        "descripcion": "Shorts",
	        "costo": 100,
	        "costoAlmacenamiento": 0.01,
	        "costoAgotamiento": 400,
	        "costoDeOrden": 600,
	        "precioVenta": 400,
	        "stock": 0,
	        "demandaEstimada": 150
	      },
	      {
	        "id": "6",
	        "descripcion": "Mallas",
	        "costo": 450,
	        "costoAlmacenamiento": 0.01,
	        "costoAgotamiento": 1500,
	        "costoDeOrden": 600,
	        "precioVenta": 1500,
	        "stock": 0,
	        "demandaEstimada": 0
	      }
	    ]
	  }

	response: any = {}
	

	constructor(private http: HttpClient) { }

	consultarCantidades(): Observable<CalcularCantidadResponse>{
		return this.http.post<?>(this.url, this.datos, this.httpOptions);
	}

	

}
