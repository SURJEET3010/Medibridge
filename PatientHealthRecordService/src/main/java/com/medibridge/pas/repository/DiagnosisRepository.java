package com.medibridge.pas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medibridge.pas.entity.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, String> {
	
	
	@Query(value="SELECT * FROM TEST_DETAILS WHERE VISIT_ID=?1", nativeQuery=true)
	public List<Diagnosis> getAllTests(@Param("visitId") String visitId);
	
	
}
