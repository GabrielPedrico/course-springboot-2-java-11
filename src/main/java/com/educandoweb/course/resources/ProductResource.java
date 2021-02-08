package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController // Para indicar que essa classe é um recursoweb que é implementado por um
				// controlador rest.
@RequestMapping(value = "/products") // Para indicar o nome do recurso.
public class ProductResource {
	
	@Autowired
	private ProductService service;
	// Metodo que sera um end point para acessar os usuarios, o ResponseEntity é um
	// tipo especifico do spring para retornar respostas de requisicao web, o
	// findAll é o metodo que estou criando abaixo para retornar os usuarios.
	@GetMapping //Pra indicar que esse metodo sera um metodo que responde a requisicao do tipo get do http
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();// Instanciando Usuario.
		return ResponseEntity.ok().body(list); // ResponseEntity.ok() para retornar a resposta com sucesso e o .body(list)
											// para retornar o corpo da resposta esse meus usuarios da list que acabei de
											// instanciar
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
