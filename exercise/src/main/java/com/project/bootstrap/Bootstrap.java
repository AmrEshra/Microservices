package com.project.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.model.User;
import com.project.services.UserService;

@Component
public class Bootstrap implements CommandLineRunner {

	UserService userService;
	
	public Bootstrap(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(String... args) throws Exception {
		fillUsers();
	}

	private void fillUsers() {
		User amr = new User(1L, "amr");
		User farida = new User(2L, "farida");
		User ola = new User(3L, "ola");
		User ali = new User(4L, "ali");
		
		userService.save(amr);
		userService.save(ola);
		userService.save(farida);
		userService.save(ali);
		
	}

	
}
