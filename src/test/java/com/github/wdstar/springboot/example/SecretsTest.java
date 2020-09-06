package com.github.wdstar.springboot.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecretsTest {

	private Secrets secrets;

	@BeforeEach
	public void setUp() {
		// test it by POJO.
		secrets = new Secrets("password", "token");
	}

	@Test
	public void testAccessors() {
		assertThat(secrets.getPassword()).isEqualTo("password");
		assertThat(secrets.getToken()).isEqualTo("token");
	}

}
