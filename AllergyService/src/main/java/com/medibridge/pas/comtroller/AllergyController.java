package com.medibridge.pas.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medibridge.pas.entity.Allergy;
import com.medibridge.pas.service.AllergyService;

@RestController
public class AllergyController {

	@Autowired
	private AllergyService allergyService;

	@GetMapping("/allergies")
	public ResponseEntity<List<Allergy>> findAllAllergies(){
		List<Allergy> allergies = allergyService.getAllergies();
		return ResponseEntity.ok(allergies);
	}

	@GetMapping("/allergy")
	public ResponseEntity<Allergy> findAllergyById(@RequestParam("allergyId") String allergyId){
		Allergy allergy = allergyService.getAllergyById(allergyId);
		return ResponseEntity.ok(allergy);
	}

}
