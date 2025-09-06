package com.medibridge.pas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medibridge.pas.entity.Diagnosis;
import com.medibridge.pas.entity.PatientVisitDetails;
import com.medibridge.pas.entity.Prescription;
import com.medibridge.pas.repository.DiagnosisRepository;
import com.medibridge.pas.repository.PatientVisitRepository;
import com.medibridge.pas.repository.PrescriptionRepo;
import com.medibridge.pas.service.PatientVisitService;

@Service
public class PatientVisitServiceImpl implements PatientVisitService {

	@Autowired
	private PatientVisitRepository patientVisitRepo;
	
	@Autowired
	private DiagnosisRepository diagnosisRepo;
	
	@Autowired
	private PrescriptionRepo prescriptionRepo;
	
	@Override
	public PatientVisitDetails saveVisit(PatientVisitDetails pvd) {
		PatientVisitDetails result = patientVisitRepo.save(pvd);
		if(result == null) {
			return null;
		}
		return result;
	}

	@Override
	public PatientVisitDetails updateVisit(String visitId, PatientVisitDetails pvd) {
		boolean isVisitExist = patientVisitRepo.existsById(visitId);
		if(!isVisitExist) {
			return null;
		}		
		PatientVisitDetails patientVisitDetails = patientVisitRepo.save(pvd);
		return patientVisitDetails;
	}

	@Override
	public void deleteVisit(String pVisitId) {
		boolean isVisitExist = patientVisitRepo.existsById(pVisitId);
		if(!isVisitExist) {
			throw new NullPointerException("Vsist don`t exist");
		}	
		patientVisitRepo.deleteById(pVisitId);
		
	}

	@Override
	public List<PatientVisitDetails> getAllVisit(String patientId) {
		List<PatientVisitDetails> allVisitDetails = patientVisitRepo.getAllVisitDetails(patientId);
		return allVisitDetails;
	}

	@Override
	public PatientVisitDetails getRecentVisitDetails(String patientId) {
		return patientVisitRepo.findByVisitDate(patientId);
	}

	@Override
	public Diagnosis saveDiagnosis(String visitId, Diagnosis diagnosis) {
		Diagnosis result = patientVisitRepo.findById(visitId).map(visit->{
			diagnosis.setVisitDetails(visit);
		      return diagnosisRepo.save(diagnosis);
		    }).orElseThrow(null);
		
		return result;
	}

	@Override
	public void deleteDiagnosis(String testId) {
		if(diagnosisRepo.existsById(testId)) {
			diagnosisRepo.deleteById(testId);
		}else {
			throw new NullPointerException("Can`t delete diagnosis! Id Not found ");
		}
		
	}

	@Override
	public List<Diagnosis> getAllDiagnosis(String visitId) {
		return diagnosisRepo.getAllTests(visitId);
	}

	@Override
	public Prescription savePrescription(String visitId, Prescription prescription) {
		Prescription result = patientVisitRepo.findById(visitId).map(visit->{
			prescription.setVisitDetails(visit);
			return prescriptionRepo.save(prescription);
		}).orElseThrow(null);
		
		return result;
	}

	@Override
	public List<Prescription> getAllPrescriptions(String visitId) {
		if (visitId != null) {
			return prescriptionRepo.getPrescriptions(visitId);
		} else {
			throw new NullPointerException("Data Not found ");
		}
	}

}
