package com.medibridge.pas.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository extends JpaRepository<Allergy, String> {
	
	public Allergy findByAllergyId(String allergyId);
}
