package com.perficient.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nick Umble
 */
@SpringBootApplication
public class CandidateServiceApplication {

	public static String ROOT = "upload-dir";
	
	public static void main(String[] args) {
		SpringApplication.run(CandidateServiceApplication.class, args);
	}
}
