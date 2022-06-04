package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//No se utilizo alias para las columnas porque tienen el mismo nombre que en el campo de su tabla

@Entity
@Table(name="tipo_peli")
public class TipoPelicula {
	
	@Id
	@Column(name="cod_tipo")
	private int idtipo;
	
	
	public TipoPelicula() {
		super();
	}
	public TipoPelicula(int idtipo, String desc_tipo) {
		super();
		this.idtipo = idtipo;
		this.desc_tipo = desc_tipo;
	}
	private String desc_tipo;
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getDesc_tipo() {
		return desc_tipo;
	}
	public void setDesc_tipo(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}
	
	

}
