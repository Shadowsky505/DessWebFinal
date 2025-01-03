package com.inventario.iniciador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventario.iniciador.interfaceService.IDatosServicio;
import com.inventario.iniciador.interfaceService.ISensoresServicio;
import com.inventario.iniciador.models.Datos;
import com.inventario.iniciador.models.Sensores;

@Controller
@RequestMapping("/datos")
public class DatosController {

    @Autowired
    private IDatosServicio datosServicio;

    @Autowired
    private ISensoresServicio sensoresServicio;

    @GetMapping
    public String listarDatos(Model model) {
        List<Datos> listaDatos = datosServicio.listar(); // Verifica que este método no retorne null
        model.addAttribute("datos", listaDatos);
        return "datos";
    }

    @GetMapping("/agregar")
    public String agregarDato(Model model) {
        List<Sensores> sensores = sensoresServicio.listar();
        model.addAttribute("sensores", sensores);
        model.addAttribute("dato", new Datos());
        return "addDatos";
    }

    @PostMapping("/guardar")
    public String guardarDato(@ModelAttribute Datos dato, RedirectAttributes redirectAttributes) {
        datosServicio.guardar(dato);
        redirectAttributes.addFlashAttribute("mensaje", "Dato guardado con éxito.");
        return "redirect:/datos";
    }

    @GetMapping("/editar/{id}")
    public String editarDatos(@PathVariable int id, Model model) {
        Optional<Datos> datos = datosServicio.listarId(id);
        if (datos.isPresent()) {
            model.addAttribute("dato", datos.get()); // Nota: Usar "dato" para coincidir con el HTML
            model.addAttribute("sensores", sensoresServicio.listar()); // Lista para el select
            return "editarDatos";
        }
        return "redirect:/datos";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarDato(@PathVariable int id, RedirectAttributes redirectAttributes) {
        datosServicio.borrar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Dato eliminado con éxito.");
        return "redirect:/datos";
    }
}

