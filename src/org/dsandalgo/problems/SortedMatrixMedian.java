package org.dsandalgo.problems;

import java.util.Arrays;

/*
 * 10 30 60
 * 20 60 90
 * 30 60 90
 * In sorted: 10 20 30 30 60 60 60 90 90 
 */
public class SortedMatrixMedian {
	public static void main(String[] args) {
		int r = 3, c = 3;
		int m[][] = { { 10, 30, 60 }, { 20, 60, 90 }, { 30, 60, 90 } };

		System.out.println("Median is " + binaryMedian(m, r, c));
	}

	private static int binaryMedian(int[][] m, int r, int c) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < r; i++) {
			if (m[i][0] < min) {
				min = m[i][0];
			}

			if (m[i][c - 1] > max) {
				max = m[i][c - 1];
			}
		}
		// Desired Position
		int desired = (r * c + 1) / 2;

		while (min < max) {
			int mid = min + (max - min) / 2;
			int place = 0;
			int get = 0;

			for (int i = 0; i < r; i++) {
				/*
				 * if element is not found in binary search it gives us the Negative (-)
				 * insertion point
				 */

				get = Arrays.binarySearch(m[i], mid);
				if (get < 0) {
					get = Math.abs(get) - 1;
				} else {
					while (get < m[i].length && m[i][get] == mid) {
						get += 1;
					}
				}

				place = place + get;
			}
			if (place < desired)
				min = mid + 1;
			else
				max = mid;
		}

		return min;
	}
}
