package com.example.demo.tp.model;

public class ProductoResponse {
	
	private String descripcion;
	private double cantidadAComprar;
//	private double stockOptimo; 
	
	public ProductoResponse(){}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCantidadAComprar() {
		return cantidadAComprar;
	}

	public void setCantidadAComprar(double cantidadAComprar) {
		this.cantidadAComprar = cantidadAComprar;
	}

//	public double getStockOptimo() {
//		return stockOptimo;
//	}
//
//	public void setStockOptimo(double stockOptimo) {
//		this.stockOptimo = stockOptimo;
//	}

}
