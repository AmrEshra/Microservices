package com.project.services;

import java.util.List;

import com.project.model.User;

public interface UserService {

	public List<User> findAll();
	public User findById(Long id);
	public User save(User user);
	public void delete(User user);

}
