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

import com.proyecto.cineplus.models.Comestible;
import com.proyecto.cineplus.repository.IComestibleRepository;
import com.proyecto.cineplus.repository.IProveedorRepository;
import com.proyecto.cineplus.repository.ITipoComestibleRepository;

@Controller
@RequestMapping("/comestible")
public class ComestibleController {

	@Autowired
	private IComestibleRepository repoComestible;
	@Autowired
	private ITipoComestibleRepository repoTipoComestible;
	
	@Autowired
	private IProveedorRepository repoIProveedorRepository;
	
	@GetMapping("/listado")
	public String listadoComestible(@ModelAttribute(name = "comestible") Comestible comestible,Model model) {
		model.addAttribute("listado", repoComestible.findAll());
		model.addAttribute("comestible", new Comestible());
		model.addAttribute("cboComestible", repoTipoComestible.findAll());
		model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
		return "MComestible";
	}
	
	@PostMapping("/Guardar")
	public String guardarComestible(@ModelAttribute(name = "comestible") Comestible comestible,Model model) {
		
		if (comestible != null) {
			repoComestible.save(comestible);
			model.addAttribute("listado", repoComestible.findAll());
			model.addAttribute("cboComestible", repoTipoComestible.findAll());
			model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
			return "MComestible";
		}
		return "redirect:/comestible/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String editarComestible(@PathVariable String id,Model model ) {
		Optional<Comestible> comestible = repoComestible.findById(id);
		
		if (comestible.isPresent()) {
			model.addAttribute("listado", repoComestible.findAll());
			model.addAttribute("cboComestible", repoTipoComestible.findAll());
			model.addAttribute("comestible", comestible);
			model.addAttribute("cboProveedor", repoIProveedorRepository.findAll());
			return "MComestible";
		}
		return "redirect:/comestible/listado";
	}
}
