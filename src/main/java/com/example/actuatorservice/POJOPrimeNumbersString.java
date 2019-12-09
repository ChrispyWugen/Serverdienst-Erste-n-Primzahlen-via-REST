package com.example.actuatorservice;

/**
 * An implementation of POJOPrimeNumbersString
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
public class POJOPrimeNumbersString {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private String primeNumbers = "";

    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */
    POJOPrimeNumbersString(String s){
        this.primeNumbers = s;
    }

    /* ---------------------------------------- Methods ------------------------------------------------------------- */



    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */
    public String getPrimeNumbers() {
        return primeNumbers;
    }

    public void setPrimeNumbers(String primeNumbers) {
        this.primeNumbers = primeNumbers;
    }


    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
