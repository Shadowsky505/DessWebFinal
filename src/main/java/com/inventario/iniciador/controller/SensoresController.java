package com.inventario.iniciador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventario.iniciador.interfaceService.ISensoresServicio;
import com.inventario.iniciador.models.Sensores;

@Controller
@RequestMapping("/sensores")
public class SensoresController {

    @Autowired
    private ISensoresServicio sensorServicio;

    @GetMapping
    public String listarSensores(Model model) {
        model.addAttribute("sensores", sensorServicio.listar());
        return "sensores";
    }

    @GetMapping("/nuevo")
    public String agregarSensor(Model model) {
        model.addAttribute("sensor", new Sensores());
        return "nuevoSensor";
    }

    @PostMapping("/guardar")
    public String guardarSensor(@ModelAttribute Sensores sensor, RedirectAttributes redirectAttributes) {
        sensorServicio.guardar(sensor);
        redirectAttributes.addFlashAttribute("mensaje", "Sensor guardado con éxito.");
        return "redirect:/sensores";
    }

    @GetMapping("/editar/{id}")
    public String editarSensor(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Sensores> sensorOpt = sensorServicio.listarID(id);
        if (sensorOpt.isPresent()) {
            model.addAttribute("sensor", sensorOpt.get());
            return "editarSensor";
        }
        redirectAttributes.addFlashAttribute("error", "Sensor no encontrado.");
        return "redirect:/sensores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSensor(@PathVariable int id, RedirectAttributes redirectAttributes) {
        sensorServicio.borrar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Sensor eliminado con éxito.");
        return "redirect:/sensores";
    }
}

