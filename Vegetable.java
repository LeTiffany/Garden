/*
* Author: Tiffany Le
* Course: CSC 210 - Spring 2025
* File: Vegetable.java
* Purpose: This class represents a vegetable in a garden at a specified row and column with
* a size and type. It inherits its fields and methods from the Plant superclass and includes
* a method to get the types specific to the class.
*/

package com.gradescope.garden;

public class Vegetable extends Plant {

	public static final String[] types = { "garlic", "zucchini", "tomato", "yam", "lettuce" };

	/*
	 * Vegetable(row, col, type) -- Takes in two integers row and col and a String
	 * type and constructs an instance of Vegetable calling the constructor of the
	 * superclass.
	 */
	public Vegetable(int row, int col, String type) {
		super(row, col, type);
	}

	/*
	 * getTypes() -- Returns the types of vegetables.
	 */
	public static String[] getTypes() {
		return types;
	}
}
