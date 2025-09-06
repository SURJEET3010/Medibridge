package com.medibridge.pis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibridge.pis.model.Patient;
import com.medibridge.pis.repository.PatientRepository;
import com.medibridge.pis.service.PatientInfoService;

@Service
public class PatientInfoServiceImpl implements PatientInfoService{
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public Patient updateDetails(Patient patient, String patientId){
		
		boolean bool = patientRepo.existsById(patientId);
		if(!bool) {
//			throw new PatientServiceException("Given patient Id does not exist "+patientId);
		}
		
		patient.setPatientId(patientId);
		Patient result = patientRepo.save(patient);
		return result;
	}

	// Service for fetching patientpatientRepo info with the help of Id
	@Override
	public Patient getPatientInfo(String patientId) {
		Patient patientinfo = null;
		patientinfo = (Patient) this.patientRepo.findByPatientId(patientId);
		System.out.println("Patient IDc: "+patientId);
		
		if(patientinfo == null) System.out.println("");
//			throw new PatientServiceException("Given patient Id does not exist "+patientId);
			
		return patientinfo;
	}

	// fetching all the patients info , for admin only
	@Override
	public List<Patient> showAllAvailability() {
		List<Patient> list = (List<Patient>) this.patientRepo.findAll();
		
		if(list == null) System.out.println("");
//			throw new PatientServiceException("Patient information does not exist ");
		
		return list;
	}


}
