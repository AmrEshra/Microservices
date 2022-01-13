package com.rest.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.microservices.currencyconversionservice.CurrencyConversion;
import com.rest.microservices.currencyconversionservice.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculate(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		// Call direct URL
		/*
		 * HashMap<String, String> uriVariables = new HashMap<String, String>();
		 * uriVariables.put("from", from); uriVariables.put("to", to);
		 * 
		 * ResponseEntity<CurrencyConversion> response = new
		 * RestTemplate().getForEntity(
		 * "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
		 * CurrencyConversion.class, uriVariables);
		 * 
		 * CurrencyConversion currencyConversion = response.getBody();
		 */

		// Call URL using Feign Proxy
		CurrencyConversion currencyConversion = proxy.calculateQuantity(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setEnvironment(currencyConversion.getEnvironment() + " : Feign Proxy");
		return currencyConversion;
	}

	@GetMapping("/currency-conversion")
	public CurrencyConversion calculateV2(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal quantity) {

		// Call URL using Feign Proxy
		CurrencyConversion currencyConversion = proxy.calculateQuantityV2(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setEnvironment(currencyConversion.getEnvironment() + " : Feign Proxy V2");
		
		return currencyConversion;
	}
}
