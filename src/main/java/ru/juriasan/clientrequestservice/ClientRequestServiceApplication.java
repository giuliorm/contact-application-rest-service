package ru.juriasan.clientrequestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ClientRequestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRequestServiceApplication.class, args);
	}
}
