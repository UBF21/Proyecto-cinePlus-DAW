package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.TipoPelicula;

public interface ITipoPelicula extends JpaRepository<TipoPelicula, Integer> {

}