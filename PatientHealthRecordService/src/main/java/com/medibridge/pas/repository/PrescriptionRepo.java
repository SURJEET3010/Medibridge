package com.medibridge.pas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medibridge.pas.entity.Prescription;

public interface PrescriptionRepo extends JpaRepository<Prescription, String> {
	
	@Query(value="SELECT * FROM PRESCRIPTION_DETAILS WHERE visit_id=?1", nativeQuery = true)
	public List<Prescription> getPrescriptions(@Param("visitId") String visitId);
}
