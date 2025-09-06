package com.medibridge.pas.entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="diagnosis")
@Data
public class Diagnosis {

	@Id
//	@GeneratedValue(generator = CustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = CustomIdGenerator.GENERATOR_NAME, 
//	strategy = "com.pms.model.CustomIdGenerator",
//	parameters = {@Parameter(name = CustomIdGenerator.PREFIX_PARAM, value = "TD00") })
	@Column(name="TEST_ID")
	private String testId;
	
	@SuppressWarnings("deprecation")
	@NotNull
	@Column(name="TEST_NAME")
	private String testName;
	
	@SuppressWarnings("deprecation")
	@NotNull
	@Column(name="RESULT")
	private String result;
	
	@Column(name="NOTES")
	private String notes;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="visit_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private PatientVisitDetails visitDetails;
	

	public Diagnosis(String testId, String testName, String result, String notes, PatientVisitDetails visitDetails) {
		this.testId = testId;
		this.testName = testName;
		this.result = result;
		this.notes = notes;
		this.visitDetails = visitDetails;
	}


	public String getTestId() {
		return testId;
	}


	public void setTestId(String testId) {
		this.testId = testId;
	}


	public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public PatientVisitDetails getVisitDetails() {
		return visitDetails;
	}


	public void setVisitDetails(PatientVisitDetails visitDetails) {
		this.visitDetails = visitDetails;
	}
}
