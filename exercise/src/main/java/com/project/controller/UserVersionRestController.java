package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.services.UserService;

@RestController
@RequestMapping("/UserVersion-api/")
@CrossOrigin(origins = "*")
public class UserVersionRestController {

	@Autowired
	UserService userService;

	public UserVersionRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/users", headers = "API-VERSION=1")
	public List<User> getAllUsersV1() {
		return userService.findAll().subList(0, 1);
	}
	
	@GetMapping(value = "/users", headers = "API-VERSION=2")
	public List<User> getAllUsersV2() {
		return userService.findAll();
	}

}