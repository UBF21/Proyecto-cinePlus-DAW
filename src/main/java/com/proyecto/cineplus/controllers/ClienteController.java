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

import com.proyecto.cineplus.models.Cliente;
import com.proyecto.cineplus.repository.IClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	IClienteRepository repo;
	
	@GetMapping("/listado")
	public String listadoCliente(Model model) {
		model.addAttribute("listado", repo.findAll());
		model.addAttribute("cliente", new Cliente());
		return "MCliente";
	}
	
	@PostMapping("/Guardar")
	public String guardarCliente(@ModelAttribute(name = "cliente") Cliente cliente,Model model) {
		
		if (cliente != null) {
			repo.save(cliente);
			model.addAttribute("listado", repo.findAll());
			model.addAttribute("cliente", new Cliente());
			return "MCliente";
		}
		return "redirect:/cliente/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable int id,Model model) {
		Optional<Cliente> cliente = repo.findById(id);
		if (cliente.isPresent()) {			
			model.addAttribute("listado", repo.findAll());
			model.addAttribute("cliente", cliente);
			return "MCliente";
		}
		return "MCliente";
	}
}
