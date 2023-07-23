package com.example.TeamMicroservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class TeamMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamMicroserviceApplication.class, args);
	}

}
