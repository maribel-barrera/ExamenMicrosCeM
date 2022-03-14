package com.gs.exammicrologginusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamMicroLogginUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamMicroLogginUsuariosApplication.class, args);

		System.out.println("RUNNING ExamMicroLogginUsuariosApplication OK");
	}

}
