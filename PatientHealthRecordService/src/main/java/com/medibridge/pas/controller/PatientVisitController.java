package com.medibridge.pas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medibridge.pas.entity.Diagnosis;
import com.medibridge.pas.entity.PatientVisitDetails;
import com.medibridge.pas.entity.Prescription;
import com.medibridge.pas.service.PatientVisitService;

@RestController 
public class PatientVisitController {

	@Autowired
	private PatientVisitService service;
	
	@PostMapping("/{patientId}")
	public ResponseEntity<?> save(@PathVariable String patientId, @RequestBody PatientVisitDetails patientVisit) {
		try {
			patientVisit.setPatientId(patientId);
			PatientVisitDetails visit = service.saveVisit(patientVisit);
			return new ResponseEntity<PatientVisitDetails>(visit, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/allvisits/{patientId}")
	public ResponseEntity<?> getAll(@PathVariable String patientId) {
		ResponseEntity<?> resp = null;
		List<PatientVisitDetails> list = service.getAllVisit(patientId);
		if (list == null || list.isEmpty()) {
			String message = "No Data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
		} else {
			resp = new ResponseEntity<List<PatientVisitDetails>>(list, HttpStatus.OK);
		}
		return resp;
	}
	
	
	@GetMapping("/recent/{patientId}")
	public ResponseEntity<?> getRecentVisit(@PathVariable String patientId){
		PatientVisitDetails pvd = service.getRecentVisitDetails(patientId);
		if(pvd!=null)
			return new ResponseEntity<>(pvd,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Data not found",HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping("/{visitId}")
	public ResponseEntity<?> update(@PathVariable("visitId") String visitId,@RequestBody PatientVisitDetails patientVisit){

		// check for id exist
		if (visitId != null) {
			PatientVisitDetails updatedVisit = service.updateVisit(visitId, patientVisit);
			return new ResponseEntity<>(updatedVisit, HttpStatus.OK);
		} else {
			// not exist
			return new ResponseEntity<String>("Record not found", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{visitId}")
	public ResponseEntity<?> deleteVisit(@PathVariable String visitId){
		if (visitId != null) {
			service.deleteVisit(visitId);
			return new ResponseEntity<String>("Visit Deleted", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("VisitId not found", HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	@PostMapping("/test/{visitId}")
	public ResponseEntity<?> saveTest(@PathVariable("visitId") String visitId, @RequestBody Diagnosis diagnosis) {
		Diagnosis status = service.saveDiagnosis(visitId, diagnosis);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/test/{visitId}")
	public ResponseEntity<?> getAllTests(@PathVariable("visitId") String visitId){
		ResponseEntity<?> resp = null;
		List<Diagnosis> tests = service.getAllDiagnosis(visitId);
		if (tests == null || tests.isEmpty()) {
			String message = "No Data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
		} else {
			resp = new ResponseEntity<List<Diagnosis>>(tests, HttpStatus.OK);
		}
		return resp;
	}
	
	
	@DeleteMapping("/test/{testId}")
	public ResponseEntity<String> deleteTestById(@PathVariable("testId") String diagnosisId) {
		if (diagnosisId != null) {
			// if exist
			service.deleteDiagnosis(diagnosisId);
			return new ResponseEntity<String>("Deleted test successfully", HttpStatus.ACCEPTED);
		} else { // not exist
			return new ResponseEntity<String>("'" + diagnosisId + "' does not Exist", HttpStatus.BAD_REQUEST);
		}
	}

	
	@PostMapping("/prescription/{visitId}")
	public ResponseEntity<?> savePrescription(@PathVariable("visitId") String visitId, @RequestBody Prescription prescribe) {
		Prescription status = service.savePrescription(visitId, prescribe);

		return new ResponseEntity<Prescription>(status, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/prescription/{visitId}")
	public ResponseEntity<?> getAllPriscriptions(@PathVariable("visitId") String visitId) {
		List<Prescription> prescriptions = service.getAllPrescriptions(visitId);
		if (prescriptions == null || prescriptions.isEmpty()) {
			String message = "No Data Found";
			return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
		}
	}
}
