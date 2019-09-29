package com.github.wdstar.springboot.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloCLI implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HelloCLI.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
	}

}
