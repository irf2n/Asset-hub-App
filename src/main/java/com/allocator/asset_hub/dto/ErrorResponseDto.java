/**
 * 
 */
package com.allocator.asset_hub.dto;

import java.time.LocalDateTime;

/**
 * 
 */
public class ErrorResponseDto {

	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	
	// default constructor 
	public ErrorResponseDto() {}

	/**
	 * @param timestamp
	 * @param status
	 * @param error
	 * @param message
	 */
	public ErrorResponseDto(LocalDateTime timestamp, int status, String error, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
