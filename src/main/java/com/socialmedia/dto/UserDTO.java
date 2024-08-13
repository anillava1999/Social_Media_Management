/**
 * 
 */
package com.socialmedia.dto;

/**
 * 
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long userid;
	private String username;
	private String password;
	private String fullname;
	private String lastname;
	private String email;
	private String mobile;
	private String DOF;
	private String address;

}
