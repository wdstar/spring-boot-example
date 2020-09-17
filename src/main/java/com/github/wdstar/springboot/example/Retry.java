package com.github.wdstar.springboot.example;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Retry {

	@Retryable(value = { Throwable.class })
	public void targetMethod() {
		logger.info("targetMethod() is called.");
		throw new IllegalStateException("targetMethod() failed.");
	}

}
