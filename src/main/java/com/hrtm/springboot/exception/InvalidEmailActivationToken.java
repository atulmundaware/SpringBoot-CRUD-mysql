package com.hrtm.springboot.exception;

/**
 * The class {@code InvalidEmailActivationToken} indicates condition that a account 
 * activation token is not valid.
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

public class InvalidEmailActivationToken extends RuntimeException {

	private static final long serialVersionUID = 4256478817911439111L;
	
	public InvalidEmailActivationToken(String activationToken) {
		super("Invalid activation token '" + activationToken +"'");
	}
	
}
