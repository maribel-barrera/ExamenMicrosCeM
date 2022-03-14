package com.gs.exammicropost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamMicroPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamMicroPostApplication.class, args);
		System.out.println("RUNNING ExamMicroPostApplication OK");
	}

}
