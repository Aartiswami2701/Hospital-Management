package com.cg.appointment.client;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.cg.appointment.DTO.DoctorDTO;
import com.cg.appointment.entity.Appointment;


@Component
public class DoctorFeignClientFallback implements DoctorFeignClients {


	@Override
	public List<DoctorDTO> doctorResponse1() {
		// TODO Auto-generated method stub
		return Stream.of(
                new DoctorDTO(5, "Ashwini", "PHD"),
                new DoctorDTO(6, "SHruti", "MBBS")
        ).collect(Collectors.toList());
		
		
	}

	@Override
	public DoctorDTO getByDoctorId(int d_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	}