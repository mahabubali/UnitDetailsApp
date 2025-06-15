package org.me.unitDetailsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitDetailsService {

	public static void main(String[] args) {
		System.out.println("Hello from Spring boot3!");
		SpringApplication.run(UnitDetailsService.class, args);
	}
}
