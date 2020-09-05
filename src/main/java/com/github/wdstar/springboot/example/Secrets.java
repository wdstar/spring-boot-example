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

	public Secrets(@Value("${example.password}") final String password, @Value("${example.token}") final String token) {
		this.password = password;
		this.token = token;
	}

}
