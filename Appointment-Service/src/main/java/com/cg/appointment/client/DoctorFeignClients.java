package com.cg.appointment.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.appointment.DTO.DoctorDTO;
import com.cg.appointment.entity.Appointment;

import feign.Headers;

@Headers("Content-Type: application/json")
@FeignClient(name = "Doctor-Service", url = "${DOCTOR-SERVICE:http://localhost:9090}",fallback = DoctorFeignClientFallback.class)
public interface DoctorFeignClients {

    // Fetch list of doctors (appointments)
    @GetMapping("/api/doctors")
    List<DoctorDTO> doctorResponse1();
	
    @GetMapping(path = "/api/doctorbyid/{did}")
	DoctorDTO getByDoctorId(@PathVariable int did);
}