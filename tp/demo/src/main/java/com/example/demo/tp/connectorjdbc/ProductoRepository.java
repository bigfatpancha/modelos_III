package com.example.demo.tp.connectorjdbc;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.tp.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, String> {

}
