package com.example.demo.tp.model;

import java.util.List;

public class ListaDeProductos {
	
	private List<Producto> data;
	private double costoMaximoTotal;
	
	public ListaDeProductos() {}

	public List<Producto> getData() {
		return data;
	}

	public void setData(List<Producto> data) {
		this.data = data;
	}

	public double getCostoMaximoTotal() {
		return costoMaximoTotal;
	}

	public void setCostoMaximoTotal(double costoMaximoTotal) {
		this.costoMaximoTotal = costoMaximoTotal;
	}

}
