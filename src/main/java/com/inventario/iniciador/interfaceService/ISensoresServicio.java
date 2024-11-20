package com.inventario.iniciador.interfaceService;

import java.util.List;
import java.util.Optional;

import com.inventario.iniciador.models.Sensores;

public interface ISensoresServicio {
    public List<Sensores> listar();
	public Optional<Sensores> listarID(int id);
	public int guardar(Sensores p);
	public void borrar(int id);
}
