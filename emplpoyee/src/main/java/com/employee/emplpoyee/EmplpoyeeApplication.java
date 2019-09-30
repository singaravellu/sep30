package com.employee.emplpoyee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class EmplpoyeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmplpoyeeApplication.class, args);
	}

}
