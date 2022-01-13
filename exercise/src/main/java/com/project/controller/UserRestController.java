package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.exceptions.BusinessException;
import com.project.model.User;
import com.project.services.UserService;

@RestController
@RequestMapping("/User-api/")
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Get All Users
	 * 
	 * @return List<User>
	 */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	/**
	 * get User by serialNumber
	 * 
	 * @return User
	 */
	@GetMapping("/users/{id}")
	public User getUsers(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	/**
	 * save User
	 * 
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) throws Exception {
		try {
			userService.save(user);
			return user;
		} catch (BusinessException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
