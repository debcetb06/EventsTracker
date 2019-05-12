package com.debasis.repoeventstracker.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.debasis.repoeventstracker.model.ApiErrorResponse;

/**
 * <p>Class:ExceptionHandlerControllerAdvice is global exception handler to handle api
 * @author Debasis Panda
 *
 */
@ControllerAdvice
@RestController
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * <p>Class:ExceptionHandlerControllerAdvice and Method:handleMissingServletRequestParameter is to send 400 bad request</p>
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error =  new StringBuilder(ex.getParameterName()).append(" parameter is missing.").toString();
		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), error, request.getDescription(false));
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	/**
	 * <p>Class:ExceptionHandlerControllerAdvice and handleResourceNotFoundException is to send 404 resource not found</p>
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	/**
	 * <p>Class:ExceptionHandlerControllerAdvice and handleSystemException is to send 500 internal server error</p>
	 */
	@ExceptionHandler(SystemException.class)
	public final ResponseEntity<ApiErrorResponse> handleSystemException(SystemException ex, WebRequest request) {
		ApiErrorResponse errorDetails = new ApiErrorResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
