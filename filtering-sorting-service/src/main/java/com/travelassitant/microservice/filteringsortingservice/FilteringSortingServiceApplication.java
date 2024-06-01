package com.travelassitant.microservice.filteringsortingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FilteringSortingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilteringSortingServiceApplication.class, args);
	}

}
