package com.github.wdstar.springboot.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloMVC
 */
@Controller
public class HelloMVC {

	@GetMapping("/greet-mvc")
	public String greet(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		System.out.println("HelloMVC.greet() called.");
		model.addAttribute("name", name);
		// greet.html template.
		return "greet";
	}

}
