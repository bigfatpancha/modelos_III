package com.example.demo.tp.gestion.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.tp.model.ListaDeProductos;
import com.example.demo.tp.model.ListaDeProductosResponse;
import com.example.demo.tp.model.PriotityComparator;
import com.example.demo.tp.model.Producto;
import com.example.demo.tp.model.ProductoResponse;

@Controller
@RequestMapping(path="/local/stock")
public class StockController {
	
	@CrossOrigin
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
	
	private ListaDeProductosResponse getOptimizedStock(ListaDeProductos productos) throws Exception {
		ListaDeProductosResponse listaDeProductosResponse = new ListaDeProductosResponse();
		productos.getData().sort(new PriotityComparator());
		List<ProductoResponse> lista = new ArrayList<>();
		double costoTotal;
		costoTotal = obtenerStockOptimizadoDelListadoDeProductos(productos, lista);
		listaDeProductosResponse.setData(lista);
		listaDeProductosResponse.setCostoTotal(costoTotal);
		return listaDeProductosResponse;
	}

	private double obtenerStockOptimizadoDelListadoDeProductos(ListaDeProductos productos, List<ProductoResponse> lista)
			throws Exception {
		boolean salir = false;
		double costoTotal = 0;
		for(Producto p: productos.getData()) {
			ProductoResponse pr = new ProductoResponse();
			try {
				double cantidadAComprar = Math.ceil(cantidadOptimaConsiderandoStockActual(p));
				double costoTotalPorProducto = cantidadAComprar * p.getCosto();
				costoTotal += costoTotalPorProducto;
				if(superaCostoMaximo(productos, costoTotal)) {
					salir = true;
					double excedente = costoTotal - productos.getCostoMaximoTotal();
					cantidadAComprar = cantidadAComprar - (excedente/p.getCosto());
					costoTotal -= costoTotalPorProducto;
					costoTotalPorProducto = cantidadAComprar * p.getCosto();
					costoTotal += costoTotalPorProducto;
				}
				pr.setCantidadAComprar(cantidadAComprar);
				pr.setCostoTotal(costoTotalPorProducto);
			} catch(Exception e) {
				throw e;
			}
			pr.setDescripcion(p.getDescripcion());
			lista.add(pr);
			if(salir)
				break;
		}
		return costoTotal;
	}

	private boolean superaCostoMaximo(ListaDeProductos productos, double costoTotal) {
		return costoTotal > productos.getCostoMaximoTotal();
	}

	private double cantidadOptimaConsiderandoStockActual(Producto producto) {
		double cantidadOptima = 0;
		try {
			cantidadOptima = calcularStockOptimo(producto);
		} catch(Exception e) {
			throw e;
		}
		return (cantidadOptima - producto.getStock()) > 0 ? cantidadOptima - producto.getStock() : 0;
	}
	
	private double calcularStockOptimo(Producto producto) {
		double b = producto.getCosto();
		double c1_prima = producto.getCostoAlmacenamiento();
		double c1 = b*c1_prima;
		double k = producto.getCostoDeOrden();
		double d = producto.getDemandaEstimada();
		double numeradorPrimerTermino = 2*k*d;
		try {
			double primerTermino = numeradorPrimerTermino/c1;
			return Math.sqrt(primerTermino);
		} catch(Exception e) {
			throw e;
		}
	}
	
	private void priorizarSegunMontoMaximo(double maximo, ArrayList<ProductoResponse> productosResponse, ArrayList<Producto> productos) {
		for(Producto p : productos) {
			// establecer prioridades
		}
		// recalcular cantidades
		// verificar costo total
	}

}
