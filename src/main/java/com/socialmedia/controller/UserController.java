/**
 * 
 */
package com.socialmedia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.User;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.service.UserService;

/**
 * 
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User registedUser = userService.saveUser(user);
		return new ResponseEntity<>(registedUser, HttpStatus.CREATED);
	}

	/*
	 * @GetMapping("/{username}") public ResponseEntity<User>
	 * findByUserName(@PathVariable String username) { Optional<User> user =
	 * userService.findByUserName(username); if (user.isPresent()) { return new
	 * ResponseEntity<>(user.get(), HttpStatus.OK);
	 * 
	 * } else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
	
	@GetMapping("/{username}")
	public ResponseEntity<List<User>> findUsersByUserName(@PathVariable String username) {
		List<User> users = userService.findUsersByUsersName(username);
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println(users);
			return new ResponseEntity<>(users, HttpStatus.OK);

		}
	}
	
	@PutMapping("/{username}")
	public ResponseEntity<User> updateCustomer(@PathVariable String username, @RequestBody User user) {
		Optional<User> updatedUser = userService.updateUser(username, user);
		return new ResponseEntity<>(updatedUser.get(), HttpStatus.OK);
	}
}
