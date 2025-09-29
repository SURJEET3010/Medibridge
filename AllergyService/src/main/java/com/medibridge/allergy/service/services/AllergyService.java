package com.medibridge.allergy.service.services;

import java.util.List;

import com.medibridge.allergy.service.entity.Allergy;

public interface AllergyService {

	public List<Allergy> getAllergies();

	public Allergy getAllergyById(String allergyId);

	/*
	 * public Allergy saveAllergy(Allergy allergy);
	 * 
	 * public void deleteAllergy(String allergyId) throws AllergyServiceException;
	 * 
	 * public Allergy updateAllergy(Allergy allergy,String allergyId) throws
	 * AllergyServiceException;
	 */
	
}
