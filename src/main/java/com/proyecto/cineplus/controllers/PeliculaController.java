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


	@GetMapping("/listado")
	public String principal(Model model) {

		model.addAttribute("listadoTipoPelicula", repot.findAll());
		model.addAttribute("listadoPelicula", rep.findAll());
		model.addAttribute("movie", new Pelicula());
		return "MPelicula";
	}

	@PostMapping("/guardar")
	public String guardarPelicula(@ModelAttribute(name = "pelicula") Pelicula pelicula, Model model) {

		try {
			if (pelicula != null) {
				System.out.println(pelicula);
				rep.save(pelicula);
			}
			model.addAttribute("listadoTipoPelicula", repot.findAll());
			model.addAttribute("listadoPelicula", rep.findAll());
			model.addAttribute("pelicula", new Pelicula());
			model.addAttribute("mesage", "Successfully registered movie.");

		} catch (Exception e) {

			model.addAttribute("listadoTipoPelicula", repot.findAll());
			model.addAttribute("listadoPelicula", rep.findAll());
			model.addAttribute("pelicula", new Pelicula());
			model.addAttribute("errorMessager", "Error registering movie.");
			
		}
		return "MPelicula";

	}

	
	  @GetMapping("/editar{id}") 
	  public String editPelicula(@PathVariable int id, Model model) {
	  
	  Optional<Pelicula> pelicula = rep.findById(id); 
	  		if(pelicula.isPresent()) {
		  	model.addAttribute("listadoTipoPelicula", repot.findAll());
			model.addAttribute("listadoPelicula", rep.findAll());
			model.addAttribute("movie",pelicula); 
			return "MPelicula";
	  
	  }  
	  	return "MPelicula";
	  				
	  }
	  
	  @GetMapping("/eliminar{id}") 
	  public String eliminarPelicula(@PathVariable int id, Model model) {
	  
	  Optional<Pelicula> pelicula = rep.findById(id); 
	  		if(pelicula.isPresent()) {
		  	model.addAttribute("listadoTipoPelicula", repot.findAll());
			model.addAttribute("listadoPelicula", rep.findAll());
			model.addAttribute("movie",pelicula); 
			rep.deleteById(id);
			
	  
	  }  
	  	return "MPelicula";
	  				
	  }

}
