package com.medibridge.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medibridge.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{
	public Patient findByPatientId(String patientId);	
	
	public boolean existsById(String patientId);
}
