package com.github.wdstar.springboot.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "example.secrets")
// Not static class for unit test.
public class SecretProps {

	@Getter
	@Setter
	// set default value for not-null.
	private String password = "changeMeByEnvVar";

	@Getter
	@Setter
	private String token = "changeMeByEnvVar";

}
