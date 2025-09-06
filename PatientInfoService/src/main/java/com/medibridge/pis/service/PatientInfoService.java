package com.medibridge.pis.service;

import java.util.List;

import com.medibridge.pis.model.Patient;

public interface PatientInfoService {
	public Patient updateDetails(Patient Patient , String patientId);
	public Patient getPatientInfo(String patientId);
	public List<Patient> showAllAvailability();
}
