package com.medibridge.pas;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatwayApplication.class, args);
	}

	@GetMapping("/g2-allergy-service-fallback")
	public ResponseEntity<ErrorResponse> allergyServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Allergy Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/g2-patient-health-records-service-fallback")
	public ResponseEntity<ErrorResponse> healthRecordServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Health Record Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("//g2-authentication-service-fallback")
	public ResponseEntity<ErrorResponse> authenticationServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Authentication Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/g2-notification-service-fallback")
	public ResponseEntity<ErrorResponse> notificationServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Notification Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/g2-patient-info-service-fallback")
	public ResponseEntity<ErrorResponse> patientInfoServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Patient Info Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/g2-physician-availability-service-fallback")
	public ResponseEntity<ErrorResponse> physicianAvailabilityServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Physician Availability Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/g2-Appointment-service-fallback")
	public ResponseEntity<ErrorResponse> appointmentServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Appointment Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
	@GetMapping("/g2-auth0-service-fallback")
	public ResponseEntity<ErrorResponse> auth0ServiceFallback() {
		ErrorResponse errorDetails = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, LocalDateTime.now(),
				"Auth Service is down! Please try later", "For critical support please call on 18080800000 or mail us on support@pms.com");
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
