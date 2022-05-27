package com.example.springcloud.config.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ExampleController {

	@Value("${my.greeting}")
	private String greeting;

	@Value("${my.list.values}")
	private List<String> fruits;

	@Value("${my.appName}")
	private String appName;

	@GetMapping("/appName")
	public String appName() {
		return appName;
	}

	@GetMapping("/greeting")
	public String greeting() {
		return greeting;
	}

	@GetMapping("/getFruits")
	public List<String> getFruits() {
		return fruits;
	}

}
