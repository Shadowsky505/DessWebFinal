package com.inventario.iniciador.interfaceService;

import java.util.List;
import java.util.Optional;

import com.inventario.iniciador.models.Datos;

public interface IDatosServicio {
    public List<Datos> listar();
	public Optional<Datos> listarId(int id);
	public int guardar(Datos p);
	public void borrar(int id);	
}
