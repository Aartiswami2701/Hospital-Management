package com.cg.Spring_security_config_cloud_product;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@SpringBootApplication
@EnableConfigServer
public class SpringSecurityConfigCloudProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityConfigCloudProductApplication.class, args);
	}

}
