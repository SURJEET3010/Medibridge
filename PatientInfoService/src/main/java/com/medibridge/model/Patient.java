package com.medibridge.model;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Parameter;

@Entity
@Data // gives all lombok
@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {


	@Id
//	@GeneratedValue(generator = PatientCustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = PatientCustomIdGenerator.GENERATOR_NAME, strategy = "com.pms.entity.CustomIdGenerator", parameters = {
//	@Parameter(name = PatientCustomIdGenerator.PREFIX_PARAM, value = "PA00") })
	
	@Column(name = "patient_id")
	private String patientId;
	
	@Nonnull
	@Column(name = "email", unique = true)
	private String email;
	
	private String title;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;	
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String dob;
	@Column(name = "contact_number")
	private String contactNumber;
	@Nonnull
	private String password;
	
	private String gender;
	//@Column(name = "languages_known")
	//private List<String> languagesKnown;
	private String address;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
}
