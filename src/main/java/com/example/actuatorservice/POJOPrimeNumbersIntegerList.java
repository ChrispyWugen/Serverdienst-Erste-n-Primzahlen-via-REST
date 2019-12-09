package com.example.actuatorservice;

/**
 * An implementation of POJOPrimeNumbersIntegerList
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
public class POJOPrimeNumbersIntegerList {

	/* ---------------------------------------- Main ---------------------------------------------------------------- */

	/* ---------------------------------------- Attributes ---------------------------------------------------------- */

	private int[] primeNumberList; //holds all calculated prime numbers

	/* ---------------------------------------- Constants ----------------------------------------------------------- */

	/* ---------------------------------------- Constructors -------------------------------------------------------- */


	POJOPrimeNumbersIntegerList(int length) {
		primeNumberList = new int[length];

	}
	/* ---------------------------------------- Methods ------------------------------------------------------------- */


	/* ---------------------------------------- S/Getters ----------------------------------------------------------- */
	public int[] getPrimeNumberList() {
		return primeNumberList;
	}

	void setPrimeNumberList(int[] list) { this.primeNumberList = list; }


	/* ---------------------------------------- toString ----------------------------------------------------------- */

}
