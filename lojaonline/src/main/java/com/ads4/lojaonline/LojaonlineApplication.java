package com.ads4.lojaonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LojaonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaonlineApplication.class, args);
	}

}
