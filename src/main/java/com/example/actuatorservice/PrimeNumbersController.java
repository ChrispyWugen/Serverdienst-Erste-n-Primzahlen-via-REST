package com.example.actuatorservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * An implementation of PrimeNumbersController
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
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

		//calculate prime numbers
		Object[] listOfPrimeNumbers = CalculatePrimeNumbers.calculate(primeCount).toArray();

		//convert list into String with whitespaces
		String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(listOfPrimeNumbers);

		// create JSON Object
		PrimeNumbersString primeNumbers = new PrimeNumbersString(primeNumbersString);

		return primeNumbers;
	}

	//http://localhost:9000/getPrimeNumbersObject?value=5
	@GetMapping("/getPrimeNumbersObject")
	@ResponseBody
	public PrimeNumbersObject responseCalculationObject(@RequestParam(value="value", required=true) int primeCount) {

		//calculate prime numbers
		int[] integerListOfPrimeNumbers = CalculatePrimeNumbers.toIntArray(CalculatePrimeNumbers.calculate(primeCount));
		Object[] objectListOfPrimeNumbers = CalculatePrimeNumbers.convertToObjectArray(integerListOfPrimeNumbers);

		//convert list into String with whitespaces
		String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(objectListOfPrimeNumbers);

		// create JSON Object
		PrimeNumbersObject primeNumbers = new PrimeNumbersObject(integerListOfPrimeNumbers, primeNumbersString);

		return primeNumbers;
	}




}
