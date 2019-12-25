package com.example.actuatorservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * An implementation of CalculatePrimeNumbers
 * Utilities class to calculate prime numbers or convert given datatypes
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
class CalculatePrimeNumbers {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */

    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    /* ---------------------------------------- Constants ----------------------------------------------------------- */

    /* ---------------------------------------- Constructors -------------------------------------------------------- */

    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    /**
     * Calculates the first n prime numbers
     *
     * @param number count of prime numbers
     * @return primes List of prime numbers
     */
    static List<Integer> calculate(int number) {

        System.out.println(String.format(">>> [Internal] Calculating Primes up to %s", number));

        //generate stream of integer values
        List<Integer> primes = IntStream.range(2, Integer.MAX_VALUE)
                .filter(n -> isPrime(n))
                .limit(number)      //Limit the number of primes here
                .boxed()            //generate a new stream of Integers (?)
                .collect(Collectors.toList());

        return primes;
    }

    /**
     * Function proofs if the given number is a prime number
     *
     * @param number number to proof
     * @return boolean
     */
    private static boolean isPrime(int number) {
        if (number <= 2)
            return number == 2;
        else
            return (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)    //Optimization to check less numbers
                            .noneMatch(n -> (number % n == 0));
    }

    /**
     * Function converts list of integers to integer array
     *
     * @param primes list of integer values
     * @return int-array
     */
    static int[] toIntArray(List<Integer> primes) {
        System.out.println(">>> [Internal] Converting List to Integer-Object");
        int[] primeNumbersList = new int[primes.size()];
        for (int i = 0; i < primeNumbersList.length; i++)
            primeNumbersList[i] = primes.get(i);
        return primeNumbersList;

    }

    /**
     * Function connverts given object list of prime numbers to a string
     * of prime numbers with whitespaces
     *
     * @param listOfPrimeNumbers list of prime numbers
     * @return String
     */
    static String convertArrayToString(Object[] listOfPrimeNumbers) {
        System.out.println(">>> [Internal] Converting List to String-Object");
        String primeNumbersString = "";
        for (Object curInt : listOfPrimeNumbers) {
            primeNumbersString = primeNumbersString + curInt.toString() + " ";
        }
        // remove last whitespace
        primeNumbersString = primeNumbersString.substring(0, primeNumbersString.length() - 1);

        return primeNumbersString;
    }

    /**
     * Function converts integer array to an object array
     *
     * @param primeNumberArray list of prime numbers
     * @return Object-Array
     */
    static Object[] convertToObjectArray(int[] primeNumberArray) {
        System.out.println(">>> [Internal] Converting Integer-Array to Object-Object");
        Object[] primeNumbers = new Object[primeNumberArray.length];

        for (int i = 0; i < primeNumberArray.length; i++) {
            primeNumbers[i] = primeNumberArray[i];
        }

        return primeNumbers;
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
