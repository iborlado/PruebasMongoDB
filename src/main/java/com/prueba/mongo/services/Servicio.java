package com.prueba.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.mongo.entities.Cliente;
import com.prueba.mongo.repositories.IClienteRepositorio;

@Component
public class Servicio implements IServicio {

	@Autowired
	IClienteRepositorio clienteRepositorio;



	@Override
	public String insertarNuevoCliente(String nombre, String apellido) {
		String resultSave = null;
		Cliente nuevoCliente = clienteRepositorio.save(new Cliente(nombre,apellido));
		if(nuevoCliente != null){
			resultSave = nuevoCliente.toString();
		}
		return resultSave;
	}
	

	@Override
	public String buscarClientePorNombre(String nombre) {
		String resultFind = null;
		Cliente cliente = clienteRepositorio.findByNombre(nombre);
		if (cliente != null){
			resultFind = cliente.toString();
		}
		return resultFind;
	}


	@Override
	public Cliente insertarNuevoClienteO(String nombre, String apellido) {
		Cliente nuevoCliente = clienteRepositorio.save(new Cliente(nombre,apellido));
		return nuevoCliente;
	}


	@Override
	public String borrarBD() {
		clienteRepositorio.deleteAll();
		return null;
	}


}
