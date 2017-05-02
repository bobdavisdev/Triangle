package com.project.triangle.exception;


/**
 * 
 * @author babureddy
 * Custom Exception class for invalid input.
 * 
 */
public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    public InvalidInputException() {
    	super();
    }

    public InvalidInputException(String message)
    {
       super(message);
    }
	

}
