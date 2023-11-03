/*
 * Project and Training 2 - HS23, Computer Science, Berner Fachhochschule
 */

// You are not allowed to change this file.

package ch.bfh.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.bfh.exceptions.StackEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//CHECKSTYLE:OFF MagicNumber
class ArrayBasedStackTest {

	@Test
	void testEmptyStackSize() {
		Stack<String> stack = new ArrayBasedStack<>();
		assertEquals(0, stack.size());
	}

	@Test
	void testEmptyStack() {
		Stack<String> stack = new ArrayBasedStack<>();
		assertTrue(stack.isEmpty());
	}


	@Test
	void testOneElementIsEmptyAfterInsert() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element = "1";
		stack.push(element);
		assertFalse(stack.isEmpty());
	}

	@Test
	void testOneElementSizeAfterInsert() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element = "1";
		stack.push(element);
		assertEquals(1, stack.size());
	}

	@Test
	void testOneElementTopAfterInsert() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element = "1";
		stack.push(element);
		assertEquals(element, stack.top());
	}

	@Test
	void testOneElementPopAfterInsert() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element = "1";
		stack.push(element);
		assertEquals(element, stack.pop());
	}

	@Test
	void testOneElementSizeAfterPushAndPop() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element = "1";
		stack.push(element);
		stack.pop();
		assertAll(
				() -> assertEquals(0, stack.size()),
				() -> assertTrue(stack.isEmpty()));
	}

	@Test
	void testOneElementSizeAfterPushAndPopAndPush() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element = "1";
		stack.push(element);
		stack.pop();
		stack.push(element);
		assertAll(
				() -> assertEquals(1, stack.size()),
				() -> assertFalse(stack.isEmpty()),
				() -> assertEquals(element, stack.top()),
				() -> assertEquals(element, stack.pop()));
	}

	@Test
	void testTwoElementsSizeAfterTwoPush() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		assertAll(
				() -> assertEquals(2, stack.size()),
				() -> assertFalse(stack.isEmpty()));
	}

	@Test
	void testTwoElementsTopAfterTwoPush() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		assertEquals(element2, stack.top());
	}

	@Test
	void testTwoElementsSizeAfterTop() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		stack.top();
		assertAll(
				() -> assertEquals(2, stack.size()),
				() -> assertFalse(stack.isEmpty()));
	}

	@Test
	void testTwoElementsPopAfterTwoPush() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		assertEquals(element2, stack.pop());
	}

	@Test
	void testTwoElementsSizeAfterPop() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		stack.pop();
		assertAll(
				() -> assertEquals(1, stack.size()),
				() -> assertFalse(stack.isEmpty()));
	}

	@Test
	void testTwoElementsTopAfterPop() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		stack.pop();
		assertEquals(element1, stack.top());
	}


	@Test
	void testTwoElementsSizeAfterPopAndTop() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		stack.pop();
		stack.top();
		assertAll(
				() -> assertEquals(1, stack.size()),
				() -> assertFalse(stack.isEmpty()));
	}

	@Test
	void testTwoElementsPopAndPop() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		stack.pop();
		assertEquals(element1, stack.pop());
	}

	@Test
	void testTwoElementsSizeAfterTwoPop() {
		Stack<String> stack = new ArrayBasedStack<>();
		String element1 = "1";
		String element2 = "2";
		stack.push(element1);
		stack.push(element2);
		stack.pop();
		stack.pop();
		assertAll(
				() -> assertEquals(0, stack.size()),
				() -> assertTrue(stack.isEmpty()));
	}


	@Test
	void testSeveralElementsSizeAfterInsert() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int size = 10000;
		for (int element = 1; element <= size; element++) {
			stack.push(element);
		}
		assertAll(
				() -> assertEquals(size, stack.size()),
				() -> assertFalse(stack.isEmpty()));
	}

	@Test
	void testSeveralElementsPopAndTopAll() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int size = 10000;
		for (int element = 1; element <= size; element++) {
			stack.push(element);
		}
		for (int element = size; element > 0; element--) {
			assertEquals(element, stack.top());
			assertEquals(element, stack.pop());
		}
	}

	@Test
	void testSeveralElementsInsertAndRemoveAll() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int size = 10000;
		for (int element = 1; element <= size; element++) {
			stack.push(element);
		}
		for (int element = size; element > 0; element--) {
			stack.pop();
		}
		assertAll(
				() -> assertEquals(0, stack.size()),
				() -> assertTrue(stack.isEmpty()));
	}


	@Test
	void testExceptionTop() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::top);
	}

	@Test
	void testExceptionPop() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::pop);
	}


	@Test
	void testStackOfStacks1() {
		Stack<Stack<Integer>> stack = new ArrayBasedStack<>();
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		int i = 0;
		stack1.push(i++);
		stack1.push(i++);
		stack.push(stack1);
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack2.push(i++);
		stack2.push(i++);
		stack.push(stack2);
		Stack<Integer> stack3 = new ArrayBasedStack<>();
		stack3.push(i++);
		stack3.push(i);
		stack.push(stack3);
		assertEquals(3, stack.size());
	}

	@Test
	void testStackOfStacks2() {
		Stack<Stack<Integer>> stack = new ArrayBasedStack<>();
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		int i = 0;
		stack1.push(i++);
		stack1.push(i++);
		stack.push(stack1);
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack2.push(i++);
		stack2.push(i++);
		stack.push(stack2);
		Stack<Integer> stack3 = new ArrayBasedStack<>();
		stack3.push(i++);
		stack3.push(i);
		stack.push(stack3);
		while (!stack.isEmpty()) {
			Stack<Integer> innerStack = stack.pop();
			while (!innerStack.isEmpty()) {
				assertEquals(i, innerStack.pop());
				i--;
			}
		}
	}

	@Test
	void testStackOfStacks3() {
		Stack<Stack<Integer>> stack = new ArrayBasedStack<>();
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		int i = 0;
		stack1.push(i++);
		stack1.push(i++);
		stack.push(stack1);
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack2.push(i++);
		stack2.push(i++);
		stack.push(stack2);
		Stack<Integer> stack3 = new ArrayBasedStack<>();
		stack3.push(i++);
		stack3.push(i);
		stack.push(stack3);

		while (!stack.isEmpty()) {
			Stack<Integer> innerStack = stack.pop();
			while (!innerStack.isEmpty()) {
				innerStack.pop();
			}
			assertTrue(innerStack.isEmpty());
		}
	}

	@Test
	void testStackOfStacks4() {
		Stack<Stack<Integer>> stack = new ArrayBasedStack<>();
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		int i = 0;
		stack1.push(i++);
		stack1.push(i++);
		stack.push(stack1);
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack2.push(i++);
		stack2.push(i++);
		stack.push(stack2);
		Stack<Integer> stack3 = new ArrayBasedStack<>();
		stack3.push(i++);
		stack3.push(i);
		stack.push(stack3);

		while (!stack.isEmpty()) {
			Stack<Integer> innerStack = stack.pop();
			while (!innerStack.isEmpty()) {
				innerStack.pop();
			}
		}
		assertTrue(stack.isEmpty());
	}



	@Test
	void testRandomElements() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int num = 100;
		List<Integer> list = new ArrayList<>(num);
		Random random = new Random(10);
		for (int i = 0; i < num; i++) {
			int element = random.nextInt(1000);
			list.add(0, element);
			stack.push(element);
		}
		assertEquals(num, stack.size());
		for (int element : list) {
			assertEquals(element, stack.pop());
		}
		assertTrue(stack.isEmpty());
	}


	@Test
	void testThreeStacks() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		Stack<Integer> stack3 = new ArrayBasedStack<>();
		int num = 1000;
		Random random = new Random(20);
		for (int i = 0; i < num; i++) {
			int element = random.nextInt(1000);
			stack1.push(element);
			stack2.push(element);
		}
		assertEquals(num, stack1.size());
		assertEquals(num, stack2.size());
		assertEquals(0, stack3.size());
		while (!stack2.isEmpty()) {
			stack3.push(stack2.pop());
		}
		assertEquals(num, stack1.size());
		assertEquals(0, stack2.size());
		assertEquals(num, stack3.size());
		while (!stack3.isEmpty()) {
			stack2.push(stack3.pop());
		}
		assertEquals(num, stack1.size());
		assertEquals(num, stack2.size());
		assertEquals(0, stack3.size());
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			assertEquals(stack1.pop(), stack2.pop());		}
		assertTrue(stack1.isEmpty());
		assertTrue(stack2.isEmpty());
		assertTrue(stack3.isEmpty());
	}

	@Test
	void continueAfterExceptions() {
		Stack<String> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::top);
		assertThrows(StackEmptyException.class, stack::pop);
		String e = "some string";
		stack.push(e);
		assertEquals(e, stack.top());
		assertEquals(e, stack.pop());
		assertThrows(StackEmptyException.class, stack::top);
		assertThrows(StackEmptyException.class, stack::pop);
		assertTrue(stack.isEmpty());
	}


	@Test
	void stackWithNulls1() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "some string";
		stack.push(null);
		stack.push(e);
		stack.push(null);
		assertNull(stack.top());
	}

	@Test
	void stackWithNulls2() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "some string";
		stack.push(null);
		stack.push(e);
		stack.push(null);
		assertNull(stack.pop());
	}

	@Test
	void stackWithNulls3() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "some string";
		stack.push(null);
		stack.push(e);
		stack.push(null);
		stack.pop();
		assertEquals(e, stack.top());
	}

	@Test
	void stackWithNulls4() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "some string";
		stack.push(null);
		stack.push(e);
		stack.push(null);
		stack.pop();
		assertEquals(e, stack.pop());
	}

	@Test
	void stackWithNulls5() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "some string";
		stack.push(null);
		stack.push(e);
		stack.push(null);
		stack.pop();
		stack.pop();
		assertNull(stack.top());
	}

	@Test
	void stackWithNulls6() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "some string";
		stack.push(null);
		stack.push(e);
		stack.push(null);
		stack.pop();
		stack.pop();
		assertNull(stack.pop());
	}


	@Test
	void stackWithNulls7() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "some string";
		stack.push(null);
		stack.push(e);
		stack.push(null);
		stack.pop();
		stack.pop();
		stack.pop();
		assertAll(
				() -> assertEquals(0, stack.size()),
				() -> assertTrue(stack.isEmpty()));
	}



	@Test
	void testHashCodeWithEmptyStack() {
		Stack<String> stack = new ArrayBasedStack<>();
		assertEquals(stack.hashCode(), stack.hashCode(),
				"two calls to hashCode must give the same result");
	}

	@Test
	void testHashCodeWithNonEmptyStack() {
		Stack<String> stack = new ArrayBasedStack<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		assertEquals(stack.hashCode(), stack.hashCode(),
				"two calls to hashCode must give the same result");
	}

	@Test
	void testHashCodeWithEmptyStacks1() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		assertEquals(stack1.hashCode(), stack2.hashCode(),
				"empty stacks are equal, hence they must have the same hashCode");
	}

	@Test
	void testHashCodeWithEmptyStacks2() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		stack1.push("test");
		stack1.pop();
		assertEquals(stack1.hashCode(), stack2.hashCode(),
				"empty stacks are equal, hence they must have the same hashCode");
	}



	@Test
	void testHashcodeOnStacksWith1Element() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		String element = "test";
		stack1.push(element);
		stack2.push(element);
		assertEquals(stack1.hashCode(), stack2.hashCode());
	}

	@Test
	void testHashcodeOnStacksWith1Element1() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		String element = "test";
		stack1.push(element);
		assertNotEquals(stack1.hashCode(), stack2.hashCode());
	}

	@Test
	void testHashcodeOnStacksWith1Element2() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		String element = "test";
		stack2.push(element);
		assertNotEquals(stack1.hashCode(), stack2.hashCode());
	}

	@Test
	void testHashCodeOnStacksWith1000Elements() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		for (int i = 0; i < 1000; i++) {
			stack1.push(i);
		}
		while (! stack1.isEmpty()) {
			stack1.pop();
		}
		assertEquals(stack1.hashCode(), stack2.hashCode());
	}



	@Test
	void testHashCodeMethodWithNull() {
		Stack<String> stack = new ArrayBasedStack<>();
		stack.push("1");
		stack.push("2");
		stack.push(null);
		stack.push("4");
		stack.push("5");
		assertDoesNotThrow(stack::hashCode, "hashCode on a stack with null elements does not throw an exception");
	}

	@Test
	void testEqualsWithNull() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		String e = "some string";
		stack1.push(null);
		stack2.push(null);
		stack1.push(e);
		stack2.push(e);
		stack1.push(null);
		stack2.push(null);
		assertEquals(stack2, stack1);
	}

	@Test
	void testEqualsWithNull2() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		String e = "some string";
		stack1.push(null);
		stack2.push(null);
		stack1.push(e);
		stack2.push(null);
		assertNotEquals(stack2, stack1);
	}

	@Test
	void testEqualsWithNull3() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		String e = "some string";
		stack1.push(null);
		stack2.push(null);
		stack1.push(null);
		stack2.push(e);
		assertNotEquals(stack2, stack1);
	}

	@Test
	void testEqualsWithNull4() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		stack1.push(null);
		assertNotEquals(stack2, stack1);
	}

	@Test
	void testEqualsWithNullValue() {
		Stack<String> stack = new ArrayBasedStack<>();
		stack.push("123");
		assertNotEquals(stack, null);
	}

	@Test
	void testHashCodeWithNull() {
		Stack<String> stack1 = new ArrayBasedStack<>();
		Stack<String> stack2 = new ArrayBasedStack<>();
		String e = "some string";
		stack1.push(null);
		stack2.push(null);
		stack1.push(e);
		stack2.push(e);
		stack1.push(null);
		stack2.push(null);
		assertEquals(stack1.hashCode(), stack2.hashCode());
	}


	@Test
	void testPushPopPush() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e1 = "e1";
		String e2 = "e2";
		String e3 = "e3";
		stack.push(e1);
		stack.push(e2);
		stack.push(e3);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(e1);
		stack.push(e2);
		stack.push(e3);
		assertEquals(3, stack.size());
		assertEquals(e3, stack.pop());
		assertEquals(e2, stack.pop());
		assertEquals(e1, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContinuePopAfterTopException() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::top);
		int element = 1;
		stack.push(element);
		assertEquals(1, stack.size());
		assertEquals(element, stack.top());
		assertEquals(element, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContinuePopAfterPopException() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::pop);
		int element = 1;
		stack.push(element);
		assertEquals(1, stack.size());
		assertEquals(element, stack.top());
		assertEquals(element, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContinueTopAfterTopException() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::top);
		int element = 1;
		stack.push(element);
		assertEquals(1, stack.size());
		assertEquals(element, stack.top());
		assertEquals(element, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContinueTopAfterPopException() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::pop);
		int element = 1;
		stack.push(element);
		assertEquals(1, stack.size());
		assertEquals(element, stack.top());
		assertEquals(element, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContinueSizeAfterTopException() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::top);
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContinueSizeAfterPopException() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertThrows(StackEmptyException.class, stack::pop);
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testEqualsAfterPushPop() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack2.push(1);
		stack1.push(2);
		stack1.pop();
		assertEquals(stack1, stack2);
	}

	@Test
	void testEqualsAfterPushPop2() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack2.push(1);
		stack1.push(2);
		stack1.pop();
		stack2.push(3);
		stack2.pop();
		assertEquals(stack1, stack2);
	}


	@Test
	void testEqualsOfEmptyStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertEquals(stack, stack, "a stack is equal to itself");
	}

	@Test
	void testEqualsOfNonEmptyStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		assertEquals(stack, stack, "a stack is equal to itself");
	}

	@Test
	void testEqualsOfEmptyStacks1() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		assertEquals(stack1, stack2, "both stacks are empty, so they are equal");
	}

	@Test
	void testEqualsOfEmptyStacks2() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(10);
		stack1.pop();
		assertEquals(stack1, stack2, "both stacks are empty, so they are equal");
	}

	@Test
	void testHashAfterPushPop() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack2.push(1);
		stack1.push(2);
		stack1.pop();
		assertEquals(stack1.hashCode(), stack2.hashCode(), "both stacks contain only the element 1, so they are equal");
	}

	@Test
	void testHashAfterPushPop2() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack2.push(1);
		stack1.push(2);
		stack1.pop();
		stack2.push(3);
		stack2.pop();
		assertEquals(stack1.hashCode(), stack2.hashCode(), "both stacks contain only the element 1, so they are equal");
	}


	@Test
	void testEqualsOfDifferentOrderOfElements() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack2.push(2);
		stack1.push(2);
		stack2.push(1);
		assertNotEquals(stack1, stack2, "The stacks must not be equals as the order of the elements differs");
	}

	@Test
	void testNotEqualsTwoStacks1() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		assertNotEquals(stack1, stack2);
	}

	@Test
	void testNotEqualsTwoStacks2() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack2.push(1);
		assertNotEquals(stack1, stack2);
	}


	@Test
	void testEqualsOfClassWith0Hash() {
		class NullHash {
			@Override
			public int hashCode() {
				return 0;
			}

			@Override
			public boolean equals(Object obj) {
				return false;
			}
		}
		Stack<NullHash> stack1 = new ArrayBasedStack<>();
		Stack<NullHash> stack2 = new ArrayBasedStack<>();
		stack1.push(new NullHash());
		stack2.push(new NullHash());
		assertNotEquals(stack1, stack2, "The stacks must not be equals as the elements contained are not equal");
	}

	@Test
	void testClearOnEmptyStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.clear();
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	void testClearOnNonEmptyStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(2);
		stack.clear();
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	void testPushAfterClear() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(2);
		stack.clear();
		stack.push(3);
		stack.push(4);
		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
	}

	@Test
	void testEqualsAfterClear() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack1.push(2);
		stack1.clear();
		assertEquals(stack1, stack2);
	}

	@Test
	void testHashCodeAfterClear() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack1.push(2);
		stack1.clear();
		assertEquals(stack1.hashCode(), stack2.hashCode());
	}

	@Test
	void testContainsWithEmptyStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertFalse(stack.contains(0));
	}

	@Test
	void testContains() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		Integer e = 1;
		stack.push(e);
		assertTrue(stack.contains(e));
	}

	@Test
	void testContains2() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		Integer e = 1;
		stack.push(0);
		stack.push(e);
		assertTrue(stack.contains(e));
	}

	@Test
	void testContains3() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(0);
		assertFalse(stack.contains(1));
	}

	@Test
	void testContains4() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(0);
		stack.push(1);
		assertFalse(stack.contains(2));
	}

	@Test
	void testContains5() {
		Stack<String> stack = new ArrayBasedStack<>();
		String e = "something";
		stack.push(e);
		assertTrue(stack.contains(e));
		assertFalse(stack.contains("other"));
	}

	@Test
	void testContainsWithEquals() {
		class Tmp {
			@Override
			public boolean equals(Object obj) {
				return true;
			}
		}
		Stack<Tmp> stack = new ArrayBasedStack<>();
		Tmp t1 = new Tmp();
		Tmp t2 = new Tmp();
		stack.push(t1);
		assertTrue(stack.contains(t2), "equals must be used for equality testing (not object reference)");
	}

	@Test
	void testContainsWithEquals2() {
		class Tmp {
			@Override
			public boolean equals(Object obj) {
				return false;
			}
		}
		Stack<Tmp> stack = new ArrayBasedStack<>();
		Tmp t = new Tmp();
		stack.push(t);
		assertFalse(stack.contains(t), "equals must be used for equality testing (not object reference)");
	}


	@Test
	void testEqualsWithEquals() {
		class Tmp {
			@Override
			public boolean equals(Object obj) {
				return true;
			}
		}
		Stack<Tmp> stack1 = new ArrayBasedStack<>();
		Stack<Tmp> stack2 = new ArrayBasedStack<>();
		stack1.push(new Tmp());
		stack2.push(new Tmp());
		assertEquals(stack1, stack2, "equals of stack must use equals method of elements for equality testing (not object reference)");
	}


	@Test
	void testEqualsWithEquals2() {
		class Tmp {
			@Override
			public boolean equals(Object obj) {
				return false;
			}
		}
		Stack<Tmp> stack1 = new ArrayBasedStack<>();
		Stack<Tmp> stack2 = new ArrayBasedStack<>();
		Tmp t = new Tmp();
		stack1.push(t);
		stack2.push(t);
		assertNotEquals(stack1, stack2, "equals of stack must use equals method of elements for equality testing (not object reference)");
	}

	@Test
	void testEqualsDoesNotChangeStack() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack2.push(1);
		stack1.push(2);
		stack2.push(2);
		assertEquals(stack1, stack2);
		assertEquals(2, stack1.size());
		assertEquals(2, stack2.size());
	}

	@Test
	void testEqualsDoesNotChangeStack2() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack1.push(2);
		assertNotEquals(stack1, stack2);
		assertEquals(2, stack1.size());
		assertEquals(0, stack2.size());
	}

	@Test
	void testEqualsDoesNotChangeStack3() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		int first = 1;
		int second = 2;
		stack1.push(first);
		stack2.push(first);
		stack1.push(second);
		stack2.push(second);
		assertEquals(stack1, stack2);
		assertEquals(second, stack1.pop());
		assertEquals(first, stack1.pop());
		assertEquals(second, stack2.pop());
		assertEquals(first, stack2.pop());
	}

	@Test
	void testEqualsDoesNotChangeStack4() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		int first = 1;
		int second = 2;
		stack1.push(first);
		stack1.push(second);
		assertNotEquals(stack1, stack2);
		assertEquals(second, stack1.pop());
		assertEquals(first, stack1.pop());
		assertTrue(stack2.isEmpty());
	}


	@Test
	void testHashDoesNotChangeStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int first = 1;
		int second = 2;
		stack.push(first);
		stack.push(second);
		stack.hashCode();
		assertEquals(second, stack.pop());
		assertEquals(first, stack.pop());
	}

	@Test
	void testPushPopDoesNotChangeHash() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int first = 1;
		int second = 2;
		stack.push(first);
		int hash = stack.hashCode();
		stack.push(second);
		stack.pop();
		assertEquals(hash, stack.hashCode());
	}

	@Test
	void testContainsDoesNotChangeStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int first = 1;
		int second = 2;
		stack.push(first);
		stack.push(second);
		assertTrue(stack.contains(first));
		assertEquals(second, stack.pop());
		assertEquals(first, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContainsDoesNotChangeStack2() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int first = 1;
		int second = 2;
		stack.push(first);
		stack.push(second);
		assertTrue(stack.contains(second));
		assertEquals(second, stack.pop());
		assertEquals(first, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testContainsDoesNotChangeStack3() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		int first = 1;
		int second = 2;
		stack.push(first);
		stack.push(second);
		assertFalse(stack.contains(3));
		assertEquals(second, stack.pop());
		assertEquals(first, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testTwoTimesSize() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.size());
		assertEquals(2, stack.size(), "size does not change the state of the stack");
	}

	@Test
	void testTwoTimesContains() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(2);
		assertTrue(stack.contains(1));
		assertTrue(stack.contains(1), "contains does not change the state of the stack");
	}

	@Test
	void testTwoTimesEqualsTrue() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack1.push(2);
		stack2.push(1);
		stack2.push(2);
		assertEquals(stack1, stack2);
		assertEquals(stack1, stack2);
		assertEquals(2, stack1.size(), "equals does not change the state of the stack");
	}

	@Test
	void testTwoTimesEqualsFalse() {
		Stack<Integer> stack1 = new ArrayBasedStack<>();
		Stack<Integer> stack2 = new ArrayBasedStack<>();
		stack1.push(1);
		stack1.push(2);
		stack2.push(1);
		assertNotEquals(stack1, stack2);
		assertNotEquals(stack1, stack2);
		assertEquals(2, stack1.size(), "equals does not change the state of the stack");
	}

	@Test
	void testTwoTimesHashCode() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(2);
		int hash1 = stack.hashCode();
		int hash2 = stack.hashCode();
		assertEquals(hash1, hash2, "hashcode gives the same result if the stack has not changed");
		assertEquals(2, stack.size());
	}

	@Test
	void testTwoTimesHashCode2() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(2);
		int hash1 = stack.hashCode();
		stack.push(3);
		stack.pop();
		int hash2 = stack.hashCode();
		assertEquals(hash1, hash2, "hashcode gives the same result if the stack has not changed");
		assertEquals(2, stack.size());
	}

	@Test
	void testContainsWithNull() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(null);
		stack.push(2);
		assertTrue(stack.contains(null));
	}

	@Test
	void testContainsWithNull2() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		assertFalse(stack.contains(null));
	}

	@Test
	void testContainsWithNull3() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(1);
		stack.push(null);
		assertTrue(stack.contains(1));
	}

	@Test
	void testContainsWithNull4() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		stack.push(null);
		assertFalse(stack.contains(1));
	}

	@Test
	void testContainsNullWithEmptyStack() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertFalse(stack.contains(null));
	}


	@Test
	void testEqualsToNull() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		assertNotEquals(stack, null);
	}

	@Test
	void testEqualsWithOtherClass() {
		Stack<Integer> stack = new ArrayBasedStack<>();
		Object other = new Object();
		assertNotEquals(stack, other);
	}

}
