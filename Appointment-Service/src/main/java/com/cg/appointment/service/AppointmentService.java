package com.cg.appointment.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.appointment.DTO.AppointmentDTO;
import com.cg.appointment.DTO.DoctorDTO;
import com.cg.appointment.DTO.PatientDTO;
import com.cg.appointment.client.AuthFeign;
import com.cg.appointment.client.DoctorFeignClientFallback;
import com.cg.appointment.client.DoctorFeignClients;
import com.cg.appointment.client.PatientFeignClient;
import com.cg.appointment.entity.Appointment;
import com.cg.appointment.repository.AppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService{
	
	@Autowired
	AppointmentRepository appointmentrepository;
	
	@Autowired
	PatientFeignClient patientfeignclient;
	
	@Autowired
	DoctorFeignClients doctorfeignclient;
	
	@Override
	public List<Appointment> findAllAppointment() {

		
		return appointmentrepository.findAll();
	}
	
	@Override
	public Appointment createAppointment(Appointment d) {
		// TODO Auto-generated method stub
		return appointmentrepository.save(d);
	}
	@Override
	public void deleteByIdAppointment( int id) {
		// TODO Auto-generated method stub
		appointmentrepository.deleteById(id);
		 
	}
	
	@Override
	public Appointment updateAppointment(Appointment apt,int id) {
		// TODO Auto-generated method stub
		Optional<Appointment> ord= findAppointmentByID(id);
		Appointment or=ord.get();
		
		or.setAid(apt.getAid());
		or.setDate(apt.getDate());
//		or.setDid(apt.getDid());
//		or.setPid(apt.getPid());
		or.setFees(apt.getFees());
		
		or.setIssue(apt.getIssue());
		or.setStatus(apt.getStatus());
		
		return appointmentrepository.save(or);
	}
	
	@Override
	public Optional<Appointment> findAppointmentByID(int id) {
		return appointmentrepository.findById(id);
	}

	@Override
	public AppointmentDTO getAppointmentWithDoctorAndPatient(int appointmentId) {
		// TODO Auto-generated method stub
		Appointment appointment = appointmentrepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id " + appointmentId));
 
        
        DoctorDTO doctor = doctorfeignclient.getByDoctorId(appointment.getDid());
        PatientDTO patient=patientfeignclient.findByPatientId(appointment.getPid());
        
        AppointmentDTO appDTO = new AppointmentDTO();
        appDTO.setAid(appointment.getAid());
        appDTO.setDate(appointment.getDate());
        appDTO.setIssue(appointment.getIssue());
        appDTO.setStatus(appointment.getStatus());
        appDTO.setFees(appointment.getFees());
        appDTO.setDoctor(doctor);
        appDTO.setPatient(patient);
 
        return appDTO;
	}
	@Autowired(required=true)
	AuthFeign af;
	
	@Override
	public boolean hasPermission(String token) {
		boolean flag = af.getTokenValidity(token);
		System.out.println("Flag Token : " + flag);
		return flag;
	}
	

	
	
}