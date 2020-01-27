package org.dsandalgo.problems;

import java.util.Iterator;
import java.util.Stack;

public class NQueensProblem {
	public static void main(String[] args) {
		Stack<P> stack = findSolution(5, 0);
		System.out.println(stack);
	}

	private static Stack<P> findSolution(int n, int col) {
		Stack<P> stack = new Stack<P>();
		queenUtil(n, col, stack);
		return stack;
	}

	private static boolean queenUtil(int n, int col, Stack<P> stack) {
		if (col >= n)
			return true;

		for (int i = 0; i < n; i++) {
			if (isSafe(stack, new P(i, col))) {
				stack.push(new P(i, col));
				if (queenUtil(n, col + 1, stack)) {
					return true;
				}
				stack.pop();
			}
		}
		return false;
	}

	private static boolean isSafe(Stack<P> stack, P p) {
		Iterator<P> itr = stack.iterator();
		while (itr.hasNext()) {
			P peek = itr.next();
			if (peek.x == p.x)
				return false;
			if (Math.abs(peek.x - p.x) == Math.abs(peek.y - p.y))
				return false;
		}

		return true;
	}

}

class P {
	int x, y;

	P(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "P [x=" + x + ", y=" + y + "]";
	}

}
