package com.hrtm.springboot.exception;

/**
 * The class {@code EmailAlreadyRegisteredException} indicates condition that a email for 
 * provided parameters already exists.
 *  
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

public class EmailAlreadyRegisteredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2093745593354672193L;

	public EmailAlreadyRegisteredException(String email) {
		super("Email with emailId:'" + email +"' already exists");
	}
}
