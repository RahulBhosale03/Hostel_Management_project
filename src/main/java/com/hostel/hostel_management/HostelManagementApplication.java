package com.hostel.hostel_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HostelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostelManagementApplication.class, args);
	}

}
