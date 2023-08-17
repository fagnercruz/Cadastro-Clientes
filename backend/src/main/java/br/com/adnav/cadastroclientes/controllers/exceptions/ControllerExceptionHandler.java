package br.com.adnav.cadastroclientes.controllers.exceptions;

import java.time.Instant;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;



@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<StandardError> entityNotFound(NoSuchElementException e, HttpServletRequest requerst){
		StandardError err = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Recurso não encontrado ou não existe");
		err.setMessage(e.getMessage());
		err.setPath(requerst.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
//	@ExceptionHandler(DatabaseException.class)
//	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest requerst){
//		StandardError err = new StandardError();
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		
//		err.setTimestamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Database Exception");
//		err.setMessage(e.getMessage());
//		err.setPath(requerst.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
//	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest requerst){
//		ValidationError err = new ValidationError();
//		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
//		
//		err.setTimestamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Validation Exception");
//		err.setMessage(e.getMessage());
//		err.setPath(requerst.getRequestURI());
//		
//		for(FieldError f : e.getBindingResult().getFieldErrors()) {
//			err.addError(f.getField(), f.getDefaultMessage());
//		}
//		
//		return ResponseEntity.status(status).body(err);
//	}
}
