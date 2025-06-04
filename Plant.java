/*
* Author: Tiffany Le
* Course: CSC 210 - Spring 2025
* File: Plant.java
* Purpose: This class represents a plant in a garden at a specified row and column with
* a size and type. Its methods may be used to get the type, size and row string representation
* of a plant, clear a plot and grow a plant.
*/

public class Plant {

	protected int row;
	protected int col;
	protected String type;
	protected int size;
	public static final int MAX_SIZE = 4;

	/*
	 * Plant(row, col, type) -- Takes in two integers row and col and a String type
	 * and constructs an instance of Plant, initializing the size to zero.
	 */
	public Plant(int row, int col, String type) {
		this.row = row;
		this.col = col;
		this.type = type.toLowerCase(); // type is made lower case
		this.size = 0;
	}

	/*
	 * getType() -- Returns the type of the plant.
	 */
	public String getType() {
		return type;
	}

	/*
	 * getSize() -- Returns the size of the plant.
	 */
	public int getSize() {
		return size;
	}

	/*
	 * clear() -- Clears the plot, setting size to -1.
	 */
	public void clear() {
		size = -1;
	}

	/*
	 * clear(type) -- Takes in a String type and clears the plot if it is valid,
	 * setting size to -1.
	 */
	public void clear(String type) {
		String[] types;
		if (this instanceof Flower) { // possible types must be from correct class
			types = Flower.getTypes();
		} else if (this instanceof Tree) {
			types = Tree.getTypes();
		} else {
			types = Vegetable.getTypes();
		}
		for (String plantType : types) {
			if (type.toLowerCase().equals(plantType)) { // checks that type is valid
				size = -1;
				break;
			}
		}
	}

	/*
	 * grow(num) -- Takes in an integer num and grows the plant num times.
	 */
	public void grow(int num) {
		if (size > -1 && num + size <= MAX_SIZE) { // can't grow cleared plant
			size += num;
		} else if (num + size > MAX_SIZE) {
			size = MAX_SIZE;
		}
	}

	/*
	 * stringAt(row) -- Takes in an integer row and returns the string
	 * representation of the plant at the row.
	 */
	public String stringAt(int row) {
		Screen display = new Screen();
		display.place(this); // places plant in display
		return display.stringAt(row);
	}
}
