/*
 * Project and Training 2 - HS23, Computer Science, Berner Fachhochschule
 */

// You are not allowed to change this file.

package ch.bfh.stack;

import ch.bfh.basics.BasicCollection;
import ch.bfh.exceptions.StackEmptyException;

/**
 * An interface for a Stack.
 * @param <E> The type of the elements in the stack
 */
public interface Stack<E> extends BasicCollection<E> {
	/**
	 * @return the top element of the stack (the stack is not changed)
	 * @throws StackEmptyException if the stack is empty
	 */
	E top() throws StackEmptyException;

	/**
	 * Adds a new element to the top of the stack.
	 * @param element the element to be added
	 */
	void push(E element);

	/**
	 * Removes the top element from the stack and removes it.
	 * @return the top element of the stack.
	 * @throws StackEmptyException if the stack is empty
	*/
	E pop() throws StackEmptyException;

}
