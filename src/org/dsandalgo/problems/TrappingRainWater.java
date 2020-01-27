package org.dsandalgo.problems;

/*
 * Trapping Rain Water Given n non-negative integers representing 
 * an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;
		System.out.println(fillWater(arr, n));
	}

	static int fillWater(int[] arr, int n) {

		int result = 0;
		int left_max = 0, right_max = 0;
		int lo = 0, hi = n - 1;

		while (lo < hi) {
			if (arr[lo] < arr[hi]) {
				if (arr[lo] > left_max) {
					left_max = arr[lo];
				} else {
					result += left_max - arr[lo];
				}
				lo++;
			} else {
				if (arr[hi] > right_max) {
					right_max = arr[hi];
				} else {
					result += right_max - arr[hi];
				}

				hi--;
			}
		}

		return result;
	}
}
