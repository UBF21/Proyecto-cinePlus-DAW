package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String>{

	
	
}
