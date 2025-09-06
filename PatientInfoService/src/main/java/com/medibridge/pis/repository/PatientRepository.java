package com.medibridge.pis.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medibridge.pis.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{
	public Patient findByPatientId(String patientId);	
	
	public boolean existsById(String patientId);
}
