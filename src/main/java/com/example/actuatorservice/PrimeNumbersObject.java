package com.example.actuatorservice;

/**
 * An implementation of PrimeNumbersObject
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-08
 */
public class PrimeNumbersObject {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */

    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private int[] primeNumberList; //holds all calculated prime numbers
    private String primeNumbersString = "";

    /* ---------------------------------------- Constants ----------------------------------------------------------- */

    /* ---------------------------------------- Constructors -------------------------------------------------------- */


    PrimeNumbersObject(int[] primeNumberList, String primeNumberString) {
        this.primeNumberList = primeNumberList;
        this.primeNumbersString = primeNumberString;
    }
    /* ---------------------------------------- Methods ------------------------------------------------------------- */


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */
    public int[] getPrimeNumberList() {
        return primeNumberList;
    }

    void setPrimeNumberList(int[] list) { this.primeNumberList = list; }


    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
