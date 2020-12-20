package com.duhamel.primefactors.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimeFactorsServiceTest {
	@Autowired
	PrimeFactorsService primeFactorsService;

	@Test
	void canaryTest() {
		assertTrue(true);
	}
	@Test
	void primeFactorOfOneIsEmptyList() {
		assertEquals(Arrays.asList(), primeFactorsService.factor(1));
	}
	@Test
	void primeFactorOfTwoIsTwo() {
		assertEquals(Arrays.asList(2), primeFactorsService.factor(2));
	}
	@Test
	void primeFactorOfThreeIsThree() {
		assertEquals(Arrays.asList(3), primeFactorsService.factor(3));
	}
	@Test
	void primeFactorOfFourIsTwoTwos() {
		assertEquals(Arrays.asList(2, 2), primeFactorsService.factor(4));
	}
	@Test
	void primeFactorOfFiveIsFivee() {
		assertEquals(Arrays.asList(5), primeFactorsService.factor(5));
	}
	@Test
	void primeFactorOfSixIsTwoAndThree() {
		assertEquals(Arrays.asList(2, 3), primeFactorsService.factor(6));
	}
	@Test
	void primeFactorOfSevenIsSeven() {
		assertEquals(Arrays.asList(7), primeFactorsService.factor(7));
	}
	@Test
	void primeFactorOfEightIsThreeTwos() {
		assertEquals(Arrays.asList(2, 2, 2), primeFactorsService.factor(8));
	}
	@Test
	void primeFactorOfNineIsTwoThrees() {
		assertEquals(Arrays.asList(3, 3), primeFactorsService.factor(9));
	}
	@Test
	void primeFactorOfSixHundredTwoIsTwoAndSevenAndFortyThree() {
		assertEquals(Arrays.asList(2, 7, 43), primeFactorsService.factor(602));
	}
}
