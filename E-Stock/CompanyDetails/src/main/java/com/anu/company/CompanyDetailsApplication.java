package com.anu.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CompanyDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyDetailsApplication.class, args);
	}

}
