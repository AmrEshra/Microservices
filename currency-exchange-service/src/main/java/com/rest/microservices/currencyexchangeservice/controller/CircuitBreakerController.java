package com.rest.microservices.currencyexchangeservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	@GetMapping("/sample-api")
	
	// if calling "dummy" Microservice failed @Retry will fallback the response to "fallBackResponse"
	@Retry(name = "default", fallbackMethod = "fallBackResponse")
	
	public String sampleApi() {
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8000/dummy", String.class);
		
		return response.getBody();
	}
	
	public String fallBackResponse(Exception ex) {
		return "fallBack-response";
	}
}
