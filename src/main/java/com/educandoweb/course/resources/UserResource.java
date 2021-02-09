package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // Para indicar que essa classe é um recursoweb que é implementado por um
				// controlador rest.
@RequestMapping(value = "/users") // Para indicar o nome do recurso.
public class UserResource {
	
	@Autowired
	private UserService service;
	// Metodo que sera um end point para acessar os usuarios, o ResponseEntity é um
	// tipo especifico do spring para retornar respostas de requisicao web, o
	// findAll é o metodo que estou criando abaixo para retornar os usuarios.
	@GetMapping //Pra indicar que esse metodo sera um metodo que responde a requisicao do tipo get do http
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();// Instanciando Usuario.
		return ResponseEntity.ok().body(list); // ResponseEntity.ok() para retornar a resposta com sucesso e o .body(list)
											// para retornar o corpo da resposta esse meus usuarios da list que acabei de
											// instanciar
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
