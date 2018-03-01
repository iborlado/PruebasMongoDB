package com.prueba.mongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prueba.mongo.entities.Cliente;



public interface IClienteRepositorio extends MongoRepository<Cliente, String>{

	public Optional<Cliente> findById(String id);
	public Cliente findByNombre(String nombre);
	public Cliente findByApellido(String apellido);
}
