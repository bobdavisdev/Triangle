package com.project.triangle;

import com.project.triangle.constants.TriangleTypes;
import com.project.triangle.exception.InvalidInputException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ApplicationTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ApplicationTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ApplicationTest.class);
	}

	/**
	 * Valid test cases
	 */
	public void testEquilateralTriangleType() {
		try {
			assertTrue(Triangle.getType(10, 10, 10).equals(
					TriangleTypes.EQUILATERAL));
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}

	public void testIsoscelesTriangleType() {
		try {
			assertTrue(Triangle.getType(10, 10, 20).equals(
					TriangleTypes.ISOSCELES));
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}

	public void testScaleneTriangleType() {
		try {
			assertTrue(Triangle.getType(10, 20, 30).equals(
					TriangleTypes.SCALENE));
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Negative test cases
	 */
	
	public void testNotScaleneTriangleType() {
		try {
			assertFalse(Triangle.getType(10, 10, 20).equals(
					TriangleTypes.SCALENE));
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void testNotIsoscelesTriangleType() {
		try {
			assertFalse(Triangle.getType(10, 10, 10).equals(
					TriangleTypes.ISOSCELES));
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void testNotEquilateralTriangleType() {
		try {
			assertFalse(Triangle.getType(10, 20, 30).equals(
					TriangleTypes.EQUILATERAL));
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		}
	}
	
}
