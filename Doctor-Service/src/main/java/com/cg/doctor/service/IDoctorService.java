package com.cg.doctor.service;

import java.util.List;
import java.util.Optional;

import com.cg.doctor.entity.Doctor;

public interface IDoctorService {
	
	List<Doctor> findAllDoctor();
	public Optional<Doctor> findDoctorByID(int id);
	public Doctor createDoctor(Doctor doctor);
	public void deleteByIdDoctor(int id);
	public Doctor updateDoctor(Doctor doctor,int id);
	
	public int getCountByDoctordname(String name);
}
