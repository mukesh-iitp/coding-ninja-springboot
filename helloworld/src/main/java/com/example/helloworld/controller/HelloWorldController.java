package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello coding ninjas!, calling using @RequestMapping";
	}
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello from earth! using @GetMapping annotation";
	}
	
	@GetMapping("/hello-mars/{name}")
	public String helloFromMars(@PathVariable String name) {
		return "Hello from Mars "+name;
	}
}
