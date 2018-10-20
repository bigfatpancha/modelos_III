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
	private double precioVenta;
	
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

}
