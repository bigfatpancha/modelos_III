package com.example.demo.tp.connectorjdbc;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.tp.model.Venta;

public interface VentaRepository extends CrudRepository<Venta, Integer> {
	

}
