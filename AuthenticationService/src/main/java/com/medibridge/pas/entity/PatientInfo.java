package com.medibridge.pas.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data // gives all lombok
@Table(name = "patient")
public class PatientInfo {

	@Id
//	@GeneratedValue(generator = CustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = CustomIdGenerator.GENERATOR_NAME, strategy = "com.pms.entity.CustomIdGenerator", parameters = {
//	@Parameter(name = CustomIdGenerator.PREFIX_PARAM, value = "PA00") })
	@Column(name = "patient_id")
	private String patientId;
	
//	@Nonnull
//	@Email
	
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
	
//	@Nonnull
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
