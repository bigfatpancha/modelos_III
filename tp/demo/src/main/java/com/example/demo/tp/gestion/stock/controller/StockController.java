package com.example.demo.tp.gestion.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.tp.model.ListaDeProductos;
import com.example.demo.tp.model.ListaDeProductosResponse;
import com.example.demo.tp.model.Producto;
import com.example.demo.tp.model.ProductoResponse;

@Controller
@RequestMapping(path="/local/stock")
public class StockController {
	
	@RequestMapping(value ="/optimizado", method = RequestMethod.POST)
	public ResponseEntity<?> gestionStockPOptimizadoPost(
			@RequestBody ListaDeProductos listaDeProductos) {
		ListaDeProductosResponse lista = new ListaDeProductosResponse();
		try {
			lista = getOptimizedStock(listaDeProductos);
		} catch(Exception e) {
			return new ResponseEntity<String>("Oop, division por cero =/", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ListaDeProductosResponse>(lista, HttpStatus.OK);
	}
	
	private ListaDeProductosResponse getOptimizedStock(ListaDeProductos productos) {
		ListaDeProductosResponse listaDeProductosResponse = new ListaDeProductosResponse();
		List<ProductoResponse> lista = new ArrayList<>();
		for(Producto p: productos.getData()) {
			ProductoResponse pr = new ProductoResponse();
			try {
				pr.setCantidadAComprar(Math.ceil(cantidadOptimaConsiderandoStockActual(p)));
			} catch(Exception e) {
				throw e;
			}
			pr.setDescripcion(p.getDescripcion());
			lista.add(pr);
		}
		listaDeProductosResponse.setData(lista);
		return listaDeProductosResponse;
	}
	
	private double cantidadOptimaConsiderandoStockActual(Producto producto) {
		double cantidadOptima = 0;
		try {
			cantidadOptima = calcularCantidadOptimaConAgotamiento(producto);
		} catch(Exception e) {
			throw e;
		}
		return (cantidadOptima - producto.getStock()) > 0 ? cantidadOptima - producto.getStock() : 0;
	}
	
	private double stockOptimoATener(Producto producto) {
		double stockOptimo = 0;
		try {
			stockOptimo = calcularStockOptimo(producto);
		} catch(Exception e) {
			throw e;
		}
		return stockOptimo;
	}
	
	private double calcularStockOptimo(Producto producto) {
		double b = producto.getCosto();
		double c1_prima = producto.getCostoAlmacenamiento();
		double c1 = b*c1_prima;
		double c2 = producto.getCostoAgotamiento();
		double k = producto.getCostoDeOrden();
		double d = producto.getDemandaEstimada();
		double numeradorPrimerTermino = 2*k*d;
		double denominadorSegundoTermino = c1 + c2;
		try {
			double primerTermino = numeradorPrimerTermino/c1;
			double raizPrimerTermino = Math.sqrt(primerTermino);
			double segundoTermino = c2/denominadorSegundoTermino;
			double raizSegundoTermino = Math.sqrt(segundoTermino);
			return raizPrimerTermino * raizSegundoTermino;
		} catch(Exception e) {
			throw e;
		}
	}
	
	private double calcularCantidadOptimaConAgotamiento(Producto producto) {
		double b = producto.getCosto();
		double c1_prima = producto.getCostoAlmacenamiento();
		double c1 = b*c1_prima;
		double c2 = producto.getCostoAgotamiento();
		double k = producto.getCostoDeOrden();
		double d = producto.getDemandaEstimada();
		double numeradorPrimerTermino = 2*k*d;
		double numeradorSegundoTermino = c1 + c2;
		try {
			double primerTermino = numeradorPrimerTermino/c1;
			double raizPrimerTermino = Math.sqrt(primerTermino);
			double segundoTermino = numeradorSegundoTermino/c2;
			double raizSegundoTermino = Math.sqrt(segundoTermino);
			return raizPrimerTermino * raizSegundoTermino;
		} catch(Exception e) {
			throw e;
		}
		
	}

}
