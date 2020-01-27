package org.dsandalgo.problems.smallestdiffpairin2array;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int a[] = { 1, 2, 14, 6 };
		int b[] = { 4, 12, 19, 23, 127, 235 };
		findPair(a, b, a.length, b.length);

	}

	static void findPair(int[] arr1, int[] arr2, int m, int n) {
		int a = 0, b = 0;
		int result = Integer.MAX_VALUE;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		while (a < m && b < n) {
			if( Math.abs(arr1[a] - arr2[b]) < result) {
				result = Math.abs(arr1[a] - arr2[b]);
			}
			
			if(arr1[a] < arr2[b]) {
				a++;
			} else {
				b++;
			}
		}
		System.out.println("result: " + result);
	}
}
