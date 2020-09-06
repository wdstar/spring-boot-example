package com.github.wdstar.springboot.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SecretsTest {

	private Secrets secrets;

	@Before
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
