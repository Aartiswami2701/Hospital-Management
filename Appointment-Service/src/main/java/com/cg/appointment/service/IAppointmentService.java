package com.cg.appointment.service;

import java.util.List;
import java.util.Optional;

import com.cg.appointment.DTO.AppointmentDTO;
import com.cg.appointment.entity.Appointment;

public interface IAppointmentService {
	
	List<Appointment> findAllAppointment();
	public Optional<Appointment> findAppointmentByID(int id);
	public Appointment createAppointment(Appointment apt);
	public void deleteByIdAppointment(int id);
	public Appointment updateAppointment(Appointment apt,int id);
	public AppointmentDTO getAppointmentWithDoctorAndPatient(int appointmentId);
	public boolean hasPermission(String token);
}