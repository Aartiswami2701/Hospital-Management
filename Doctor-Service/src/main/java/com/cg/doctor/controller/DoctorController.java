package com.cg.doctor.controller;

import java.util.List;



import java.util.Optional;

import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.doctor.entity.Doctor;
import com.cg.doctor.service.IDoctorService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;




@RequestMapping("/api")
@RestController
//@Slf4j
public class DoctorController {
	
	@Autowired
	IDoctorService doctorservice;
	
    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	 
	 @RequestMapping("/log/alldoctors")
	 public List<Doctor> displayProduct()
	 { 	 logger.info("Doctor list is going to dispaly");
		 List<Doctor> listDoctors = doctorservice.findAllDoctor();
		 System.out.println(" Hello");
		 logger.info("Doctor list displayed");
		 logger.debug("Missing Doctor.png");
	
		 return listDoctors;
	 }
	 
	 
	 
	@GetMapping("/doctors")
	public List<Doctor> getalldoctors(){
		
	       
		return doctorservice.findAllDoctor();
		
	}
    @Value("${app.name}")
	private String appName;
	
	
    @GetMapping(path = "/doctorbyid/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable int id) {
        Optional<Doctor> doctor = doctorservice.findDoctorByID(id);

        if (doctor.isPresent()) {
            return ResponseEntity.ok(doctor.get()); // Return 200 OK with the doctor data
        } else {
            // Return 404 Not Found with a meaningful message
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND)
                    .body("Doctor with ID " + id + " not found in the " + appName + " system.");
        }
    }
	@PostMapping("/createdoctor")
	public Doctor createDoc(@RequestBody @Valid Doctor doctor) {
		
		return  doctorservice.createDoctor(doctor);
	
	}
	@DeleteMapping("/deletedoctor/{id}")
	public void deleteDoctorById(@PathVariable int id) {
		
	  doctorservice.deleteByIdDoctor(id) ;
	  
	}
	

	
	@PutMapping("/updatedoctors")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		int proid=doctor.getDid();
		return doctorservice.updateDoctor(doctor, proid);
		
	}
	
	
	@GetMapping(path="/doctorcount/{dname}")
	public int getCountByDoctor(@PathVariable String dname){
		return doctorservice.getCountByDoctordname(dname);
	}
	

	
}