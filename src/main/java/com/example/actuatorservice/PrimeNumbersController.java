package com.example.actuatorservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public POJOPrimeNumbersIntegerList responseCalculationInteger(@RequestParam(value="value", required=true) int primeCount) {

		//create JSON container object
		POJOPrimeNumbersIntegerList primeNumbers = new POJOPrimeNumbersIntegerList(primeCount);

		//calculate primeNumbers, parse and set
		primeNumbers.setPrimeNumberList(CalculatePrimeNumbers.toIntArray(CalculatePrimeNumbers.calculate(primeCount)));

		return primeNumbers;
	}

	//http://localhost:9000/getPrimeNumbersString?value=5
	@GetMapping("/getPrimeNumbersString")
	@ResponseBody
	public POJOPrimeNumbersString responseCalculationString(@RequestParam(value="value", required=true) int primeCount) {

		//calculate prime numbers
		Object[] listOfPrimeNumbers = CalculatePrimeNumbers.calculate(primeCount).toArray();

		//convert list into String with whitespaces
		String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(listOfPrimeNumbers);

		// create JSON container object
		POJOPrimeNumbersString primeNumbers = new POJOPrimeNumbersString(primeNumbersString);

		return primeNumbers;
	}

	//http://localhost:9000/getPrimeNumbersObject?value=5
	@GetMapping("/getPrimeNumbersObject")
	@ResponseBody
	public POJOPrimeNumbersObject responseCalculationObject(@RequestParam(value="value", required=true) int primeCount) {

		//calculate prime numbers
		int[] integerListOfPrimeNumbers = CalculatePrimeNumbers.toIntArray(CalculatePrimeNumbers.calculate(primeCount));
		Object[] objectListOfPrimeNumbers = CalculatePrimeNumbers.convertToObjectArray(integerListOfPrimeNumbers);

		//convert list into String with whitespaces
		String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(objectListOfPrimeNumbers);

		// create JSON container Object
		POJOPrimeNumbersObject primeNumbers = new POJOPrimeNumbersObject(integerListOfPrimeNumbers, primeNumbersString);

		return primeNumbers;
	}




}
