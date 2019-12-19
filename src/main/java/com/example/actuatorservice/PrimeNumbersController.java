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

    @GetMapping("/")
    @ResponseBody
    public String homeResponse() {
        //TODO: Besserer Welcome Screen
        return "Hallo! Willkommen auf unserer Seite!";
    }

    //http://localhost:9000/getPrimeNumbersInt?value=5
    @GetMapping("/getPrimeNumbersInt")
    @ResponseBody
    public POJOPrimeNumbersIntegerList responseCalculationInteger(@RequestParam(value = "value", required = true) int primeCount) {

        System.out.println("Connection established");
        System.out.println("Received prime numbers request for integer list with value " + primeCount);

        //create JSON container object
        POJOPrimeNumbersIntegerList primeNumbers = new POJOPrimeNumbersIntegerList(primeCount);

        //calculate primeNumbers, parse and sets
        primeNumbers.setPrimeNumberList(CalculatePrimeNumbers.toIntArray(CalculatePrimeNumbers.calculate(primeCount)));

        System.out.println("Returning result...\nClosing connection...\n--------------------\nAccept modus: waiting for connection...");

        return primeNumbers;
    }

    //http://localhost:9000/getPrimeNumbersString?value=5
    @GetMapping("/getPrimeNumbersString")
    @ResponseBody
    public POJOPrimeNumbersString responseCalculationString(@RequestParam(value = "value", required = true) int primeCount) {

        System.out.println("Connection established");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received prime numbers request for string with value " + primeCount);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //calculate prime numbers
        Object[] listOfPrimeNumbers = CalculatePrimeNumbers.calculate(primeCount).toArray();

        //convert list into String with whitespaces
        String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(listOfPrimeNumbers);

        // create JSON container object
        POJOPrimeNumbersString primeNumbers = new POJOPrimeNumbersString(primeNumbersString);

        System.out.println("Returning result...\nClosing connection...\n--------------------\nAccept modus: waiting for connection...");

        return primeNumbers;
    }

    //http://localhost:9000/getPrimeNumbersObject?value=5
    @GetMapping("/getPrimeNumbersObject")
    @ResponseBody
    public POJOPrimeNumbersObject responseCalculationObject(@RequestParam(value = "value", required = true) int primeCount) {

        System.out.println("Connection established");
        System.out.println("Received prime numbers request for struct with value " + primeCount);

        //calculate prime numbers
        int[] integerListOfPrimeNumbers = CalculatePrimeNumbers.toIntArray(CalculatePrimeNumbers.calculate(primeCount));
        Object[] objectListOfPrimeNumbers = CalculatePrimeNumbers.convertToObjectArray(integerListOfPrimeNumbers);

        //convert list into String with whitespaces
        String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(objectListOfPrimeNumbers);

        // create JSON container Object
        POJOPrimeNumbersObject primeNumbers = new POJOPrimeNumbersObject(integerListOfPrimeNumbers, primeNumbersString);

        System.out.println("Returning result...\nClosing connection...\n--------------------\nAccept modus: waiting for connection...");

        return primeNumbers;
    }


}
