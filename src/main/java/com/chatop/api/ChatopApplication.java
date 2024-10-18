package com.chatop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ChatopApplication {

	public static void main(String[] args) {
		System.out.println("Pikachu says hello !");
		SpringApplication.run(ChatopApplication.class, args);
		System.out.println("Pikachu says goodbye");
	}
}
