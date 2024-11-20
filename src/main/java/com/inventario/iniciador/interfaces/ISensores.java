package com.inventario.iniciador.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventario.iniciador.models.Sensores;

@Repository
public interface ISensores extends CrudRepository<Sensores, Integer> {

    
}
