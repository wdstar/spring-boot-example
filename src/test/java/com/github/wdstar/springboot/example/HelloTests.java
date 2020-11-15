package com.github.wdstar.springboot.example;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.wdstar.springboot.example.controller.Hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HelloTests {

	@Autowired
	private Hello controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
