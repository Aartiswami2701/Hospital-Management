package com.cg.patient.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.patient.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	

}
