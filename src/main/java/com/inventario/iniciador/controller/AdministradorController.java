package com.inventario.iniciador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventario.iniciador.interfaceService.IAdministradorServicio;
import com.inventario.iniciador.models.Administradores;

@Controller
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private IAdministradorServicio adminServicio;

    @GetMapping
    public String listarAdministradores(Model model) {
        model.addAttribute("administradores", adminServicio.listar());
        return "administradores";
    }

    @GetMapping("/nuevo")
    public String agregarAdministrador(Model model) {
        model.addAttribute("administrador", new Administradores());
        return "nuevoAdministrador";
    }

    @PostMapping("/guardar")
    public String guardarAdministrador(@ModelAttribute Administradores administrador, RedirectAttributes redirectAttributes) {
        adminServicio.guardar(administrador);
        redirectAttributes.addFlashAttribute("mensaje", "Administrador guardado con éxito.");
        return "redirect:/administradores";
    }

    @GetMapping("/editar/{id}")
    public String editarAdministrador(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Administradores> adminOpt = adminServicio.listarID(id);
        if (adminOpt.isPresent()) {
            model.addAttribute("administrador", adminOpt.get());
            return "editarAdministrador";
        }
        redirectAttributes.addFlashAttribute("error", "Administrador no encontrado.");
        return "redirect:/administradores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAdministrador(@PathVariable int id, RedirectAttributes redirectAttributes) {
        adminServicio.borrar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Administrador eliminado con éxito.");
        return "redirect:/administradores";
    }
}

