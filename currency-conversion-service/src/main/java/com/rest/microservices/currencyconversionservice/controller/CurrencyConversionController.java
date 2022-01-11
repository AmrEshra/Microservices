package com.rest.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.microservices.currencyconversionservice.CurrencyConversion;
import com.rest.microservices.currencyconversionservice.services.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService currencyConversionService;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculate(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversion currencyConversion = currencyConversionService.calculateQuantity(from, to, quantity);
		return currencyConversion;
		
	}
}
