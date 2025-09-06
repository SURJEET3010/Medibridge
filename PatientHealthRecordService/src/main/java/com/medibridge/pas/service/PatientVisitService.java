package com.medibridge.pas.service;

import java.util.List;

import com.medibridge.pas.entity.Diagnosis;
import com.medibridge.pas.entity.PatientVisitDetails;
import com.medibridge.pas.entity.Prescription;

public interface PatientVisitService {

	public PatientVisitDetails saveVisit(PatientVisitDetails pvd);
	public PatientVisitDetails updateVisit(String visitId,PatientVisitDetails pvd);
	public void deleteVisit(String pId);
	public List<PatientVisitDetails> getAllVisit(String patientId);
	public PatientVisitDetails getRecentVisitDetails(String patientId);
	
	public Diagnosis saveDiagnosis(String visitId,Diagnosis diagnosis);
	public void deleteDiagnosis(String testId);
//	public TestDetails updateTest(String testId,TestDetails test);
	public List<Diagnosis> getAllDiagnosis(String visitId);
	
	
	public Prescription savePrescription(String visitId,Prescription prescription);
	public List<Prescription> getAllPrescriptions(String visitId);
}
