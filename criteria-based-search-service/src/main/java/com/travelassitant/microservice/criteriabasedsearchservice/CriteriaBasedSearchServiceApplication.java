package com.travelassitant.microservice.criteriabasedsearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CriteriaBasedSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriteriaBasedSearchServiceApplication.class, args);
	}

}
