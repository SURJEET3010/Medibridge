package com.medibridge.pas.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medibridge.pas.entity.Physician;
import com.medibridge.pas.repository.PhysicianRepository;
import com.medibridge.pas.service.PhysicianService;

public class PhysicianServiceImpl implements PhysicianService {

	@Autowired
	private PhysicianRepository physicianRepository;
	
	@Override
	public List<Physician> showAllAvailability() {
		List<Physician> physicianList = physicianRepository.findAll();
		if(physicianList == null) {
			return null;
		}
		return physicianList;
	}

	@Override
	public List<Physician> showAvailability(boolean availability) {
		List<Physician> physicianList = physicianRepository.findByValue(availability);
		if(physicianList == null) {
			return physicianList;
		}
		return null;
	}

	@Override
	public boolean deletePhysician(String physicianId) {
		boolean existsById = physicianRepository.existsById(physicianId);
		physicianRepository.deleteById(physicianId);
		if(existsById == false) {
			return false;
		}
		
		return true;
	}

	@Override
	public int updatePhysicianInfo(Physician physician, String physicianId) {
		boolean existsById = physicianRepository.existsById(physicianId);
		if(!existsById) {
			return 0;
		}
		
		int result = physicianRepository.updateByPhysicianId(physicianId, existsById, physician.getStartDate(), physician.getEndDate());
		return result;
	}

	@Override
	public List<Physician> findAllPhysicianOnDate(LocalDate date) {
		List<Physician> list = physicianRepository.findByDate(date);
		if(list == null) {
			return null;
		}
		return list;
	}

	@Override
	public void addPhysicianInfo(Physician physician) {
		Physician result = physicianRepository.save(physician);
		System.out.println("Physician information save ! " + result);
		
	}

}
