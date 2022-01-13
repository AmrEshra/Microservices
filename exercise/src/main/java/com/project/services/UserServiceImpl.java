package com.project.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exceptions.BusinessException;
import com.project.exceptions.NotFoundException;
import com.project.model.User;
import com.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return user.get();
		else
			throw new NotFoundException("Not Data Found");
	}

	@Transactional
	public User save(User user) throws BusinessException {

		validateUser(user);
		return userRepository.save(user);
	}

	/**
	 * TODO: add more validation to handle different cases
	 * 
	 * @param user
	 * @throws Exception
	 */
	private void validateUser(User user) throws BusinessException {

		if (userRepository.existsById(user.getId())) {
			throw new BusinessException("error_repeatedValue");
		}
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
