package com.medibridge.pas.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//@EntityListeners(LastUpdateListener.class)
@Entity
@Table(name = "PATIENT_VISIT_DETAILS")
@Data
public class PatientVisitDetails {
	
	@Id
//	@GeneratedValue(generator = CustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = CustomIdGenerator.GENERATOR_NAME, 
//	strategy = "com.pms.model.CustomIdGenerator",
//	parameters = {@Parameter(name = CustomIdGenerator.PREFIX_PARAM, value = "VI") })
	@Column(name="VISIT_ID")
	private String visitId;
	
	@Column(name="PATIENT_ID",nullable = false, updatable = false)
	private String patientId;

	@Column(name = "HEIGHT")
	private float height;

	
	@Column(name = "WEIGHT")
	private float weight;

	@Column(name = "BP_SYSTOLLIC")
	private int bpSystollic;


	@Column(name = "BP_DIASTOLLIC")
	private int bpDiastolic;

	
	@Column(name = "BODY_TEMPERATURE")
	private float bodyTemperature;

	@Column(name = "RESPIRATION_RATE")
	private int respirationRate;


	@Column(name = "BLOOD_GROUP")
	private String bloodGroup;

//	@Column(name = "NURSE_EMAIL")
//	private String nurseEmail;
//
//	@Column(name = "PHYSICIAN_EMAIL")
//	private String physicianEmail;
	
	
	@Column(name = "APPOINTMENT_ID", updatable = false)
	private String appointmentId;
	

	@Column(name = "KEY_NOTES")
	private String keyNotes;
	
	
	@Column(name = "ALLERGY")
	private List<String> allergy;
	
	@CreatedDate
	@Column(nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public LocalDate createdDate;

	@LastModifiedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public LocalDate lastModifiedDate;

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getBpSystollic() {
		return bpSystollic;
	}

	public void setBpSystollic(int bpSystollic) {
		this.bpSystollic = bpSystollic;
	}

	public int getBpDiastolic() {
		return bpDiastolic;
	}

	public void setBpDiastolic(int bpDiastolic) {
		this.bpDiastolic = bpDiastolic;
	}

	public float getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(float bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public int getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(int respirationRate) {
		this.respirationRate = respirationRate;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getKeyNotes() {
		return keyNotes;
	}

	public void setKeyNotes(String keyNotes) {
		this.keyNotes = keyNotes;
	}

	public List<String> getAllergy() {
		return allergy;
	}

	public void setAllergy(List<String> allergy) {
		this.allergy = allergy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
