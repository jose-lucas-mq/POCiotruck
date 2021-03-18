package com.br.iotruck.pociotrucmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.project.ppaa.model"})
@SpringBootApplication
public class PocIotrucMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocIotrucMicroservicesApplication.class, args);
	}

}
