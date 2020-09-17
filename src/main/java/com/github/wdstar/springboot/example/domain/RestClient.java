
package com.github.wdstar.springboot.example.domain;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.retry.annotation.Retryable;
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

	// default: maxAttempts = 3
	@Retryable(value = { Throwable.class }, maxAttempts = 5)
	public Map targetMethodWithCircuitBreaker() {
		// without a fallback function.
		return circuitBreakerFactory.create("targetMethod")
				// run()'s 1st arg is `Supplier<T>` functional interface type.
				// `() -> this.targetMethod()` equals to `this::targetMethod` (method
				// reference).
				.run(this::targetMethod);
	}

	public Map targetMethod() {
		logger.info("targetMethod() is called.");
		Map res = rest.getForObject("http://localhost:8080/invalid", Map.class);
		if (res == null) {
			throw new IllegalStateException("restClient::targetMethod() failed.");
		}

		return res;
	}

}
