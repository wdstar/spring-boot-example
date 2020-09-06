package com.github.wdstar.springboot.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecretPropsTest {

	private SecretProps props;

	@BeforeEach
	public void setUp() {
		// test it by POJO.
		props = new SecretProps();
	}

	@Test
	public void testAccessors() {
		assertThat(props.getPassword()).isEqualTo("changeMeByEnvVar");
		assertThat(props.getToken()).isEqualTo("changeMeByEnvVar");
	}

}
