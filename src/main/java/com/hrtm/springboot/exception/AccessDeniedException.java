package com.hrtm.springboot.exception;
import com.hrtm.springboot.exception.advice.ErrorResponse;

/**
 * The class {@code AccessDeniedException} indicates that user is not allowed to access this Functionality 
 * provided parameters failed.
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */
public class AccessDeniedException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private static final int errorCode = 403;
  
	public AccessDeniedException() 
	{
		super("Access Denied");
		new ErrorResponse().setErrorCode(errorCode);
	}
  
}