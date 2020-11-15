package com.github.wdstar.springboot.example.controller;

import java.util.Map;

import com.github.wdstar.springboot.example.domain.RestClient;
import com.github.wdstar.springboot.example.domain.Retry;
import com.github.wdstar.springboot.example.domain.SecretProps;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Hello {

	// Unrecommended: field injection.
	@Autowired
	@Nullable
	private BuildProperties buildProperties;

	private final RestClient restClient;

	private final Retry retry;

	private final SecretProps secrets;

	// Recommended: constructor injection.
	@Autowired
	public Hello(final RestClient restClient, final Retry retry, final SecretProps secrets) {
		this.restClient = restClient;
		this.retry = retry;
		this.secrets = secrets;
		if (this.secrets == null) {
			logger.error("secrets field is null!");
		}
	}

	@RequestMapping(path = "/circuitBreaker", method = RequestMethod.GET)
	// = @RequestMapping(value = "/circuitBreaker", method = RequestMethod.GET)
	// = @GetMapping("/circuitBreaker")
	public String circuitBreaker() {
		try {
			Map res = restClient.targetMethodWithCircuitBreaker();
			logger.info(res.toString());
		}
		catch (Exception e) {
			logger.debug("an unexpected exception occurred.", e);
			String msg = "an unexpected exception occurred. " + e.getMessage();
			logger.error(msg);
			return msg;
		}

		return "success.";
	}

	@GetMapping("/greet")
	public String greet() {
		// This log object is generated by the `@Slf4j` annotation.
		logger.info("Hello.greet() called.");

		return "Hello World!";
	}

	@GetMapping("/retry")
	public String retry() {
		try {
			retry.targetMethod();
		}
		catch (final Exception e) {
			return "error: " + e.getMessage();
		}

		return "success.";
	}

	@GetMapping("/version")
	public String version() {
		logger.info("Hello.version() called.");
		String version = "Not Found.";
		if (buildProperties != null) {
			version = buildProperties.getVersion();
			logger.debug(version);
		}

		return version;
	}

}
