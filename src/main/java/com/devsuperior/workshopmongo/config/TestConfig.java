package com.devsuperior.workshopmongo.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devsuperior.workshopmongo.models.entities.User;
import com.devsuperior.workshopmongo.repositories.PostRepository;
import com.devsuperior.workshopmongo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@PostConstruct
	public void init() {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Gonçalves", "maria@gmail.com");
		User alex = new User(null, "Alex Sampaio", "alex@gmail.com");
		User davi = new User(null, "Davi Germano", "davi@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, davi));
	}
}
