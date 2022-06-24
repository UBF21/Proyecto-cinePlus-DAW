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

import com.proyecto.cineplus.models.Proveedor;
import com.proyecto.cineplus.repository.IProveedorRepository;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorRepository repoProveedor;
	
	@GetMapping("/listado")
	public String listadoProveedor(Model model) {
		
		model.addAttribute("listado", repoProveedor.findAll());
		model.addAttribute("proveedor", new Proveedor());
		return "MProveedor";
	}
	
	@PostMapping("/Guardar")
	public String guardarProveedor(@ModelAttribute(name = "proveedor") Proveedor proveedor,Model model) {
		
		if (proveedor != null) {
			repoProveedor.save(proveedor);
			
		}
		return "redirect:/proveedor/listado";

	}
	
	@GetMapping("/editar/{id}")
	public String editarProveedor(@PathVariable int id,Model model) {
		Optional<Proveedor> proveedor = repoProveedor.findById(id);
		if (proveedor.isPresent()) {
			System.out.println(proveedor.toString());
			model.addAttribute("listado", repoProveedor.findAll());
			model.addAttribute("proveedor", proveedor);
		}
		return "MProveedor";
	}
	
}