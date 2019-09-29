package com.github.wdstar.springboot.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@RequestMapping("/greet")
	public String greet() {
		return "Hello World!";
	}

}
