package com.prueba.mongo.entities;

import org.springframework.data.annotation.Id;

public class Cliente {

	@Id
	private String id;
	private String nombre;
	private String apellido;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
