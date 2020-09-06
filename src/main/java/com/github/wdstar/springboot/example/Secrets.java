package com.github.wdstar.springboot.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class Secrets {

	@Getter
	private final String password;

	@Getter
	private final String token;

	// better constructor injection.
	public Secrets(@Value("${example.secrets.password}") final String password,
			@Value("${example.secrets.token}") final String token) {
		this.password = password;
		this.token = token;
	}

}
