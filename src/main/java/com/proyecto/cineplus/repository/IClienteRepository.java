package com.proyecto.cineplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.cineplus.models.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
