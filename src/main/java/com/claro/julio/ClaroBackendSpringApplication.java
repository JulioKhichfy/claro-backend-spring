package com.claro.julio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClaroBackendSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ClaroBackendSpringApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	}

}
