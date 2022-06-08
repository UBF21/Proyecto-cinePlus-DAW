package com.proyecto.cineplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.cineplus.models.Cliente;
import com.proyecto.cineplus.models.Usuario;
import com.proyecto.cineplus.repository.ITipoUsuarioRepository;
import com.proyecto.cineplus.repository.IUsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private ITipoUsuarioRepository repo_tipousu;
	
	@Autowired
	private IUsuarioRepository repo_usu;
	
	@GetMapping("/listado")
	
	public String principal(Model model) {
		model.addAttribute("listaTipoUsuario", repo_tipousu.findAll());
		model.addAttribute("listaUsuarios",repo_usu.findAll());
		model.addAttribute("usuarios", new Usuario());
		return "MUsuario";
	}
	
	@PostMapping("/Guardar")
	
	public String guardarUsuario(@ModelAttribute Usuario usuarios, Model model) {
		
		try {
			
			Usuario u = repo_usu.findById(usuarios.getId()).get();
					
			model.addAttribute("listaTipoUsuario", repo_tipousu.findAll());
			model.addAttribute("listaUsuarios",repo_usu.findAll());
			model.addAttribute("usuarios", new Usuario());
			model.addAttribute("mensajeCorrecto","El ID del Usuario Existe");
			
		} catch (Exception e) {
			repo_usu.save(usuarios);
			model.addAttribute("listaTipoUsuario", repo_tipousu.findAll());
			model.addAttribute("listaUsuarios",repo_usu.findAll());
			model.addAttribute("usuarios", new Usuario());
			model.addAttribute("mensajeCorrecto","Se registro correctamente el Usuario");
			return "redirect:/usuario/listado";
		}
		
		return "redirect:/usuario/listado";
	}	
	
	
	
}
