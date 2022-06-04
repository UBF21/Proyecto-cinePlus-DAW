package com.proyecto.cineplus.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	@Column(name="cod_peli")
	private String idpeli;
	private String nombre;
	private int tipo_peli;
	private Date fecha_estreno;
	private Date fecha_final;
	private String estado;
	
	
	
	public Pelicula() {
		super();
	}
	public Pelicula(String idpeli, String nombre, int tipo_peli, Date fecha_estreno, Date fecha_final, String estado) {
		super();
		this.idpeli = idpeli;
		this.nombre = nombre;
		this.tipo_peli = tipo_peli;
		this.fecha_estreno = fecha_estreno;
		this.fecha_final = fecha_final;
		this.estado = estado;
	}
	public String getIdpeli() {
		return idpeli;
	}
	public void setIdpeli(String idpeli) {
		this.idpeli = idpeli;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTipo_peli() {
		return tipo_peli;
	}
	public void setTipo_peli(int tipo_peli) {
		this.tipo_peli = tipo_peli;
	}
	public Date getFecha_estreno() {
		return fecha_estreno;
	}
	public void setFecha_estreno(Date fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}
	public Date getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(Date fecha_final) {
		this.fecha_final = fecha_final;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	

}
