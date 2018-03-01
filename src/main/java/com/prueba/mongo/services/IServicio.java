package com.prueba.mongo.services;

import com.prueba.mongo.entities.Cliente;

public interface IServicio {
	public String insertarNuevoCliente(String nombre,String apellido);
	public Cliente insertarNuevoClienteO(String nombre,String apellido);
	public String buscarClientePorNombre(String nombre);
	public String borrarBD();
}
