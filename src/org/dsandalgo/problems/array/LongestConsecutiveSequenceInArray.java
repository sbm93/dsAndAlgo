package org.dsandalgo.problems.array;

import java.util.HashSet;

public class LongestConsecutiveSequenceInArray {
	public static void main(String[] args) {
//		int arr[] = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };

		int[] arr = { 1, 9, 3, 10, 4, 20, 2 };

		int n = arr.length;
		System.out.println(
				"Length of the Longest consecutive subsequence is " + findLongestConsecutiveSubsequence(arr, n));
	}

	static int findLongestConsecutiveSubsequence(int[] arr, int n) {
		HashSet<Integer> s = new HashSet<Integer>();
		int largest = 0;

		for (int i = 0; i < n; i++)
			s.add(arr[i]);

		for (int i = 0; i < n; i++) {
			if (!s.contains(arr[i] - 1)) {
				int curr = arr[i];
				int count = 1;
				while (s.contains(curr + 1)) {
					count++;
					curr++;
				}
				largest = Math.max(largest, count);
			}
		}
		return largest;
	}
}
