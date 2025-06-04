/*
* Author: Tiffany Le
* Course: CSC 210 - Spring 2025
* File: Flower.java
* Purpose: This class represents a flower in a garden at a specified row and column with
* a size and type. It inherits its fields and methods from the Plant superclass and includes
* a method to get the types specific to the class.
*/

public class Flower extends Plant {
	
	public static final String[] types = {"iris", "lily", "rose", "daisy", "tulip", "sunflower"};
	
	/*
	 * Flower(row, col, type) -- Takes in two integers row and col and a String type
	 * and constructs an instance of Flower calling the constructor of the
	 * superclass.
	 */
	public Flower(int row, int col, String type) {
		super(row, col, type);
	}
	
	/*
	 * getTypes() -- Returns the types of flowers.
	 */
	public static String[] getTypes() {
		return types;
	}
}
