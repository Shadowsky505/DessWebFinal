package com.inventario.iniciador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventario.iniciador.interfaceService.IDatosServicio;
import com.inventario.iniciador.models.Datos;

@Controller
@RequestMapping("/datos")
public class DatosController {

    @Autowired
    private IDatosServicio datosServicio;

    @GetMapping
    public String listarDatos(Model model) {
        List<Datos> listaDatos = datosServicio.listar(); // Verifica que este método no retorne null
        model.addAttribute("datos", listaDatos);
        return "datos";
    }

    @GetMapping("/nuevo")
    public String agregarDato(Model model) {
        model.addAttribute("dato", new Datos());
        return "nuevoDato";
    }

    @PostMapping("/guardar")
    public String guardarDato(@ModelAttribute Datos dato, RedirectAttributes redirectAttributes) {
        datosServicio.guardar(dato);
        redirectAttributes.addFlashAttribute("mensaje", "Dato guardado con éxito.");
        return "redirect:/datos";
    }

    @GetMapping("/editar/{id}")
    public String editarDato(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Datos> datoOpt = datosServicio.listarId(id);
        if (datoOpt.isPresent()) {
            model.addAttribute("dato", datoOpt.get());
            return "editarDato";
        }
        redirectAttributes.addFlashAttribute("error", "Dato no encontrado.");
        return "redirect:/datos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDato(@PathVariable int id, RedirectAttributes redirectAttributes) {
        datosServicio.borrar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Dato eliminado con éxito.");
        return "redirect:/datos";
    }
}

