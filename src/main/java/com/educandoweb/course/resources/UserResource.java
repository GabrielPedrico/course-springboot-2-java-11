package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // Para indicar que essa classe é um recursoweb que é implementado por um
				// controlador rest.
@RequestMapping(value = "/users") // Para indicar o nome do recurso.
public class UserResource {
	// Metodo que sera um end point para acessar os usuarios, o ResponseEntity é um
	// tipo especifico do spring para retornar respostas de requisicao web, o
	// findAll é o metodo que estou criando abaixo para retornar os usuarios.
	@GetMapping //Pra indicar que esse metodo sera um metodo que responde a requisicao do tipo get do http
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "99999", "12345"); // Instanciando Usuario.
		return ResponseEntity.ok().body(u); // ResponseEntity.ok() para retornar a resposta com sucesso e o .body(u)
											// para retornar o corpo da resposta esse meu usuario u que acabei de
											// instanciar

	}

}
