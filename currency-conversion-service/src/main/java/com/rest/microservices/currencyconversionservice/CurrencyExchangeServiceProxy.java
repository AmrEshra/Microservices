package com.rest.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion calculateQuantity(@PathVariable("from") String from, @PathVariable("to") String to);
	
	@GetMapping("/currency-exchange")
	public CurrencyConversion calculateQuantityV2(@RequestParam("from") String from, @RequestParam("to") String to);

}
