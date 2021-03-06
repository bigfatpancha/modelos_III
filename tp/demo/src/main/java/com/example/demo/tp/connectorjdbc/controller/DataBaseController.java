package com.example.demo.tp.connectorjdbc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.tp.connectorjdbc.DescuentoRepository;
import com.example.demo.tp.connectorjdbc.GastoFijoRepository;
import com.example.demo.tp.connectorjdbc.ProductoRepository;
import com.example.demo.tp.connectorjdbc.VentaRepository;
import com.example.demo.tp.model.Descuento;
import com.example.demo.tp.model.GastoFijo;
import com.example.demo.tp.model.Producto;
import com.example.demo.tp.model.Venta;

@Controller
@RequestMapping(path="/local")
public class DataBaseController {
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private DescuentoRepository descuentoRepository;
	@Autowired
	private GastoFijoRepository GastoFijoRepository;
	@Autowired
	private VentaRepository ventaRepository;
	
	@GetMapping(path="/producto/add")
	public @ResponseBody String addNewProducto (
			@RequestParam String descripcion, 
			@RequestParam double costo, 
			@RequestParam double precio_venta, 
			@RequestParam String id,
			@RequestParam Integer stock) {

		Producto p = new Producto();
		p.setId(id);
		p.setDescripcion(descripcion);
		p.setCosto(costo);
		p.setPrecioVenta(precio_venta);
		p.setStock(stock);
		productoRepository.save(p);
		return "Saved";
	}
	
	@GetMapping(path="/producto/all")
	public @ResponseBody Iterable<Producto> getAllProducto() {
		return productoRepository.findAll();
	}
	
	@GetMapping(path="/descuento/add")
	public @ResponseBody String addNewDescuento(
			@RequestParam double cantidad, 
			@RequestParam double porcentaje, 
			@RequestParam String id_producto) {

		Descuento d = new Descuento();
		d.setIdProducto(id_producto);
		d.setCantidad(cantidad);
		d.setPorcentaje(porcentaje);
		descuentoRepository.save(d);
		return "Saved";
	}
	
	@GetMapping(path="/descuento/all")
	public @ResponseBody Iterable<Descuento> getAllDescuento() {
		return descuentoRepository.findAll();
	}
	
	@GetMapping(path="/gastoFijo/add")
	public @ResponseBody String addNewGastoFijo(
			@RequestParam String descripcion, 
			@RequestParam double monto, 
			@RequestParam String id) {

		GastoFijo g = new GastoFijo();
		g.setId(id);
		g.setMonto(monto);
		g.setDescripcion(descripcion);
		GastoFijoRepository.save(g);
		return "Saved";
	}
	
	@GetMapping(path="/gastoFijo/all")
	public @ResponseBody Iterable<GastoFijo> getAllGastosFijos() {
		return GastoFijoRepository.findAll();
	}
	
	@GetMapping(path="/venta/add")
	public @ResponseBody String addNewVenta(
			@RequestParam String id_producto, 
			@RequestParam Integer cantidad,
			@RequestParam Date fecha) {

		Venta v = new Venta();
		v.setIdProducto(id_producto);
		v.setCantidad(cantidad);
		v.setFecha(fecha);
		ventaRepository.save(v);
		return "Saved";
	}
	
	@GetMapping(path="/venta/all")
	public @ResponseBody Iterable<Venta> getAllVentas() {
		return ventaRepository.findAll();
	}

}
