package com.inventario.iniciador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.iniciador.interfaceService.IAdministradorServicio;
import com.inventario.iniciador.models.Administradores;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private IAdministradorServicio administradorServicio;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Administradores> admin = administradorServicio.login(loginRequest.getCorreo(), loginRequest.getContrasena());

        if (admin.isPresent()) {
            return ResponseEntity.ok(admin.get());
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    // DTO para el cuerpo de la solicitud de login
    public static class LoginRequest {
        private String correo;
        private String contrasena;

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getContrasena() {
            return contrasena;
        }

        public void setContrasena(String contrasena) {
            this.contrasena = contrasena;
        }
    }
}