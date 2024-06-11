package com.projetomf.cadastroUsuarios.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetomf.cadastroUsuarios.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		String msg = "Resource Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError error = new StandardError(Instant.now(), status.value(), msg, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
}
