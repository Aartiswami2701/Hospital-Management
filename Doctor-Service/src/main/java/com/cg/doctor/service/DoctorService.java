package com.cg.doctor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.doctor.entity.Doctor;
import com.cg.doctor.repository.DoctorRepository;

@Service
public class DoctorService implements IDoctorService{
	
	@Autowired
	DoctorRepository doctorrepository;
	@Override
	public List<Doctor> findAllDoctor() {

		
		return doctorrepository.findAll();
	}
	public Optional<Doctor> findDoctorByID(int oid) {
		
		
		
		return doctorrepository.findById(oid);
	}
	@Override
	public Doctor createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorrepository.save(doctor);
	}
	@Override
	public void deleteByIdDoctor( int id) {
		// TODO Auto-generated method stub
		doctorrepository.deleteById(id);
		 
	}
	
	@Override
	public Doctor updateDoctor(Doctor doctor,int proid) {
		// TODO Auto-generated method stub
		Optional<Doctor> d1= findDoctorByID(proid);
		Doctor doc=d1.get();
		
		doc.setDid(doctor.getDid());
		doc.setDname(doctor.getDname());
		doc.setQualification(doctor.getQualification());
		
		return doctorrepository.save(doc);
	}
	@Override
	public int getCountByDoctordname(String name) {
		// TODO Auto-generated method stub
		return doctorrepository.getCountByDoctordname(name);
	}
	

}