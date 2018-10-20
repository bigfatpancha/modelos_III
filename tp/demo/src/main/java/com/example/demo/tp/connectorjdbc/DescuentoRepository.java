package com.example.demo.tp.connectorjdbc;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.tp.model.Descuento;

public interface DescuentoRepository extends CrudRepository<Descuento, String> {

}
