package com.github.wdstar.springboot.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableRetry
public class WebMain {

	public static void main(String[] args) {
		logger.debug("SpringApplication running...");
		SpringApplication.run(WebMain.class, args);
	}

	@Bean
	public Customizer<HystrixCircuitBreakerFactory> defaultConfig() {
		return factory -> factory.configureDefault(id -> HystrixCommand.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey(id)).andCommandPropertiesDefaults(
						HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(3000)));
	}

	@Bean
	public HystrixMetricsBinder registerHystrixMetricsBinder() {
		return new HystrixMetricsBinder();
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder.build();
	}

}
