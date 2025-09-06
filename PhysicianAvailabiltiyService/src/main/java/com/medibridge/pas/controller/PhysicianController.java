package com.medibridge.pas.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.medibridge.pas.entity.Physician;
import com.medibridge.pas.service.PhysicianService;

public class PhysicianController {

	@Autowired
	PhysicianService physicianService;

	public ResponseEntity<List<Physician>> getPhysicianByAvailablity(
			@RequestParam(required = false, value = "availability") boolean availability) {

		List<Physician> availabilityList;

		if (Objects.nonNull(availability) && availability) {
			availabilityList = physicianService.showAvailability(availability);
		} else {
			availabilityList = physicianService.showAllAvailability();
		}

		if (availabilityList == null) {
			return null;
		}

		return ResponseEntity.ok().body(availabilityList);
	}

	
	@PostMapping("/physician-availability")
	public ResponseEntity<String> addPhysician(@RequestBody Physician physician) {
		Physician phy = null;

		physicianService.addPhysicianInfo(physician);
		System.out.println(physician);
		return ResponseEntity.status(HttpStatus.CREATED).body("Physician Information saved !");

	}
	
	
	@DeleteMapping("/physician-availability/{physicianId}")
	public ResponseEntity<Void> deletePhysician(@PathVariable("physicianId") String physicianId) {
		boolean bool = false;

		bool = this.physicianService.deletePhysician(physicianId);
		if (bool == true) {
			System.out.println("Deleted succesfully");
			return ResponseEntity.status(HttpStatusCode.valueOf(202)).build();
		} else {
			return null;
		}

	}
	 

}
