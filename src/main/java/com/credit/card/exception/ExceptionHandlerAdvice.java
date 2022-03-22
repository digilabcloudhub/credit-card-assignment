package com.credit.card.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(ResourceNotFoundException exception,
			HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(exception.getMessage());
		response.setRequestURI(request.getRequestURI());
		return response;

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(Exception exception, HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(exception.getMessage());
		response.setRequestURI(request.getRequestURI());
		return response;

	}

	@ExceptionHandler(InavlidRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleInsufficientBalance(InavlidRequestException exception,
			HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(exception.getMessage());
		response.setRequestURI(request.getRequestURI());
		return response;

	}

}
