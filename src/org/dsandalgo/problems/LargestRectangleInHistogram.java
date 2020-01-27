package org.dsandalgo.problems;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4, 5, 3, 3, 2 };
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(largestArea(arr));
	}

	private static int largestArea(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0, i = 0;
		while (i < arr.length) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i);
				i++;
			} else {
				int elm = stack.pop();
				int area = arr[elm] * (stack.empty() ? i : i - stack.peek() - 1);
				if (max < area) {
					max = area;
				}
			}
		}

		while (!stack.isEmpty()) {
			int elm = stack.pop();
			int area = arr[elm] * (stack.empty() ? i : i - stack.peek() - 1);
			if (max < area) {
				max = area;
			}
		}

		return max;

	}
}
