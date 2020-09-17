package com.github.wdstar.springboot.example.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Secrets {

	private final String password;

	private final String token;

	// better constructor injection.
	public Secrets(@Value("${example.secrets.password}") final String password,
			@Value("${example.secrets.token}") final String token) {
		this.password = password;
		this.token = token;
	}

}
