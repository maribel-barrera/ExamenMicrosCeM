package com.gs.exammicromonitoreo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ExamMicroMonitoreoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamMicroMonitoreoApplication.class, args);
		System.out.println("RUNNING ExamMicroMonitoreoApplication OK");
	}

}
