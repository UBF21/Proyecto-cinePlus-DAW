package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.Pelicula;

public interface IPeliculaRepository extends JpaRepository<Pelicula, String>  {

}
