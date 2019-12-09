package com.example.actuatorservice;

/**
 * An implementation of POJOPrimeNumbersObject
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-08
 */
public class POJOPrimeNumbersObject {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */

    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private int[] primeNumberList; //holds all calculated prime numbers
    private String primeNumbersString = "";

    /* ---------------------------------------- Constants ----------------------------------------------------------- */

    /* ---------------------------------------- Constructors -------------------------------------------------------- */


    POJOPrimeNumbersObject(int[] primeNumberList, String primeNumberString) {
        this.primeNumberList = primeNumberList;
        this.primeNumbersString = primeNumberString;
    }
    /* ---------------------------------------- Methods ------------------------------------------------------------- */


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */
    public int[] getPrimeNumberList() {
        return this.primeNumberList;
    }

    public String getPrimeNumbersString() { return this.primeNumbersString; }

    void setPrimeNumberList(int[] list) { this.primeNumberList = list; }


    /* ---------------------------------------- toString ----------------------------------------------------------- */

}
