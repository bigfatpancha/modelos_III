package com.example.demo.tp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	private String id;
	private String descripcion;
	private double costo;
	private double costoAlmacenamiento;
	private double costoDeOrden;
	private double precioVenta;
	private Integer stock;
	private Integer demandaEstimada;
	
	
	public Producto() {}

	public String getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getCosto() {
		return costo;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getDemandaEstimada() {
		return demandaEstimada;
	}

	public void setDemandaEstimada(Integer demandaEstimada) {
		this.demandaEstimada = demandaEstimada;
	}

	public double getCostoAlmacenamiento() {
		return costoAlmacenamiento;
	}

	public void setCostoAlmacenamiento(double costoAlmacenamiento) {
		this.costoAlmacenamiento = costoAlmacenamiento;
	}

	public double getCostoDeOrden() {
		return costoDeOrden;
	}

	public void setCostoDeOrden(double costoDeOrden) {
		this.costoDeOrden = costoDeOrden;
	}

}
