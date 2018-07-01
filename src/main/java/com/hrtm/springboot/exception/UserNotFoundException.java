package com.hrtm.springboot.exception;

/**
 * The class {@code UserNotFoundException} indicates condition that a user for 
 * provided parameters not found.
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8282603053132555801L;

	public UserNotFoundException(Long userId) {
		super("User for userId '" + userId +"' not found");
	}
	
	public UserNotFoundException(String email) {
		super("User for email '" + email +"' not found");
	}
	
}
