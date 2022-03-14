package com.gs.exammicrousuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamMicroUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamMicroUsuariosApplication.class, args);
		System.out.println("RUNNING ExamMicroUsuariosApplication OK");
	}

}
