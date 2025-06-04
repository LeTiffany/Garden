/*
* Author: Tiffany Le
* Course: CSC 210 - Spring 2025
* File: Screen.java
* Purpose: This class represents the visual display of a plant. Its methods may be used to
* place a plant in the display and get the string representation at a specified row.
*/

public class Screen {

	private char[][] cells;
	
	/*
	 * Screen() -- Constructs an instance of Screen, initializing cells to a 5x5 2D array
	 * of periods.
	 */
	public Screen() {
		this.cells = new char[][] { { '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.' }, };
	}
	
	/*
	 * place() -- Places a Plant object in the display.
	 */
	public void place(Plant plant) {
		cells = new char[][] { { '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.' }, }; // resets cells
		if (plant instanceof Flower) { // flowers bloom
			for (int row = 0; row < 5; row++) {
				for (int col = 0; col < 5; col++) {
					if (Math.abs(row - 2) + Math.abs(col - 2) <= plant.getSize()) {// sum of coordinates must be less than size
						cells[row][col] = plant.getType().charAt(0);
					}
				}
			}
		} else if (plant instanceof Tree) { // trees grow up
			for (int row = 4; row >= (4 - plant.getSize()); row--) {
				cells[row][2] = plant.getType().charAt(0);
			}
		} else { // vegetables grow down
			for (int row = 0; row <= plant.getSize(); row++) {
				cells[row][2] = plant.getType().charAt(0);
			}
		}
	}
	
	/*
	 * place() -- Takes in an integer row and returns the string representation at the row.
	 */
	public String stringAt(int row) {
		String furrow = "";
		for (char cell : cells[row]) { // concatenates characters in row
			furrow += cell;
		}
		return furrow;
	}
}
