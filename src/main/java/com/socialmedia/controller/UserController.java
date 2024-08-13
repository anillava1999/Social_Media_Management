package com.socialmedia.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/*
	 * "registerUser" methods help to save the user in database
	 */
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
		logger.info("Registering user: {}", userDTO.getUsername());

		UserDTO savedUser = userService.saveUser(userDTO);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	/*
	 * "findByUserName" methods help to find the particular user with help of
	 * username in database
	 */
	@GetMapping("/{username}")
	public ResponseEntity<UserDTO> findByUserName(@PathVariable String username) {
		Optional<UserDTO> user = userService.findByUserName(username);

		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * "updateUser" methods help to update the particular user in database
	 */
	@PutMapping("/update/{username}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
		Optional<UserDTO> updatedUser = userService.updateUser(username, userDTO);

		if (updatedUser.isPresent()) {
			return new ResponseEntity<>(updatedUser.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}