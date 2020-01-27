package org.dsandalgo.backtracking;

import java.util.ArrayList;

public class AllPossibleSubsets {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		print(arr, new ArrayList<Integer>(), 0);
	}

	static void print(int[] arr, ArrayList<Integer> subset, int index) {
		System.out.println(subset);
		for (int i = index; i < arr.length; i++) {
			subset.add(arr[i]);
			print(arr, subset, i+1);
			subset.remove(subset.size() - 1);
		}
	}
}
