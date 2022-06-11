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

		LlenarGuardar(model, new Pelicula());
		return "MPelicula";
	}

	@PostMapping("/guardar")
	public String guardarPelicula(@ModelAttribute Pelicula peliculas, Model model) {

		try {
			
			Pelicula pelicula = rep.findById(peliculas.getIdpeli()).get();
			LlenarGuardar(model, peliculas);
			model.addAttribute("mensajeCorrecto", "El ID ya existe");	
			

		} catch (Exception e) {

			String data = formulario(peliculas);
			
			if(data != null) {
				LlenarGuardar(model, peliculas);
				model.addAttribute("mensajeCorrecto", data);
				return "MPelicula";
			}else {
				rep.save(peliculas);
				LlenarGuardar(model, new Pelicula());
				model.addAttribute("mensajeCorrecto", "La pelicula fue registrada exitosamente");
				return "redirect:/pelicula/listado";
			}
		}
		return "MPelicula";

	}
	
	
	@GetMapping("/mostrar/{id}")
	public String muestraPelicula(@PathVariable String id, Model model) {
		
		try {
			Optional<Pelicula> pelicula = rep.findById(id);
			if (pelicula.isPresent()) {
				LlenarEdit(model, pelicula.get());
			}
		} catch (Exception e) {
			LlenarGuardar(model, new Pelicula());
			return "redirect:/pelicula/listado";
		}
		return "MPelicula";
	}

	
	  @PostMapping("/editar") 
	  public String editarPelicula(@ModelAttribute(name = "peliculas") Pelicula peliculas, Model model) {
	  
		  try {
			  String data = formulario(peliculas);
			  
			  if (data != null) {
				rep.save(peliculas);
				LlenarGuardar(null, new Pelicula());
				model.addAttribute("mensajeCorrecto", "Pelicula actualizada exitosamente");
			}else {
				LlenarEdit(model, peliculas);
				model.addAttribute("mensajeCorrecto", data);
				return "MPelicula";
			}
			
		} catch (Exception e) {
			LlenarEdit(model, peliculas);
			model.addAttribute("mensajeCorrecto", "Error al actualizar la pelicula");
			return "MPelicula";
		}
		  return "redirect:/pelicula/listado";
	  }
	  
	  @GetMapping("/eliminar{id}") 
	  public String eliminarPelicula(@PathVariable String id, Model model) {
	  
		  try {
			  Pelicula pelicula = rep.findById(id).get();
			  
			  if (pelicula != null) {
				pelicula.setEstado("I");
				rep.save(pelicula);
				LlenarGuardar(model, new Pelicula());
				model.addAttribute("mensajeCorrecto", "Pelicula Inactiva");
			}else {
				LlenarGuardar(model, new Pelicula());
				model.addAttribute("mensajeCorrecto", "Error al Inactivar la Pelicula");
			}
			
		} catch (Exception e) {
			LlenarGuardar(model, new Pelicula());
			model.addAttribute("mensajeCorrecto", "Error al Inactivar la pelicula");
			return "MPelicula";
		}
		  return "redirect:/pelicula/listado";
	
	  }
	  
	  
	  private String formulario(Pelicula pelicula) {
		  
		  if (pelicula.getIdpeli() == null || pelicula.getIdpeli().isEmpty()) {
			return "Error en el Codigo";
		}
		  else if (pelicula.getNombre() == null || pelicula.getNombre().isEmpty()) {
			  return "Error en el nombre";
		}else if (pelicula.getTipo_peli() == -1) {
			return "Error en el tipo de pelicula";
		}else if (pelicula.getFecha_estreno() == null || pelicula.getFecha_estreno().isEmpty()) {
			return "Error en la fecha de estreno";
		}else if (pelicula.getFecha_final() == null || pelicula.getFecha_final().isEmpty()) {
			return "Error en la fecha final";
		}else if (pelicula.getEstado() == null || pelicula.getEstado().isEmpty()) {
			return "Error en el estado";
		}
		  return null;
		  
	  }
	  
	  private void LlenarGuardar(Model model, Pelicula pelicula) {
		  model.addAttribute("estadoForm","/pelicula/guardar");
		  model.addAttribute("listadoTipoPelicula", repot.findAll());
		  model.addAttribute("listadoPelicula", rep.findAll());
		  model.addAttribute("peliculas", pelicula);
	  }
	  
	  private void LlenarEdit(Model model, Pelicula pelicula) {
		  model.addAttribute("estadoForm","/pelicula/editar");
		  model.addAttribute("listadoTipoPelicula", repot.findAll());
		  model.addAttribute("listadoPelicula", rep.findAll());
		  model.addAttribute("peliculas", pelicula);
	  }

}
