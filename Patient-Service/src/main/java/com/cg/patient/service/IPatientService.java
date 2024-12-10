package com.cg.patient.service;

import java.util.List;
import java.util.Optional;

import com.cg.patient.entity.Patient;

public interface IPatientService {
	
	List<Patient> findAllPatient();
	public Optional<Patient> findPatientByID(int id);
	public Patient createPatient(Patient patient);
	public void deleteByIdPatient(int id);
	public Patient updatePatient(Patient patient,int id);

}
