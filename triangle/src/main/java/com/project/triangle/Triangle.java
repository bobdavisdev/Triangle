package com.project.triangle;

import com.project.triangle.constants.TriangleTypes;
import com.project.triangle.exception.InvalidInputException;

/**
 * 
 * @author babureddy Triangle class is responsible to handle all the logic to
 *         check the triangle type and validate triangle side input. Triangle
 *         class is abstract so that different triangle class can extend this
 *         class to do any custom logic or functionality, this class holds logic
 *         for all common or shared functionality of triangle
 */
public abstract class Triangle {

	/**
	 * 
	 * @param sideAtoB
	 * @param sideBtoC
	 * @param sideCtoA
	 * @return true if all three sides are equal
	 */
	private static boolean checkSidesEquilateral(int sideAtoB, int sideBtoC,
			int sideCtoA) {
		return sideAtoB == sideBtoC && sideBtoC == sideCtoA;
	}

	/**
	 * 
	 * @param sideAtoB
	 * @param sideBtoC
	 * @param sideCtoA
	 * @return true if any two sides are equal
	 */
	private static boolean checkSidesIsosceles(int sideAtoB, int sideBtoC,
			int sideCtoA) {
		return sideAtoB == sideBtoC || sideBtoC == sideCtoA
				|| sideCtoA == sideAtoB;
	}

	/**
	 * 
	 * @param sideAtoB
	 * @param sideBtoC
	 * @param sideCtoA
	 * @return true if triangle sides are invalid case 1) returns true if any
	 *         side is less than or equal to zero case 2) returns true if sum of
	 *         any two sides is less than third side.
	 */
	private static boolean checkInvalidTriangleSide(int sideAtoB, int sideBtoC,
			int sideCtoA) {
		return sideAtoB < 0 || sideBtoC <= 0 || sideCtoA <= 0
				|| (sideAtoB + sideBtoC < sideCtoA)
				|| (sideBtoC + sideCtoA < sideAtoB)
				|| (sideCtoA + sideAtoB < sideBtoC);
	}

	/**
	 * 
	 * @param sideAtoB
	 * @param sideBtoC
	 * @param sideCtoA
	 * @return {@link TriangleTypes} for the provided sides
	 * @throws InvalidInputException
	 *             in case the sides provided are not valid or side does not
	 *             comply valid triangle side
	 */
	public static TriangleTypes getType(int sideAtoB, int sideBtoC, int sideCtoA)
			throws InvalidInputException {
		if (!checkInvalidTriangleSide(sideAtoB, sideBtoC, sideCtoA)) {
			if (checkSidesEquilateral(sideAtoB, sideBtoC, sideCtoA))
				return TriangleTypes.EQUILATERAL;
			else if (checkSidesIsosceles(sideAtoB, sideBtoC, sideCtoA))
				return TriangleTypes.ISOSCELES;
			else
				return TriangleTypes.SCALENE;

		} else {
			throw new InvalidInputException(
					"Provided sides "
							+ sideAtoB
							+ ","
							+ sideBtoC
							+ ","
							+ sideCtoA
							+ " Cannot be less than or equal to zero or Provided sides does not form a valid triangle.");
		}
	}
}
