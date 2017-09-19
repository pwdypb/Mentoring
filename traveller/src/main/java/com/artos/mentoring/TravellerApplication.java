package com.artos.mentoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TravellerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TravellerApplication.class, args);
	}
}
