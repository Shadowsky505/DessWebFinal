package com.inventario.iniciador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class mainController {

    @GetMapping
    public String index(Model model) {
        // Puedes agregar datos al modelo si el index requiere mostrar información dinámica
        model.addAttribute("titulo", "Bienvenido a la Aplicación");
        return "index"; // Corresponde a la plantilla de `index.html`
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Corresponde a la plantilla de `login.html`
    }
}

