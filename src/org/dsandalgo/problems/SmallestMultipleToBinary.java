package org.dsandalgo.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SmallestMultipleToBinary {
	public static void main(String[] args) {
		int N = 12;
		System.out.println(getLowestMultiple(N));
	}

	static int isDivisible(String num, int n) {
		int mod = 0;
		for (int i = 0; i < num.length(); i++) {
			mod = (mod * 10 + (num.charAt(i) - '0')) % n;
		}
		return mod;
	}

	static String getLowestMultiple(int A) {
		Queue<String> queue = new LinkedList<String>();
		Set<Integer> set = new HashSet();
		queue.add("1");
		while (!queue.isEmpty()) {
			String num = queue.poll();
			int remainder = Integer.parseInt(num) % A; //isDivisible(num, A);
			if (remainder == 0)
				return num;

			if (!set.contains(remainder)) {
				set.add(remainder);
				String num1 = num + "0";
				String num2 = num + "1";
				if (!set.contains(num1))
					queue.add(num1);
				if (!set.contains(num2))
					queue.add(num2);
			}
		}
		return "";
	}
}
