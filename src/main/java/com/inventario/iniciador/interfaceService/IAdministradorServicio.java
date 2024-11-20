package com.inventario.iniciador.interfaceService;

import java.util.List;
import java.util.Optional;

import com.inventario.iniciador.models.Administradores;

public interface IAdministradorServicio {
    public List<Administradores> listar();
	public Optional<Administradores> listarID(int id);
	public int guardar(Administradores p);
	public void borrar(int id);
    Optional<Administradores> login(String correo, String contrasena);
}
