package com.rest.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.microservices.bean.Limits;
import com.rest.microservices.config.Config;

@RestController
@RequestMapping("/limits-api/")
public class LimitsController {
	
	@Autowired
	private Config config;
	
	@GetMapping("/limits")
	public Limits getLimits() {
		
		return new Limits(config.getMin(), config.getMax());
		
	}

}
