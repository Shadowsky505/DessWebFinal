package com.inventario.iniciador.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventario.iniciador.models.Administradores;

@Repository
public interface IAdministradores extends CrudRepository<Administradores, Integer> {
    Optional<Administradores> findByCorreoAndContrasena(String correo, String contrasena);
}
