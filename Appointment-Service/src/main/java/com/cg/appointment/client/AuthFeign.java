package com.cg.appointment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "SPRINGBOOT-JWT", url = "http://localhost:8080" )//springlatestSecurity port no.
	public interface AuthFeign {
		@GetMapping("/validate")
		public boolean getTokenValidity(@RequestHeader("Authorization") String token);
	}

