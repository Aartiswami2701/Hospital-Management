package com.cg.patient.controller;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.patient.entity.Patient;
//import com.cg.patient.exception.ResourceNotFound;
import com.cg.patient.service.IPatientService;


@RequestMapping("/api")
@RestController
public class PatientController {
	
	@Autowired
	
	IPatientService patientservice;
	@GetMapping("/patients")
	public List<Patient> getallpatients(){
		return patientservice.findAllPatient();
		
	}
	
	
	
	@GetMapping(path="/patientbyid/{id}")
	public Optional<Patient> getpatientByid(@PathVariable int id) {
		return patientservice.findPatientByID(id);	
	}
	
//	@GetMapping("/patientException/{id}")
//	Optional<Patient>findByProductIdFromDBWithException(@PathVariable int id) throws ResourceNotFound
//	{	Optional<Patient> patient = patientservice.findPatientByID(id);
//	
//	patient.orElseThrow(() -> new ResourceNotFound("patient not found for this id :: " + id));
//    	System.out.println(id);
//    return patient;	
//	}
//	
	
	
	@PostMapping("/createpatient")
	public Patient createpatient(@RequestBody Patient p) {
		
		return  patientservice.createPatient(p);
	
	}
	
	@DeleteMapping("/deletepatient/{id}")
	public void deletePatient(@PathVariable int id) {
		
	  patientservice.deleteByIdPatient(id) ;
	  
	}
	

	
	@PutMapping("/updatepatient")
	public Patient updatepatient(@RequestBody Patient patient) {
		int id=patient.getPid();
		return patientservice.updatePatient(patient, id);
		
	}
	

	
}