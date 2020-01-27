package org.dsandalgo.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapToSortAnArray {
	public static void main(String[] args) {
		int[] a = { 1, 0, 4, 3, 2 };
//		System.out.println(minSwaps(a));
		System.out.println(countSwap(a));
	}

	static int countSwap(int[] arr) {
		int n = arr.length;
		boolean[] visited = new boolean[n];
		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] || i == arr[i])
				continue;
			int c = 0;
			int val = arr[i];
			while (!visited[val]) {
				visited[val] = true;
				val = arr[val];
				c += 1;
			}
			counter += c - 1;
		}

		return counter;
	}

	static int minSwaps(int[] arr) {
		int n = arr.length;
		boolean[] visited = new boolean[n];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			map.put(i, arr[i]);
		}

		int countSwap = 0;
		for (int k = 0; k < n; k++) {
			if (visited[k] || k == map.get(k))
				continue;
			int val = map.get(k);
			int c = 0;
			while (!visited[val]) {
				visited[val] = true;
				val = map.get(val);
				++c;
			}

			countSwap += c - 1;
		}

		return countSwap;
	}
}
