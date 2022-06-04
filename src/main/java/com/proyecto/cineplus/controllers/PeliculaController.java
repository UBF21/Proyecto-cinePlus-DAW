package com.proyecto.cineplus.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cineplus.models.Pelicula;
import com.proyecto.cineplus.repository.IPeliculaRepository;
import com.proyecto.cineplus.repository.ITipoPelicula;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {
	
	@Autowired
	IPeliculaRepository rep;
	
	@Autowired
	ITipoPelicula repot;

	@GetMapping("/list")
	public String listadoPelicula(Model model) {
		model.addAttribute("listTypeMovie", repot.findAll());
		model.addAttribute("listMovie", rep.findAll());
		model.addAttribute("pelicula", new Pelicula());
		return "MPelicula";
	}
	
	@PostMapping("/save")
	public String saveMovie(@ModelAttribute(name="pelicula")Pelicula pelicula, Model model) {
		
		try {
			if (pelicula != null) {
				rep.save(pelicula);
			}
			model.addAttribute("listTypeMovie", repot.findAll());
			model.addAttribute("listMovie", rep.findAll());
      		model.addAttribute("pelicula", new Pelicula());
			model.addAttribute("mensaje", "Successfull register");
			
		} catch (Exception e) {
			
			model.addAttribute("listTypeMovie", repot.findAll());
			model.addAttribute("listMovie", rep.findAll());
			model.addAttribute("pelicula", new Pelicula());
			model.addAttribute("mensajeError", "Error  register");
		}
		
		
		return "MPelicula";
	}
	
	@GetMapping("/editar/id")
	public String editPelicula(@PathVariable String id, Model model) {
		Optional<Pelicula> pelicula = rep.findById(id);
		if(pelicula.isPresent()) {
			model.addAttribute("list", rep.findAll());
			model.addAttribute("pelicula", pelicula);
		}
		return "MPelicula";
	}
	
	
}
