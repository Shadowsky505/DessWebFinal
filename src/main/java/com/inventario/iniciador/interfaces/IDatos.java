package com.inventario.iniciador.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventario.iniciador.models.Datos;

@Repository
public interface IDatos extends CrudRepository<Datos, Integer>{

}
