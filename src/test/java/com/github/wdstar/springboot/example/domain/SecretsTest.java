package com.github.wdstar.springboot.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecretsTest {

	private Secrets secrets;

	@BeforeEach
	public void setUp() {
		// test it by POJO.
		secrets = new Secrets("password", "token");
	}

	@Test
	void testAccessors() {
		assertThat(secrets.getPassword()).hasToString("password");
		assertThat(secrets.getToken()).hasToString("token");
	}

}
