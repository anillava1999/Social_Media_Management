package com.socialmedia.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;

/**
 * 
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * @param username
	 * @return
	 */
	/*
	 * public Optional<User> findByUserName(String username) { return
	 * userRepository.findByUsername(username); }
	 */
	
	public List<User> findUsersByUsersName(String username) {
		return userRepository.findUsersByUsername(username);
	}

	/**
	 * @param username
	 * @param user
	 * @return
	 */
	public Optional<User> updateUser(String username, User user) {
		return userRepository.updateUser(username,user);
	}

	

}
