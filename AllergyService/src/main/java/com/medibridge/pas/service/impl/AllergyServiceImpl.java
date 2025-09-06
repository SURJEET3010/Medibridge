package com.medibridge.pas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibridge.pas.entity.Allergy;
import com.medibridge.pas.entity.AllergyRepository;
import com.medibridge.pas.service.AllergyService;

@Service
public class AllergyServiceImpl implements AllergyService	{

	@Autowired
	private AllergyRepository allergyRepository;
	
	/*
	 * @Override public Allergy saveAllergy(Allergy allergy) { return
	 * allergyRepository.save(allergy); }
	 */


	@Override
	public List<Allergy> getAllergies(){
		
		List<Allergy> list = allergyRepository.findAll();
		if(list == null) {
//			throw new AllergyServiceException("Allergy list is empty");
			return null;
		}
		return list;
	}

	@Override
	public Allergy getAllergyById(String allergyId){
		
		Allergy allergy = allergyRepository.findByAllergyId(allergyId);
		if(allergy == null) {
//			throw new AllergyServiceException("Allergy with given id "+allergyId+" is not found on server");
			return null;
		}
		return allergy;
	}

}
