package com.rest.microservices.currencyexchangeservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.microservices.currencyexchangeservice.CurrencyExchange;
import com.rest.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired 
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public CurrencyExchange findByFromAndTo(String from, String to){
			
		return currencyExchangeRepository.findByFromAndTo(from, to);
		
	}

}
