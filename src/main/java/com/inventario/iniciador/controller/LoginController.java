package com.inventario.iniciador.controller;

import com.inventario.iniciador.models.Administradores;
import com.inventario.iniciador.models.LoginRequest;
import com.inventario.iniciador.service.AdministradorServicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController  // Cambiar a RestController para manejar respuestas JSON
public class LoginController {

    @Autowired
    private AdministradorServicio administradorServicio;

    // Página de login (si necesitas devolver una vista HTML, este método debería estar en un controlador diferente)
    

    // Lógica para manejar el inicio de sesión
    @PostMapping("/login")  // Asegúrate de que la ruta esté correctamente mapeada
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String correo = loginRequest.getCorreo();
        String contrasena = loginRequest.getContrasena();

        System.out.println("Correo: " + correo);
        System.out.println("Contraseña: " + contrasena);
        // Autenticar al administrador usando correo y contraseña
        Optional<Administradores> administrador = administradorServicio.login(correo, contrasena);

        // Si el usuario no existe, devolver error
        if (!administrador.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
        }

        // Redirigir o devolver respuesta exitosa
        return ResponseEntity.ok("Login successful");
    }
}
