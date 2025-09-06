package com.medibridge.pas.service;

import java.time.LocalDate;
import java.util.List;

import com.medibridge.pas.entity.Physician;

public interface PhysicianService {

	public List<Physician> showAllAvailability();
	public List<Physician> showAvailability(boolean availability);
	public boolean deletePhysician(String physicianId);
	public int updatePhysicianInfo(Physician physician, String physicianId);
	public List<Physician> findAllPhysicianOnDate(LocalDate date);
	public void addPhysicianInfo(Physician physician) ;
}
