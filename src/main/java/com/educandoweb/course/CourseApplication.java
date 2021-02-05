package com.educandoweb.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Quando importado o springboot, ele cria a função main nesse formato inicializando o springboot
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);// Primeiro comando para a aplicação springboot rodar (É o start)
		System.out.println("Springboot inicializado com sucesso!");
	}

}
