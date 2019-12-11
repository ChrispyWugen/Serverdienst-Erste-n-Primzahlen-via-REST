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
     * @param number count of prime numbers
     * @return primes List of prime numbers
     */
    static List calculate(int number){

        System.out.println("Calculating prime numbers...");

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
     * @param number number to proof
     * @return
     */
    private static boolean isPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }

    /**
     * Function converts list of integers to integer array
     * @param primes list of integer values
     * @return
     */
    static int[] toIntArray(List<Integer> primes){
        int[] primeNumbersList = new int[primes.size()];
        for(int i = 0;i < primeNumbersList.length;i++)
            primeNumbersList[i] = primes.get(i);
        return primeNumbersList;

    }

    /**
     * Function connverts given object list of prime numbers to a string
     * of prime numbers with whitespaces
     * @param listOfPrimeNumbers list of prime numbers
     * @return
     */
    static String convertArrayToString(Object[] listOfPrimeNumbers){

        String primeNumbersString = "";
        for(Object curInt: listOfPrimeNumbers){
            primeNumbersString = primeNumbersString + curInt.toString() + " ";
        }
        // remove last whitespace
        primeNumbersString = primeNumbersString.substring(0, primeNumbersString.length()-1);

        return primeNumbersString;
    }

    /**
     * Function converts integer array to an object array
     * @param primeNumberArray list of prime numbers
     * @return
     */
    static Object[] convertToObjectArray(int[] primeNumberArray){
        Object[] primeNumbers = new Object[primeNumberArray.length];

        for(int i=0; i<primeNumberArray.length; i++){
            primeNumbers[i] = primeNumberArray[i];
        }

        return primeNumbers;
    }


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */



    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
