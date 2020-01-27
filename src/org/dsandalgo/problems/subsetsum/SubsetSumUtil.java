package org.dsandalgo.problems.subsetsum;

import java.util.Arrays;

public class SubsetSumUtil {
	/*
	 * We can use recursion but it gives us exponetial time complexity which is -
	 * O(2^n) this soluation is not suggested to be used
	 */
	static boolean isSubsetSum(int[] arr, int n, int sum) {
		if (n == 0 && sum != 0)
			return false;
		if (sum == 0)
			return true;

		/*
		 * If last element is greater then sum ignore it
		 */

		if (arr[n - 1] > sum)
			return isSubsetSum(arr, n - 1, sum);
		/*
		 * Check if sum can be obtained 1. include the last element 2. exclude the last
		 * element
		 */

		return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);

	}

	/*
	 * To make an efficient algorithm, we can use Dynamix programming which will
	 * give us the solution in O(N*M) times
	 */
	static boolean findSubsetSum(int[] arr, int n, int sum) {
		boolean subset[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			subset[i][0] = true;
		}
		/*
		 * although boolean array already has the value false in the elements we can
		 * skip below for loop
		 */
		for (int i = 0; i <= sum; i++) {
			subset[0][i] = false;
		}

		/*
		 * fill the subset table
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				subset[i][j] = subset[i - 1][j];
				if (arr[i - 1] <= j) {
					subset[i][j] = subset[i][j] || subset[i - 1][j - arr[i - 1]];
				}
			}
		}

		for (int i = 0; i < subset.length; i++) {
			System.out.println(Arrays.toString(subset[i]));
		}
		return subset[n][sum];
	}
}
