package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController // Para indicar que essa classe é um recursoweb que é implementado por um
				// controlador rest.
@RequestMapping(value = "/orders") // Para indicar o nome do recurso.
public class OrderResource {
	
	@Autowired
	private OrderService service;
	// Metodo que sera um end point para acessar os usuarios, o ResponseEntity é um
	// tipo especifico do spring para retornar respostas de requisicao web, o
	// findAll é o metodo que estou criando abaixo para retornar os usuarios.
	@GetMapping //Pra indicar que esse metodo sera um metodo que responde a requisicao do tipo get do http
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();// Instanciando Usuario.
		return ResponseEntity.ok().body(list); // ResponseEntity.ok() para retornar a resposta com sucesso e o .body(list)
											// para retornar o corpo da resposta esse meus usuarios da list que acabei de
											// instanciar
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
