package com.medibridge.pas.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Appointment {

//	@GeneratedValue(generator = CustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = CustomIdGenerator.GENERATOR_NAME, strategy = "com.pms.entity.CustomIdGenerator", parameters = {
//	@Parameter(name = CustomIdGenerator.PREFIX_PARAM, value = "AP00") })
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id
	private String appointmentId;
	
	@Column(name ="appointmentReason")
	private String reason;
	
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")	
	private LocalDate appointmentDate;
	
	
//	@Column( name ="appointmentAcceptance")
	private String acceptance;

//	@NotBlank
	@Column
	private String patientId;
	
//	@NotBlank
//	@Email
	@Column
	private String physicianEmail;
	
//	@NotBlank
	@Column
	private String PatientName;
	
	
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate submissionDate;


	public String getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public String getAcceptance() {
		return acceptance;
	}


	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getPhysicianEmail() {
		return physicianEmail;
	}


	public void setPhysicianEmail(String physicianEmail) {
		this.physicianEmail = physicianEmail;
	}


	public String getPatientName() {
		return PatientName;
	}


	public void setPatientName(String patientName) {
		PatientName = patientName;
	}


	public LocalDate getSubmissionDate() {
		return submissionDate;
	}


	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
}
