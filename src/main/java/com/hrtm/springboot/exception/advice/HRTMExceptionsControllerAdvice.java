package com.hrtm.springboot.exception.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import com.hrtm.springboot.exception.AccessDeniedException;
import com.hrtm.springboot.exception.EmailAlreadyRegisteredException;
import com.hrtm.springboot.exception.InvalidEmailActivationToken;
import com.hrtm.springboot.exception.UserAlreadyExistsException;
import com.hrtm.springboot.exception.UserNotFoundException;
import com.hrtm.springboot.exception.ValidationException;

/**
 * Provide advice to controller to handle all Famboard related exceptions.
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

@ControllerAdvice
public class HRTMExceptionsControllerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(HRTMExceptionsControllerAdvice.class);
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> userAlreadyExistsExceptionHandler(
			UserAlreadyExistsException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.CONFLICT, ex.getMessage());
	}
	
	@ExceptionHandler(EmailAlreadyRegisteredException.class)
	public ResponseEntity<ErrorResponse> emailAlreadyRegisteredExceptionHandler(
			EmailAlreadyRegisteredException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.CONFLICT, ex.getMessage());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> userNotFoundExceptionHandler(UserNotFoundException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorResponse> validationExceptionHandler(ValidationException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}
	
	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<ErrorResponse> multipartExceptionHandler(MultipartException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(InvalidEmailActivationToken.class)
	public ResponseEntity<ErrorResponse> invalidEmailActivationTokenExceptionHandler(
			InvalidEmailActivationToken ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, "Request method not allowed");
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorResponse> missingServletRequestParameterException(
			MissingServletRequestParameterException ex){
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> httpMessageNotReadableExceptionHandler(
			HttpMessageNotReadableException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.BAD_REQUEST, "Invalid request parameters check input data");
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponse> accessDeniedException(
			AccessDeniedException ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		LOGGER.error(ex.getMessage() ,ex);
		return getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
	}

	/**
	 * Method to get error response to return to client.
	 * @param httpStatus
	 *        Status to included in HTTP response.
	 * @param message
	 *        Message to included in HTTP response.
	 * @return
	 *        Response to return as a part of HTTP response.
	 */
	public ResponseEntity<ErrorResponse> getErrorResponse(HttpStatus httpStatus, String message) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(httpStatus.value());
		error.setMessage(message);
		return new ResponseEntity<ErrorResponse>(error, httpStatus);
	}

}
