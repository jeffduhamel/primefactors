package com.duhamel.primefactors.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrimeFactorsServiceImpl implements PrimeFactorsService {

	@Override
	public List factor(int number) {
		List factors = new ArrayList();
		for(int divisor = 2; number > 1; divisor++)
			for (; number % divisor == 0; number /= divisor)
				factors.add(divisor);
		return factors;
	}

}
