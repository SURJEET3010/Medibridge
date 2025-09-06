package com.medibridge.pas.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medibridge.pas.entity.Appointment;
import com.medibridge.pas.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentservice;

	// add to appointment , acceptance default to pending
	@PostMapping("/appointment")
	public ResponseEntity<Appointment> saveDetails(@RequestBody Appointment appointment){ //throws AppointmentServiceException {
		Appointment appointmentList = appointmentservice.saveDetails(appointment);
		System.out.println(appointment);
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentList);

	}
	
	// delete with appointmentID, only for patient to delete appointment
	@DeleteMapping("/appointment/{appointmentId}")
	public ResponseEntity<Void> deleteDetails(@PathVariable("appointmentId") String appointmentId) { //throws AppointmentServiceException {
		boolean bool = appointmentservice.deleteDetails(appointmentId);
		if (!bool) {
			return ResponseEntity.status(HttpStatus.valueOf(500)).build();
		}		
		return ResponseEntity.status(HttpStatus.valueOf(200)).build();

	}
	
	@PutMapping("/appointment/{appointmentId}")
	public ResponseEntity<Appointment> updateDetails(@RequestBody Appointment appointment, @PathVariable("appointmentId") String appointmentId) { //throws AppointmentServiceException {
		Appointment app = appointmentservice.updateDetails(appointment, appointmentId);
		if (app == null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
		}
		
		return ResponseEntity.accepted().body(appointment);

	}
	
	// fetch all appointments with physicianEmail and acceptance and appointmentDate
	// , only for doctor
	@GetMapping("/appointment/{physicianEmail}")
	public ResponseEntity<List<Appointment>> showAvailabilityByDate(
			@PathVariable("physicianEmail") String physicianEmail,
			@RequestParam(value = "acceptance") String acceptance,
			@RequestParam(required = false, value = "appointmentDate") LocalDate date) { //throws AppointmentServiceException {

		if (Objects.nonNull(date)) {
			List<Appointment> list = appointmentservice.showAvailability(physicianEmail, date, acceptance);
			if (list == null) {
				return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
			} else {
				return ResponseEntity.ok().body(list);
			}
			
		} else {
			List<Appointment> list = appointmentservice.showAppointmentByRejected(physicianEmail, acceptance);
			if (list == null) {
				return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
			}
			return ResponseEntity.ok().body(list);
		}
	}
	
	
	// fetch all patients with patientsId , only for patient
	@GetMapping("/patient/{patientId}")
	public ResponseEntity<List<Appointment>> showAvailability(@PathVariable("patientId") String patientId) { //throws AppointmentServiceException {
		List<Appointment> list = appointmentservice.getAppointment(patientId);
		if (list == null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
		}
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/appointment")
	public ResponseEntity<List<Appointment>> findByAcceptance(@RequestParam(value = "acceptance") String acceptance){ //throws AppointmentServiceException {
		List<Appointment> list = appointmentservice.showAppointment(acceptance);

		if (list == null) {
			return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
		}
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> showAllAvailability() { //throws AppointmentServiceException {
		List<Appointment> list = appointmentservice.showAllAppointments();
		if (list.size() <= 0) {
			throw new NullPointerException("appointments does not exist "); //AppointmentServiceException("appointments does not exist ");
		}
		return ResponseEntity.ok().body(list);
	}
}
