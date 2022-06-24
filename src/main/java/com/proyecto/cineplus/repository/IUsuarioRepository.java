package com.proyecto.cineplus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String>{

	Optional<Usuario> findByEmailAndPassword(String email,String password);
	
}
