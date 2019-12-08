package com.example.actuatorservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * An implementation of CalculatePrimeNumbers
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
public class CalculatePrimeNumbers {


    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */


    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */
    public static List calculate(int number){

        List<Integer> primes = IntStream.range(2, Integer.MAX_VALUE)
                .filter(n -> isPrime(n))
                .limit(number)      //Limit the number of primes here
                .boxed()
                .collect(Collectors.toList());

        return primes;
    }

    static boolean isPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }

    static int[] toIntArray(List<Integer> primes){
        int[] primeNumbersList = new int[primes.size()];
        for(int i = 0;i < primeNumbersList.length;i++)
            primeNumbersList[i] = primes.get(i);
        return primeNumbersList;

    }


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */



    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
