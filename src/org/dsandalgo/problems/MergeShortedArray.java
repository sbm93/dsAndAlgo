package org.dsandalgo.problems;

import java.util.Arrays;

public class MergeShortedArray {
	public static void main(String[] args) {
		int[] x = { 1, 3, 5, 6, 7, 8 };
		int[] y = { 1, 2, 4, 5, 9, 10 };

		int[] res = merge(x, y);

		System.out.println(Arrays.toString(res));
	}

	private static int[] merge(int[] x, int[] y) {
		int[] res = new int[x.length + y.length];
		int p = 0, q = 0;

		for (int i = 0; i < res.length; i++) {
			if (p >= x.length) {
				res[i] = y[q++];
			} else if (q >= y.length) {
				res[i] = x[p++];
			} else if (x[p] < y[q]) {
				res[i] = x[p++];
			} else {
				res[i] = y[q++];
			}
		}

		return res;
	}
}
