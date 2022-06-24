package com.proyecto.cineplus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
<<<<<<< HEAD
	@Column(name = "id")
	private int id_proveedor;
	
	private String nombre;

	@Column(name = "telf")
	private String telefono;
	
	@Column(name = "direc")
	private String direccion;
	

	public Proveedor(int id_proveedor, String nombre, String telefono, String direccion) {
		super();
		this.id_proveedor = id_proveedor;
=======
	private int id;
	private String nombre;
	
	@Column(name = "telf")
	private String telefono;
	@Column(name = "direc")
	private String direccion;
	
	public Proveedor() {
		super();
	}
	
	public Proveedor(int id, String nombre, String telefono, String direccion) {
		super();
		this.id = id;
>>>>>>> modulo1_yelitza
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

<<<<<<< HEAD
	public Proveedor() {
		super();
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
=======
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
>>>>>>> modulo1_yelitza
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
<<<<<<< HEAD

	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

	
=======
>>>>>>> modulo1_yelitza
	
	
}
