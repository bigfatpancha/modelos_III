package com.example.demo.tp.model;

import java.util.List;

public class ListaDeProductosResponse {
	
	private List<ProductoResponse> data;
	private double costoTotal;
	
	public ListaDeProductosResponse() {}

	public List<ProductoResponse> getData() {
		return data;
	}

	public void setData(List<ProductoResponse> data) {
		this.data = data;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

}
