package com.prueba.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.mongo.entities.Cliente;
import com.prueba.mongo.repositories.CustomerRepository;
import com.prueba.mongo.services.IServicio;


@RestController
@RequestMapping("/prueba")
public class Controlador {
	
	@Autowired
	CustomerRepository repository;
	@Autowired
	IServicio servicio;
	
	/***************************************ENDPOINTS*****************************************/
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String saludar(@PathVariable(name="id") String nombre) {
		HttpStatus status = insertarClienteStatus(nombre, "Peperoni");
		return "Hola "+nombre+ " " +status.name();
	}
	
	@PostMapping(path = "/guardar/{nombre}", produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Cliente> save(@PathVariable("nombre") String nombre) {
		//extract json file
		Cliente jsonObject = insertarCliente(nombre, "jason");
		HttpStatus status = jsonObject != null ? HttpStatus.CREATED : HttpStatus.NOT_IMPLEMENTED;
		return new ResponseEntity<Cliente>(jsonObject, status);
	}
	
	@RequestMapping(path = "/buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> find(@PathVariable(name="id") String nombre) {
		String cliente = buscarPorNombre(nombre);
		HttpStatus status = cliente != null ? HttpStatus.FOUND : HttpStatus.NO_CONTENT;
		//return "Hola "+nombre+ " " +status;
		return new ResponseEntity<String>(cliente,status);
	}
	
	@RequestMapping(path= "/vaciar", method = RequestMethod.GET)
	public String deleteAll() {
		servicio.borrarBD();
		return "Hola ";
	}
	
	
	/**********************************METODOS PRIVADOS QUE LLAMAN A SERVICIO************************/
	private Cliente insertarCliente (String nombre, String apellido){
		Cliente clienteInsertado = servicio.insertarNuevoClienteO(nombre, apellido);
		return clienteInsertado;
	}
	
	private HttpStatus insertarClienteStatus (String nombre, String apellido){
		HttpStatus status; 
		String clienteInsertado = servicio.insertarNuevoCliente(nombre, apellido);
		if (clienteInsertado != null){
			status = HttpStatus.CREATED;
		}
		else {
			status = HttpStatus.NOT_IMPLEMENTED;
		}
		return status;
	}
	
	private String insertarClienteString (String nombre, String apellido){
		String resultado = null;
		String clienteInsertado = servicio.insertarNuevoCliente(nombre, apellido);
		if (clienteInsertado != null){
			resultado = clienteInsertado;
		}
		return resultado;
	}
	
	private String buscarPorNombre(String nombre){
		String resultadoBusqueda = servicio.buscarClientePorNombre(nombre);
		return resultadoBusqueda;
	}
}
