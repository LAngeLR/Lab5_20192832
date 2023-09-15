package com.example.lab5gtics.controller;

import com.example.lab5gtics.entity.Lugares;
import com.example.lab5gtics.entity.Mascotas;
import com.example.lab5gtics.entity.Viajes;
import com.example.lab5gtics.repository.LugaresRepository;
import com.example.lab5gtics.repository.MascotasRepository;
import com.example.lab5gtics.repository.PersonaRepository;
import com.example.lab5gtics.repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/Inicio")
public class HomeController {

    final ViajesRepository viajesRepository;
    final LugaresRepository lugaresRepository;
    final MascotasRepository mascotasRepository;
    final PersonaRepository personaRepository;

    public HomeController(ViajesRepository viajesRepository, LugaresRepository lugaresRepository, MascotasRepository mascotasRepository, PersonaRepository personaRepository) {
        this.viajesRepository = viajesRepository;
        this.lugaresRepository = lugaresRepository;
        this.mascotasRepository = mascotasRepository;
        this.personaRepository = personaRepository;
    }


    @GetMapping("")
    public String mostrarInicio() {

        return "inicio";
    }

    @GetMapping("/listaViajes")
    public String listarViajes(Model model) {

        List<Viajes> viajes = viajesRepository.findAll();
        model.addAttribute("listaViajes",viajes);

        return "listaViajes";
    }

    @GetMapping("/listaMascotas")
    public String listarMascotas(Model model) {

        List<Mascotas> mascotas = mascotasRepository.findAll();
        model.addAttribute("listaMascotas",mascotas);


        return "listaMascotas";
    }

    @GetMapping("/listaLugares")
    public String listarLugares(Model model) {

        List<Lugares> lugares = lugaresRepository.findAll();
        model.addAttribute("listaLugares",lugares);

        return "listaLugares";
    }

    @GetMapping("/nuevoViaje")
    public String nuevoProductoFrm(Model model) {
        model.addAttribute("listaPersonas",personaRepository.findAll());
        model.addAttribute("listaLugares",lugaresRepository.findAll());
        return "product/nuevoViaje";
    }

    @GetMapping("/editViaje")
    public String editarViaje(Model model, @RequestParam("id") int id) {

        Optional<Viajes> optProduct = viajesRepository.findById(id);

        if (optProduct.isPresent()) {
            Viajes viajes = optProduct.get();
            model.addAttribute("viaje", viajes);
            model.addAttribute("listaPersonas",personaRepository.findAll());
            model.addAttribute("listaLugares",lugaresRepository.findAll());
            return "Inicio/editViaje";
        } else {
            return "redirect:/Inicio/listaPersonas";
        }
    }

    @PostMapping("/guardarViaje")
    public String guardarViaje(Viajes viajes, RedirectAttributes attr) {
        viajesRepository.save(viajes);
        return "redirect:/Inicio";
    }

    @GetMapping("/borrarViaje")
    public String borrarViaje(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Viajes> optProduct = viajesRepository.findById(id);

        if (optProduct.isPresent()) {
            viajesRepository.deleteById(id);
        }
        return "redirect:/Inicio";

    }

    @GetMapping("/delete")
    public String borrarViaje(Model model,
                              @RequestParam("id") int id,
                              RedirectAttributes attr) {

        Optional<Mascotas> optProduct = mascotasRepository.findById(id);

        if (optProduct.isPresent()) {
            mascotasRepository.deleteById(id);
        }
        return "redirect:/Inicio/listaMascotas";

    }


}
