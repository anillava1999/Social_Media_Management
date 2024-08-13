/**
 * 
 */
package com.socialmedia.util;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.model.User;

/**
 * 
 */
public class UserConverter {
	
	public static UserDTO toDTO(User user) {
		return new UserDTO(
				user.getUserid(),
				user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getAddress(),
                user.getFullname(),
                user.getLastname(),
                user.getMobile(),
                user.getDOF()
				);
					
	}
	
	public static User toEntity(UserDTO userDTO) {
		return new User(
				userDTO.getUserid(),
				userDTO.getUsername(),
				userDTO.getPassword(),
				userDTO.getEmail(),
				userDTO.getAddress(),
				userDTO.getFullname(),
				userDTO.getLastname(),
				userDTO.getMobile(),
				userDTO.getDOF()
				);
					
	}

}
