package com.github.maikoncarlos.apiexternacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiexternaCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiexternaCepApplication.class, args);
	}

}
