package com.inventario.iniciador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class mainController {

    @GetMapping
    public String index(Model model) {
        // Puedes agregar datos al modelo si el index requiere mostrar información dinámica
        model.addAttribute("titulo", "Bienvenido a la Aplicación");
        return "index"; // Corresponde a la plantilla de `index.html`
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        // Obtener el nombre del usuario desde la sesión
        String userName = (String) session.getAttribute("userName");

        if (userName == null) {
            // Si no hay usuario en la sesión, redirigir a login
            return "redirect:/login";
        }

        

        // Pasamos el nombre del usuario al modelo
        model.addAttribute("userName", userName);

        // Retornamos la vista dashboard.html
        return "dashboard";
    }

    @GetMapping("/loginForm")
    public String showLoginPage() {
        return "login";  // Esto solo es necesario si necesitas una vista HTML
    }
    

}

