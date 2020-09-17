package com.github.wdstar.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class WebMain {

	public static void main(String[] args) {
		SpringApplication.run(WebMain.class, args);
	}

}
