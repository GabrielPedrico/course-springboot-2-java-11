package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

//Vai instanciar um objeto repository que vai ter varias operacoes para realizar no usuario com o extends 
//do Jpa nao preciso colocar implementacao padrao da classe pois ela ja tem uma definicao pra user,long
public interface UserRepository extends JpaRepository<User, Long> {

}
