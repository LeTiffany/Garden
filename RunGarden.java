/*
* Author: Tiffany Le
* Course: CSC 210 - Spring 2025
* File: RunGarden.java
* Purpose: This program allows a user to run the program from the main method that simulates
* a garden. The simulation reads commands such as PLANT, PRINT, GROW, and HARVEST from a file
* and executes those commands.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RunGarden {

	/*
	 * main(args) -- Reads in a file name provided by the user and reads it with a
	 * Scanner object, initializing a Garden object and processing the commands in
	 * the file.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File commands = new File(args[0]);
		Scanner reader = new Scanner(commands);
		int rows = Integer.valueOf(reader.nextLine().split(": ")[1]);
		int cols = Integer.valueOf(reader.nextLine().split(": ")[1]);
		if (cols > 16) { // garden is never more than 80 characters across
			System.out.println("Too many plot columns.");
		} else {
			Garden garden = new Garden(rows, cols);
			processCommands(reader, garden); // processes commands
		}
		reader.close();
	}

	/*
	 * processCommands(reader, garden) -- Takes in a Scanner reader and a Garden
	 * garden and processes the commands in reader.
	 */
	public static void processCommands(Scanner reader, Garden garden) {
		while (reader.hasNextLine()) { // iterates over lines in reader
			String[] command = reader.nextLine().split(" ");
			if (command[0].toLowerCase().equals("plant")) {
				garden.plant(Character.getNumericValue(command[1].charAt(1)),
						Character.getNumericValue(command[1].charAt(3)), command[2]);
			} else if (command[0].toLowerCase().equals("print")) {
				garden.print();
			} else if (command[0].toLowerCase().equals("grow") && command.length == 2) {
				garden.grow(Integer.valueOf(command[1]));
			} else if (command[0].toLowerCase().equals("grow") && command.length == 3 && command[2].charAt(0) == '(') {
				garden.grow(Integer.valueOf(command[1]), Character.getNumericValue(command[2].charAt(1)),
						Character.getNumericValue(command[2].charAt(3)));
			} else if (command[0].toLowerCase().equals("grow") && command.length == 3 && command[2].charAt(0) != '(') {
				garden.grow(Integer.valueOf(command[1]), command[2]);
			} else if ((command[0].toLowerCase().equals("harvest") || command[0].toLowerCase().equals("pick")
					|| command[0].toLowerCase().equals("cut")) && command.length == 1) {
				garden.clear(command[0]); // clear is the same operation as harvest, pick and cut
			} else if ((command[0].toLowerCase().equals("harvest") || command[0].toLowerCase().equals("pick")
					|| command[0].toLowerCase().equals("cut")) && command.length == 2 && command[1].charAt(0) == '(') {
				garden.clear(command[0], Character.getNumericValue(command[1].charAt(1)),
						Character.getNumericValue(command[1].charAt(3)));
			} else if (command[0].toLowerCase().equals("harvest") || command[0].toLowerCase().equals("pick")
					|| command[0].toLowerCase().equals("cut") && command.length == 2 && command[1].charAt(0) != '(') {
				garden.clear(command[0], command[1]);
			}
		}
	}
}
