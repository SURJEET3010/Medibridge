package com.medibridge.pas;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ErrorResponse(HttpStatus status, LocalDateTime timestamp, String message, String details) {
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
}
