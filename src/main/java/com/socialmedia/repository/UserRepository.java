package com.socialmedia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.socialmedia.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);

	/**
	 * @param username
	 * @return
	 */
	List<User> findUsersByUsername(String username);



}
