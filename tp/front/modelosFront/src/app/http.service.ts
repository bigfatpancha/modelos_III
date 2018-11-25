import { Injectable, Output, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { CalcularCantidadResponse, Producto, ProductoRequest } from './model/model'
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

	httpOptions = {
		headers: new HttpHeaders({ 
			'content-type': 'application/json',
			'accept': 'application/json',
			'Access-Control-Allow-Origin': '*'
		})
	};

	private url = 'http://localhost:8080/local/stock/optimizado';
    request:ProductoRequest = new ProductoRequest();
    

	response:CalcularCantidadResponse = new CalcularCantidadResponse();
	nuevoProducto: Producto;
	@Output() agregarProducto: EventEmitter<Producto> = new EventEmitter();

	constructor(private http: HttpClient) {
		let data:Array<Producto> = []
		let p1: Producto = new Producto(1, "Remeras", 150, 0.01, 600, 650, 0, 200);
		let p2: Producto = new Producto(2, "Musculosas", 100, 0.01, 600, 400, 0, 120)
		let p3: Producto = new Producto(3, "Bermudas", 200, 0.01, 600, 800, 0, 150);
		let p4: Producto = new Producto(4, "Pantalones", 250, 0.015, 600, 900, 0, 100);
		let p5: Producto = new Producto(5, "Shorts", 100, 0.01, 600, 400, 0, 150);
		let p6: Producto = new Producto(6, "Mallas", 450, 0.01, 600, 1500, 0, 0);

		data.push(p1);
		data.push(p2);
		data.push(p3);
		data.push(p4);
		data.push(p5);
		data.push(p6);
		this.request.data = data;
	}

	consultarCantidades(): Observable<CalcularCantidadResponse>{
		return this.http.post<CalcularCantidadResponse>(this.url, this.request, this.httpOptions);
	}

	agregarNuevoProducto(nuevoProducto: Producto) {
	    this.nuevoProducto = nuevoProducto;
		this.agregarProducto.emit(this.nuevoProducto);
	}

}
