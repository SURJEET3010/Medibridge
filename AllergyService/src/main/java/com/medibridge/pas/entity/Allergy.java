package com.medibridge.pas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "allergy")
public class Allergy {
	@Id
//	@GeneratedValue(generator = CustomIdGenerator.GENERATOR_NAME)
//	@GenericGenerator(name = CustomIdGenerator.GENERATOR_NAME, strategy = "com.pms.entity.CustomIdGenerator", parameters = {
//	@Parameter(name = CustomIdGenerator.PREFIX_PARAM, value = "AL0") })
	@Column(name = "allergy_id")
	private String allergyId;
	
//	@NotBlank
	@Column(name = "allergy_name")
	private String allergyName;
	
//	@NotBlank
	@Column
	private String notes;

	public String getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(String allergyId) {
		this.allergyId = allergyId;
	}

	public String getAllergyName() {
		return allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
