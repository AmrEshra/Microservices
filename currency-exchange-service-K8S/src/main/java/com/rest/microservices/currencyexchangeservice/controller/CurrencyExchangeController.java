package com.rest.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		String post = environmant.getProperty("local.server.port");
		String host = environmant.getProperty("HOSTNAME");
		String version = "v1";
		
		currencyExchange.setEnvironment(post + " " + version + " " + host);
		return currencyExchange;
		
	}
	
	@GetMapping("/currency-exchange")
	public CurrencyExchange getEchangeRateV2(@RequestParam String from, @RequestParam String to) {
		
		CurrencyExchange currencyExchange = currencyExchangeService.findByFromAndTo(from, to);
		
		if(currencyExchange == null)
			throw new RuntimeException("Error");
		
		String post = environmant.getProperty("local.server.port");
		String host = environmant.getProperty("HOSTNAME");
		String version = "v1";
		
		currencyExchange.setEnvironment(post + " " + version + " " + host);
		return currencyExchange;
		
	}
	
}
