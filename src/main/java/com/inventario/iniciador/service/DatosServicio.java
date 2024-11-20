package com.inventario.iniciador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.iniciador.interfaceService.IDatosServicio;
import com.inventario.iniciador.interfaces.IDatos;
import com.inventario.iniciador.models.Datos;

@Service
public class DatosServicio implements IDatosServicio{

	@Autowired
	private IDatos repo;
	
	@Override
	public List<Datos> listar() {
		return (List<Datos>)repo.findAll();
	}

	@Override
	public Optional<Datos> listarId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public int guardar(Datos p) {
		Datos em = repo.save(p);
		if (!em.equals(null)) {
			return 1;
		}
		return 0;
	}

	@Override
	public void borrar(int id) {

		repo.deleteById(id);

	}

}
