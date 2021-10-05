package com.aaw.av1aw.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GatewayController {

	@GetMapping("/")
	public String hello() {
		return "Hello!";
	}
}
