package com.inventario.iniciador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventario.iniciador.interfaceService.IAdministradorServicio;
import com.inventario.iniciador.interfaceService.IDatosServicio;
import com.inventario.iniciador.interfaceService.ISensoresServicio;

@Controller
@RequestMapping("/")
public class mainController {

    @Autowired
    private IAdministradorServicio administradoresServicio;

    @Autowired
    private ISensoresServicio sensoresServicio;

    @Autowired
    private IDatosServicio datosServicio;

    @GetMapping
    public String index(Model model) {
        // Puedes agregar datos al modelo si el index requiere mostrar información dinámica
        model.addAttribute("titulo", "Bienvenido a la Aplicación");
        return "index"; // Corresponde a la plantilla de `index.html`
    }

    @GetMapping("/dashboard")
    public String mostrarDashboard(Model model) {
        // Agregar las listas de administradores, sensores y datos al modelo
        model.addAttribute("administradores", administradoresServicio.listar());
        model.addAttribute("sensores", sensoresServicio.listar());
        model.addAttribute("datos", datosServicio.listar());

        // Retornar la vista del dashboard
        return "dashboard";
    }

    @GetMapping("/loginForm")
    public String showLoginPage() {
        return "login";  // Esto solo es necesario si necesitas una vista HTML
    }
    

}

