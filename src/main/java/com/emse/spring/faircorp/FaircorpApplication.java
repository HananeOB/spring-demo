package com.emse.spring.faircorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.ErrorManager;

@SpringBootApplication
public class FaircorpApplication {

	public static void main(String[] args) {

		SpringApplication.run(FaircorpApplication.class, "Spring","Hi");


	}

}
