package com.bibliotech.biblioTech.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"package com.bibliotech.biblioTech.controller"})
public class BiblioTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioTechApplication.class, args);
	}

}
