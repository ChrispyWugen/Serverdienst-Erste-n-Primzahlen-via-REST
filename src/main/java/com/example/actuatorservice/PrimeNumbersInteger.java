package com.example.actuatorservice;

/**
 * An implementation of PrimeNumbersInteger
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
public class PrimeNumbersInteger {

	/* ---------------------------------------- Main ---------------------------------------------------------------- */

	/* ---------------------------------------- Attributes ---------------------------------------------------------- */

	private int[] primeNumberList; //holds all calculated prime numbers

	/* ---------------------------------------- Constants ----------------------------------------------------------- */

	/* ---------------------------------------- Constructors -------------------------------------------------------- */


	PrimeNumbersInteger(int length) {
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
