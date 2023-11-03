/*
 * Project and Training 2 - HS23, Computer Science, Berner Fachhochschule
 */

// You are not allowed to change this file.

package ch.bfh.exceptions;

/**
 * Exception class for handling empty stacks.
 */
@SuppressWarnings("serial")
public class StackEmptyException extends RuntimeException {
	/**
	 * Parameterless Constructor
	 */
	public StackEmptyException() {
	}


	/**
	 * Constructor that accepts a message
	 * @param message the exception message
	 */
	public StackEmptyException(String message) {
		super(message);
	}
}
