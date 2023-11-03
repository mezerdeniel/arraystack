/*
 * Project and Training 2 - HS23, Computer Science, Berner Fachhochschule
 */

// You are not allowed to change this file.

package ch.bfh.stack;

/**
 * A trivial example which shows how a ch.bfh.stack can be used.
 */

public class StackUseExample {

	/**
	 * @param args (ignored)
	 */
	public static void main(String[] args) {

		// create a ch.bfh.stack of Strings
		Stack<String> stack = new ArrayBasedStack<>();

		// push a new element onto the ch.bfh.stack
		stack.push("something");

		// push a second element onto the ch.bfh.stack
		stack.push("something else");

		// print the size of the ch.bfh.stack
		System.out.println("ch.bfh.stack size = " + stack.size());

		// print the top element of the ch.bfh.stack (without changing the ch.bfh.stack)
		System.out.println("top element = " + stack.top());

		// print and remove the top element of the ch.bfh.stack
		System.out.println("pop the element = " + stack.pop());

		// print and remove the top element of the ch.bfh.stack
		System.out.println("top element is now = " + stack.top());

		// print the size of the ch.bfh.stack
		System.out.println("ch.bfh.stack size = " + stack.size());

		// print if ch.bfh.stack is empty
		System.out.println("ch.bfh.stack is empty = " + stack.isEmpty());
	}

}
