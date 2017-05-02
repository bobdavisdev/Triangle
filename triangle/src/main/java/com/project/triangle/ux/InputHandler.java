package com.project.triangle.ux;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.triangle.Triangle;
import com.project.triangle.constants.TriangleTypes;
import com.project.triangle.exception.InvalidInputException;

/**
 * 
 * @author babureddy CLass Handles User Input via console
 */

public class InputHandler {

	private static InputHandler self = null;
	private Scanner readInput = null;

	/**
	 * Private constructor to make sure initialization happens only through the
	 * self class.
	 */
	private InputHandler() {
		super();
	}

	private void displayWelcomeText() {
		System.out.println("\nHello Welcome, How are you today.");
		System.out.println("I Can help you to find type of triangle you have.");
		System.out
				.println("What you have to do is just enter the length of the sides of triangle.");
	}

	private void displayReadSideAtoBText() {
		System.out
				.println("Enter the length of triangle from point A --> B : ");
	}

	private void displayReadSideBtoCText() {
		System.out
				.println("Enter the length of triangle from point B --> C : ");
	}

	private void displayReadSideCtoAText() {
		System.out
				.println("Enter the length of triangle from point C --> A : ");
	}

	private void displayuserConfirmationDialogText() {
		System.out
				.println("Do you Wish to continue ? \n 1 >> Enter 'y' to check another triangle type.\n 2 >> Enter 'n' to exit.");
	}

	private boolean handleUserConfirmation() throws InvalidInputException {
		displayuserConfirmationDialogText();
		String continueConfirmation = readStringInput();
		if (continueConfirmation.equalsIgnoreCase("n")) {
			displayByeByeText();
			return false;
		} else if (!continueConfirmation.equalsIgnoreCase("y")) {
			System.out.println("Invalid Input Please try again");
			handleUserConfirmation();
		}

		return true;
	}

	private void displayByeByeText() {
		System.out
				.println("Thanks !! for using this program to check triangle type, Bye Bye & See you again.");
	}

	/**
	 * Initialize input handler to read sides of triangle from user system input
	 * or console.
	 */
	public void initializeInputHandler() {
		displayWelcomeText();
		for (;;) {
			try {
				displayReadSideAtoBText();
				int sideAtoBLength = readIntegerInput();
				System.out.println("You entered side length from A --> B : "
						+ sideAtoBLength);
				displayReadSideBtoCText();
				int sideBtoCLength = readIntegerInput();
				System.out.println("You entered side length from B --> C : "
						+ sideBtoCLength);
				displayReadSideCtoAText();
				int sideCtoALength = readIntegerInput();
				System.out.println("You entered side length from C --> A : "
						+ sideCtoALength);
				TriangleTypes triangleType = Triangle.getType(sideAtoBLength,
						sideBtoCLength, sideCtoALength);
				System.out.println("Based on the  entered triangle sides "
						+ sideAtoBLength + "," + sideBtoCLength + ","
						+ sideCtoALength + ", its " + triangleType
						+ "triangle");
				if (handleUserConfirmation()) {
					continue;
				} else {
					break;
				}
			} catch (InvalidInputException e) {
				System.err.println("\n" + e.getMessage());
			}
		}
		System.exit(0);
	}

	/**
	 * 
	 * @return int input value entered by the user via system input.
	 * @throws InvalidInputException
	 *             in case the input of the user is not integer.
	 */
	private int readIntegerInput() throws InvalidInputException {
		int input = 0;
		try {
			readInput = new Scanner(System.in);
			input = readInput.nextInt(); // Scans the next token of the input as
											// an int.
		} catch (InputMismatchException e) {
			throw new InvalidInputException(
					" Input Can only be integer values, Please enter the value for side again : ");
		} catch (Exception e) {
			System.out.println();
		}
		return input;
	}

	/**
	 * 
	 * @return String input value entered by the user via input
	 * @throws InvalidInputException
	 */

	private String readStringInput() throws InvalidInputException {
		String input = "";
		try {
			readInput = new Scanner(System.in);
			input = readInput.nextLine(); // Scans the next token of the input
											// as an int.
		} catch (InputMismatchException e) {
			throw new InvalidInputException(
					" Input Can only be integer values, Please enter the value for side again : ");
		} catch (Exception e) {
			System.err.println("" + e.getMessage());
		}
		return input;
	}

	/**
	 * function to ensure only one object is created for the Input Handler
	 * Class.
	 * 
	 * @return InputHandler
	 */
	public synchronized static InputHandler getInstance() {
		if (self == null) {
			self = new InputHandler();
		}
		return self;
	}

}
