package com.cg.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.patient.entity.Patient;
import com.cg.patient.repository.PatientRepository;

@Service
public class PatientService implements IPatientService{
	
	@Autowired
	PatientRepository patientrepository;
	@Override
	public List<Patient> findAllPatient() {
		return patientrepository.findAll();
	}
	
	
	public Optional<Patient> findPatientByID(int id) {
		return patientrepository.findById(id);
	}
	
	
	@Override
	public Patient createPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientrepository.save(patient);
	}
	
	
	@Override
	public void deleteByIdPatient( int id) {
		// TODO Auto-generated method stub
		patientrepository.deleteById(id);
		 
	}
	
	@Override
	public Patient updatePatient(Patient patient,int id) {
		// TODO Auto-generated method stub
		Optional<Patient> pt= findPatientByID(id);
		Patient patient1=pt.get();
		
		patient1.setPid(patient.getPid());
		patient1.setPname(patient.getPname());
		patient1.setAddress(patient.getAddress());
		
		return patientrepository.save(patient1);
	}
	

}