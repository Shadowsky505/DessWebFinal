package com.inventario.iniciador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.iniciador.interfaceService.IAdministradorServicio;
import com.inventario.iniciador.interfaces.IAdministradores;
import com.inventario.iniciador.models.Administradores;

@Service
public class AdministradorServicio implements IAdministradorServicio{
    @Autowired
	private IAdministradores repo;
	
	@Override
	public List<Administradores> listar() {
		return (List<Administradores>)repo.findAll();
	}

	@Override
	public Optional<Administradores> listarID(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public int guardar(Administradores p) {
		Administradores em = repo.save(p);
		if (!em.equals(null)) {
			return 1;
		}
		return 0;
	}

	@Override
	public void borrar(int id) {

		repo.deleteById(id);


	}

    @Override
    public Optional<Administradores> login(String correo, String contrasena) {
        return repo.findByCorreoAndContrasena(correo, contrasena);
    }

}
