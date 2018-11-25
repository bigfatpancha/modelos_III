package com.example.demo.tp.model;

import java.util.Comparator;

public class PriotityComparator implements Comparator<Producto> {

	@Override
	public int compare(Producto p1, Producto p2) {
		if(p1.getDemandaEstimada() < p2.getDemandaEstimada())
			return 1;
		if(p1.getDemandaEstimada() > p2.getDemandaEstimada())
			return -1;
		if(p1.getCosto() > p2.getCosto())
			return 1;
		if(p1.getCosto() < p2.getCosto())
			return -1;
		return 0;
	}

}
