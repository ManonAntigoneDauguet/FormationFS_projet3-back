package com.chatop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ChatopApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		// Loading of the environmental constants
		System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));
		System.setProperty("DATABASE_USERNAME", dotenv.get("DATABASE_USERNAME"));
		// Launch
		System.out.println("Pikachu says hello !");
		SpringApplication.run(ChatopApplication.class, args);
		System.out.println("Pikachu says goodbye");
	}
}
