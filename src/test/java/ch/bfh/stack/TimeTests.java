/*
 * Project and Training 2 - HS23, Computer Science, Berner Fachhochschule
 */

// You are not allowed to change this file.

package ch.bfh.stack;

import org.junit.jupiter.api.Test;

//CHECKSTYLE:OFF MagicNumber
class TimeTests {
	private final int num = 10000;

	@Test
	void testSize() {
		long[] result = new long[num];
		Stack<Integer> stack = new ArrayBasedStack<>();
		for (int i = 0; i < num; i++) {
			stack.push(i);
			long start = System.currentTimeMillis();
			stack.size();
			long stop = System.currentTimeMillis();
			result[i] = stop - start;
		}

		if (!methodHasConstantTimeBehaviour(result, 5, num, "sizeTime:")) {
			throw new RuntimeException("Method size is too slow, not O(1)!");
		}
	}

	@Test
	void testPushTime() {
		long[] result = new long[num];
		Stack<Integer> stack = new ArrayBasedStack<>();
		for (int i = 0; i < num; i++) {
			long start = System.currentTimeMillis();
			stack.push(i);
			long stop = System.currentTimeMillis();
			result[i] = stop - start;
		}

		if (!methodHasConstantTimeBehaviour(result, 5, num, "pushTime:")) {
			throw new RuntimeException("Method push is too slow, not O(1)!");
		}
	}

	@Test
	void tesTopTime() {
		long[] result = new long[num];
		Stack<Integer> stack = new ArrayBasedStack<>();
		for (int i = 0; i < num; i++) {
			stack.push(i);
			long start = System.currentTimeMillis();
			stack.top();
			long stop = System.currentTimeMillis();
			result[i] = stop - start;
		}

		if (!methodHasConstantTimeBehaviour(result, 5, num, "topTime:")) {
			throw new RuntimeException("Method top is too slow, not O(1)!");
		}
	}

	@Test
	void testPopTime() {
		long[] result = new long[num];
		Stack<Integer> stack = new ArrayBasedStack<>();
		for (int i = 0; i < num + 10; i++) {
			stack.push(i);
		}
		for (int i = 0; i < num; i++) {
			long start = System.currentTimeMillis();
			stack.pop();
			long stop = System.currentTimeMillis();
			result[i] = stop - start;
		}
		if (!methodHasConstantTimeBehaviour(result, 5, num, "PopTime:")) {
			throw new RuntimeException("Method pop is too slow, not O(1)!");
		}
	}



	// helper methods

	private final double constantFunctionMaxLinearTerm = 0.1; // Maximum absolute factor for linear term in a regression of a
														// constant function

	private boolean methodHasConstantTimeBehaviour(long[] arr, int start, int end, String headerString) {
		DoublePair p = computeRegression(arr, start, end);
		// System.out.println(headerString + " param1=" + p.param1 + " param2=" + p.param2);
		return Math.abs(p.param1) <= constantFunctionMaxLinearTerm;
		// this is true if the measurements suggest that the method has a constant time
		// behaviour
	}

	private record DoublePair(double param1, double param2){}

	private DoublePair computeRegression(long[] arr, int start, int end) {
		// Computes a linear regression using the given data points
		if (start < 0 || end < 0 || start >= arr.length || end > arr.length || end <= start) {
			throw new RuntimeException(
					"arguments inconsistent start=" + start + " end=" + end + " arr.size=" + arr.length);
		}
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}
		double meanY = ((double) sum) / ((double) (end - start));
		double meanX = 0.5 * start + 0.5 * (end - 1);
		double sumxy = 0.0;
		double sumxx = 0.0;
		for (int i = start; i < end; i++) {
			sumxy += (i - meanX) * (arr[i] - meanY);
			sumxx += (i - meanX) * (i - meanX);
		}
		double param1 = sumxy / sumxx;
		double param2 = meanY - param1 * meanX;
		return new DoublePair(param1, param2);

	}

}
