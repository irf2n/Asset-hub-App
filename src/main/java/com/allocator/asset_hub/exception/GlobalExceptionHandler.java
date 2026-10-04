/**
 * 
 */
package com.allocator.asset_hub.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.allocator.asset_hub.dto.ErrorResponseDto;

/**
 * 
 */
// method
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFound(ResourceNotFoundException ex){
		ErrorResponseDto error = new ErrorResponseDto(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage()
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
// method
	@ExceptionHandler(InvalidAllocationStateException.class)
	public ResponseEntity<ErrorResponseDto> invalidAllocationStateException(InvalidAllocationStateException ex){
		ErrorResponseDto errorDto = new ErrorResponseDto(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage());
		return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
	}
// method
	public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex){
		String defaultErrorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		ErrorResponseDto error = new ErrorResponseDto (
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"Validation Failed",
				defaultErrorMessage);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
