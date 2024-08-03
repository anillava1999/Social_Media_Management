package com.socialmedia.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.User;

public interface UserRespository extends JpaRepository<User, Long>{

}
