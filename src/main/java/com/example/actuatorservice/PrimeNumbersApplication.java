package com.example.actuatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * An implementation of PrimeNumbersApplication
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
@SpringBootApplication
public class PrimeNumbersApplication {

	public static void main(String[] args) {

		SpringApplication.run(PrimeNumbersApplication.class, args);
		System.out.println("--------------------");
		System.out.println("Server start");
		System.out.println("--------------------");
		System.out.println("Accept modus: waiting for connection...");

	}

}
