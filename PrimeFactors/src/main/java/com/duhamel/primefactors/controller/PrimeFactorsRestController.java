package com.duhamel.primefactors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duhamel.primefactors.services.PrimeFactorsService;

@RestController
public class PrimeFactorsRestController {
	
	@Autowired
	private PrimeFactorsService primeFactorsService;
	
	@RequestMapping(method = RequestMethod.GET, path="/factors", produces = "application/json")
	ResponseEntity<?> getPrimeFactors(@RequestParam int number) {
		return new ResponseEntity<>(primeFactorsService.factor(number), HttpStatus.OK);
	}

}
