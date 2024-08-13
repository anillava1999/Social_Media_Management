package com.socialmedia.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.util.UserConverter;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	
	/*
	 * "saveUser" Methods helps to save the User values
	 */
	public UserDTO saveUser(UserDTO userDTO) {
		logger.info("Saving user: {}", userDTO.getUsername());

		// Convert User Entity to UserDTO
		User user = UserConverter.toEntity(userDTO);

		// Apply PasswordEncoder to the password entity
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// Save the User
		User savedUser = userRepository.save(user);
		return UserConverter.toDTO(savedUser);
	}

	
	/*
	 * "findByUserName" Methods helps to find the user by username
	 */
	public Optional<UserDTO> findByUserName(String username) {
		
		return userRepository.findByUsername(username).map(UserConverter::toDTO);
	}
	
	
	/*
	 * "updateUser" method helps to update current user
	 */
	public Optional<UserDTO> updateUser(String username, UserDTO userDTO) {
		Optional<User> existingUser = userRepository.findByUsername(username);

		if (existingUser.isPresent()) {
			User user = existingUser.get();
			user.setFullname(userDTO.getFullname());
			user.setLastname(userDTO.getLastname());
			user.setEmail(userDTO.getEmail());
			user.setMobile(userDTO.getMobile());
			user.setDOF(userDTO.getDOF());
			user.setAddress(userDTO.getAddress());

			User updatedUser = userRepository.save(user);
			return Optional.of(UserConverter.toDTO(updatedUser));
		}

		return Optional.empty();
	}
}