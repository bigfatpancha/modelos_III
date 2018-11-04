package com.example.demo.tp.model;

import java.util.List;

public class ListaDeProductos {
	
	private List<Producto> data;
	private double tasaInmovilizacionCapital;
	
	public ListaDeProductos() {}

	public List<Producto> getData() {
		return data;
	}

	public void setData(List<Producto> data) {
		this.data = data;
	}

	public double getTasaInmovilizacionCapital() {
		return tasaInmovilizacionCapital;
	}

	public void setTasaInmovilizacionCapital(double tasaInmovilizacionCapital) {
		this.tasaInmovilizacionCapital = tasaInmovilizacionCapital;
	}

}
