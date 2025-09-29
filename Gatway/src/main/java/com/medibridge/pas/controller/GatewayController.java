package com.medibridge.pas.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medibridge.pas.ErrorResponse;

@RestController
public class GatewayController {

	@GetMapping("/")
	public String home() {
		return "API Gateway";
	}

	@GetMapping("/allergy-service-fallback")
	public ResponseEntity<ErrorResponse> allergyServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Service is down! Please try later", "For critical support mail us on support@medibridge.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
