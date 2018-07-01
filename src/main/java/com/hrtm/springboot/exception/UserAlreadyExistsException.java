package com.hrtm.springboot.exception;

/**
 * The class {@code UserAlreadyExistsException} indicates condition that a user for 
 * provided parameters already exists.
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

public class UserAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = -5850955530136511718L;

	public UserAlreadyExistsException(String username) {
		super("User for username '" + username +"' already exists");
	}

}
