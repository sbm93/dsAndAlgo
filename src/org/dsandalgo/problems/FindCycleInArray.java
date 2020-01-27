package org.dsandalgo.problems;

public class FindCycleInArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 3 };
		System.out.println(findCycle(arr));
	}

	static boolean findCycle(int[] arr) {
		int p = 0, q = 0;
		while (true) {
			if (p < 0 || q < 0 || p >= arr.length || q >= arr.length) {
				return false;
			}
			
			if (arr[q] < 0 || arr[q] >= arr.length) {
				return false;
			}

			q = arr[q];

			if (arr[arr[p]] < 0 || arr[arr[p]] >= arr.length)
				return false;

			p = arr[arr[p]];
			if (p == q) {
				return true;
			}
		}
	}
}
