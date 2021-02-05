package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration // Anotation pra indicar pro spring que esta classe é uma configuração
@Profile("test") //Pra falar pro spring que é uma configuração especifica para um perfil de teste
public class TestConfig implements CommandLineRunner {
	
	@Autowired // Para que o spring consiga resolver essa dependecia e asociar uma instancia do UserRepository 
	private UserRepository userRepository; // Injecao de dependecia desacoplada da classe UserRepository

	@Override
	public void run(String... args) throws Exception { // Tudo que esta dentro deste metodo sera executado quando a aplicacao for iniciada
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));

		
	}
}
