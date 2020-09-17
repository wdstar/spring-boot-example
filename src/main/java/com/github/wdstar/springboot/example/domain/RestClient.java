
package com.github.wdstar.springboot.example.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestClient {

	private final CircuitBreakerFactory circuitBreakerFactory;

	private final RestTemplate rest;

	@Autowired
	public RestClient(CircuitBreakerFactory circuitBreakerFactory, RestTemplate rest) {
		this.circuitBreakerFactory = circuitBreakerFactory;
		this.rest = rest;
	}

	public Map targetMethodWithCircuitBreaker() {
		return circuitBreakerFactory.create("targetMethod").run(this.targetMethodSuppplier(), t -> {
			logger.warn("restClient::targetMethod() call failed", t);
			final Map<String, String> fallback = new HashMap<>();
			fallback.put("hello", "circuit breaker fallback");
			return fallback;
		});
	}

	public Map targetMethod() {
		logger.info("targetMethod() is called.");
		Map res = rest.getForObject("http://localhost:8080/invalid", Map.class);
		if (res == null) {
			throw new IllegalStateException("restClient::targetMethod() failed.");
		}

		return res;
	}

	public Supplier<Map> targetMethodSuppplier() {
		return this::targetMethod;
	}

}
