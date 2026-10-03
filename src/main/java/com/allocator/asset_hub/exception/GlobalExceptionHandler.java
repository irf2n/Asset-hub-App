/**
 * 
 */
package com.allocator.asset_hub.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.allocator.asset_hub.dto.ErrorResponseDto;

/**
 * 
 */
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
	
	@ExceptionHandler(InvalidAllocationStateException.class)
	public ResponseEntity<ErrorResponseDto> invalidAllocationStateException(InvalidAllocationStateException ex){
		ErrorResponseDto errorDto = new ErrorResponseDto(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage());
		return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
	}
}
