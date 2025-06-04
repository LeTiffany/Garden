/*
* Author: Tiffany Le
* Course: CSC 210 - Spring 2025
* File: Garden.java
* Purpose: This class represents a garden of plants organized into a specified number
* of rows and columns. Its methods may be used to plant flowers, trees and vegetables,
* print a visual representation and grow and clear plants in the garden.
*/

package com.gradescope.garden;

public class Garden {

	private int rows;
	private int cols;
	private Plant[][] plants;

	/*
	 * Garden(rows, cols) -- Takes in two integers rows and cols and constructs an
	 * instance of Garden, initializing plants to an empty 2D array.
	 */
	public Garden(int rows, int cols) {
			this.rows = rows;
			this.cols = cols;
			this.plants = new Plant[rows][cols];
	}

	/*
	 * plant(row, col, type) -- Takes in two integers row and col and a String type
	 * and plants a Plant object of type in the specified location.
	 */
	public void plant(int row, int col, String type) {
		String[] flowers = Flower.getTypes();
		for (String flower : flowers) {
			if (type.toLowerCase().equals(flower)) { // checks type is valid for class
				plants[row][col] = new Flower(row, col, type);
				return; // returns early if found
			}
		}
		String[] trees = Tree.getTypes();
		for (String tree : trees) {
			if (type.toLowerCase().equals(tree)) {
				plants[row][col] = new Tree(row, col, type);
				return;
			}
		}
		String[] vegetables = Vegetable.getTypes();
		for (String vegetable : vegetables) {
			if (type.toLowerCase().equals(vegetable)) {
				plants[row][col] = new Vegetable(row, col, type);
				return;
			}
		}
	}

	/*
	 * print() -- Prints a visual representation of the garden.
	 */
	public void print() {
		System.out.println("> PRINT");
		for (Plant[] row : plants) {
			for (int i = 0; i < 5; i++) { // iterates over rows to concatenate plant plots
				String furrow = "";
				for (Plant plant : row) {
					if (plant == null) {
						furrow += (new Screen()).stringAt(i); // concatenates empty row if no plant exists
					} else {
						furrow += plant.stringAt(i);
					}
				}
				System.out.println(furrow);
			}
		}
		System.out.println();
	}

	/*
	 * grow(num) -- Takes in an integer num and grows all plants in the garden num
	 * times.
	 */
	public void grow(int num) {
		System.out.println("> GROW " + String.valueOf(num));
		System.out.println();
		for (Plant[] row : plants) { // nested loop iterates over all plants
			for (Plant plant : row) {
				if (plant != null) {
					plant.grow(num);
				}
			}
		}
	}

	/*
	 * grow(num, row, col) -- Takes in three integers num, row and col and grows the
	 * plant at the specified location num times.
	 */
	public void grow(int num, int row, int col) {
		System.out.println(String.format("> GROW %d (%d,%d)", num, row, col));
		System.out.println();
		if (row >= 0 && row < rows && col >= 0 && col < cols && plants[row][col] != null) {
			plants[row][col].grow(num);
		} else { // can't grow if plant doesn't exist or is outside of the garden.
			System.out.println("Can't grow there.");
			System.out.println();
		}
	}

	/*
	 * grow(num, kind) -- Takes in an integer num and String kind and grows all
	 * plants of the specified kind num times.
	 */
	public void grow(int num, String kind) {
		System.out.println(String.format("> GROW %d %s", num, kind.toLowerCase()));
		System.out.println();
		for (Plant[] row : plants) {
			for (Plant plant : row) {
				if ((plant != null) && // checks that plant exists and is the correct class or type
						((kind.toLowerCase().equals("flower") && plant instanceof Flower)
								|| (kind.toLowerCase().equals("tree") && plant instanceof Tree)
								|| (kind.toLowerCase().equals("vegetable") && plant instanceof Vegetable)
								|| (kind.toLowerCase().equals(plant.getType().toLowerCase())))) {
					plant.grow(num);
				}
			}
		}
	}

	/*
	 * clear(command) -- Takes in a String command and clears all plants in the
	 * garden of the corresponding class.
	 */
	public void clear(String command) {
		System.out.println("> " + command.toUpperCase());
		System.out.println();
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (plants[row][col] != null && // checks that plant exists and is an instance of the correct class
						((command.toLowerCase().equals("harvest") && plants[row][col] instanceof Vegetable)
								|| (command.toLowerCase().equals("pick") && plants[row][col] instanceof Flower)
								|| (command.toLowerCase().equals("cut") && plants[row][col] instanceof Tree))) {
					plants[row][col].clear();
				}
			}
		}
	}

	/*
	 * clear(command, row, col) -- Takes in a String command and two integers row
	 * and col and clears the plant at the specified location.
	 */
	public void clear(String command, int row, int col) {
		System.out.println(String.format("> %s (%d,%d)", command.toUpperCase(), row, col));
		System.out.println();
		if (command.toLowerCase().equals("harvest")) {
			if (plants[row][col] != null && plants[row][col] instanceof Vegetable && row >= 0 && row < rows && col >= 0
					&& col < cols) {
				plants[row][col].clear();
			} else { // can't harvest if plant doesn't exist, isn't a Vegetable or is out of bounds
				System.out.println("Can't harvest there.");
				System.out.println();
			}
		} else if (command.toLowerCase().equals("pick")) {
			if (plants[row][col] != null && plants[row][col] instanceof Flower && row >= 0 && row < rows && col >= 0
					&& col < cols) {
				plants[row][col].clear();
			} else { // can't pick if plant doesn't exist, isn't a Flower or is out of bounds
				System.out.println("Can't pick there.");
				System.out.println();
			}
		} else {
			if (plants[row][col] != null && plants[row][col] instanceof Tree && row >= 0 && row < rows && col >= 0
					&& col < cols) {
				plants[row][col].clear();
			} else { // can't cut if plant doesn't exist, isn't a Tree or is out of bounds
				System.out.println("Can't cut there.");
				System.out.println();
			}
		}
	}

	/*
	 * clear(command, type) -- Takes in two Strings command and type and clears all
	 * plants of the specified type.
	 */
	public void clear(String command, String type) {
		System.out.println(String.format("> %s %s", command.toUpperCase(), type.toLowerCase()));
		System.out.println();
		for (Plant[] row : plants) {
			for (Plant plant : row) {
				if (plant != null && type.toLowerCase().equals(plant.getType())) {
					// checks that plant exists and is the correct type
					plant.clear(type);
				}
			}
		}
	}
}
