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
@Table(name="prescription")
@Data 
public class Prescription {
	@Id
//	@GeneratedValue(generator = CustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = CustomIdGenerator.GENERATOR_NAME, 
//	strategy = "com.pms.model.CustomIdGenerator",
//	parameters = {@Parameter(name = CustomIdGenerator.PREFIX_PARAM, value = "PR00") })
	@Column(name="PRESC_ID")
	private String prescriptionId;
	
	@SuppressWarnings("deprecation")
	@NotNull
	@Column(name="PRESC_NAME")
	private String prescriptionName;
	
	@SuppressWarnings("deprecation")
	@NotNull
	@Column(name="DOSAGE")
	private String dosage;
	
	@SuppressWarnings("deprecation")
	@NotNull
	@Column(name="NOTES")
	private String notes;
	
//	@Column(name = "prescribed_date")
//	@Temporal(TemporalType.DATE)
//	private LocalDate prescribedDate;
	
//	@Column(name="visit_id")
//	private String visitId;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="visit_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private PatientVisitDetails visitDetails;

	public Prescription(String prescriptionId, String prescriptionName, String dosage,
			String notes, PatientVisitDetails visitDetails) {
		this.prescriptionId = prescriptionId;
		this.prescriptionName = prescriptionName;
		this.dosage = dosage;
		this.notes = notes;
		this.visitDetails = visitDetails;
	}

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPrescriptionName() {
		return prescriptionName;
	}

	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
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
