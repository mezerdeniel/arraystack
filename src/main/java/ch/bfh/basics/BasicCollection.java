/*
 * Project and Training 2 - HS23, Computer Science, Berner Fachhochschule
 */

// You are not allowed to change this file.

package ch.bfh.basics;
/**
 * A interface for a collection which stores elements of
 * type E. The value null is allowed as an element.
 * @param <E> The type of the elements
 */
public interface BasicCollection<E> {

	/**
	 * @return the number of elements in this collection
	 */
	int size();

	/**
	 * @return true if and only if there are no elements in this collection
	 */
	default boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * This method removes all elements from the collection.
	 */
	void clear();

	/**
	 * Test if an element is contained in the stack. This methode must not change the stack.
	 * @param e an element
	 * @return true if and only if the element is contained in this collection.
	 */
	boolean contains(E e);
}
