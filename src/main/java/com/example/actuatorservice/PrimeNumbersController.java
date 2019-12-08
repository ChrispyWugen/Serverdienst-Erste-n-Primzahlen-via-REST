package com.example.actuatorservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrimeNumbersController {

	//http://localhost:9000/getPrimeNumbersInt?value=5
	@GetMapping("/getPrimeNumbersInt")
	@ResponseBody
	public PrimeNumbersInteger responseCalculationInteger(@RequestParam(value="value", required=true) int primeCount) {

		PrimeNumbersInteger primeNumbers = new PrimeNumbersInteger(primeCount);

		//calculate primeNumbers, parse and set
		primeNumbers.setPrimeNumberList(CalculatePrimeNumbers.toIntArray(CalculatePrimeNumbers.calculate(primeCount)));

		return primeNumbers;
	}

	//http://localhost:9000/getPrimeNumbersString?value=5
	@GetMapping("/getPrimeNumbersString")
	@ResponseBody
	public PrimeNumbersString responseCalculationString(@RequestParam(value="value", required=true) int primeCount) {

		PrimeNumbersString primeNumbers = new PrimeNumbersString();

		//do something

		return primeNumbers;
	}



}
