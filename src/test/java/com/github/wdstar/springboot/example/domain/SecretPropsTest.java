package com.github.wdstar.springboot.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecretPropsTest {

	private SecretProps props;

	@BeforeEach
	public void setUp() {
		// test it by POJO.
		props = new SecretProps();
	}

	@Test
	void testAccessors() {
		assertThat(props.getPassword()).hasToString("changeMeByEnvVar");
		assertThat(props.getToken()).hasToString("changeMeByEnvVar");
	}

}
