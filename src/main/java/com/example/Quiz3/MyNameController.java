package com.example.Quiz3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyNameController {

	// private static final String template = "Hello my name is, %s!";

	@GetMapping("/hello")
	public String myName(@RequestParam(value = "name", defaultValue = "User") String name) {
		return "Hello my name is " + (new MyName(name)).toString();
		// return new MyName(String.format(template, name));
	}
}
