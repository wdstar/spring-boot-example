package com.github.wdstar.springboot.example.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "example.secrets")
@Getter
@Setter
// Not static class for unit test.
public class SecretProps {

	// set default value for not-null.
	private String password = "changeMeByEnvVar";

	private String token = "changeMeByEnvVar";

}
