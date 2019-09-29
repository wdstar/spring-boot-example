package com.github.wdstar.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloCLI {

	public static void main(String[] args) {
		// Note: If you need to run some specific code once the SpringApplication has
		// started, you can implement the ApplicationRunner or CommandLineRunner
		// interfaces.
		// https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-command-line-runner
		try (ConfigurableApplicationContext ctx = SpringApplication.run(HelloCLI.class, args)) {
			HelloCLI app = ctx.getBean(HelloCLI.class);
			app.run(args);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
	}

}
