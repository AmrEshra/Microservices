package com.rest.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.microservices.currencyexchangeservice.CurrencyExchange;
import com.rest.microservices.currencyexchangeservice.services.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environmant;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getEchangeRate(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange currencyExchange = currencyExchangeService.findByFromAndTo(from, to);
		
		if(currencyExchange == null)
			throw new RuntimeException("Error");
		currencyExchange.setEnvironment(environmant.getProperty("local.server.port"));
		return currencyExchange;
		
	}
}
