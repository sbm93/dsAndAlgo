package org.dsandalgo.problems.minimumSumOfArrayElement;

import java.util.Arrays;

public class MinimumSumOfArrayElementUtil {
	static int findMinRecursiveWay(int[] arr, int n) {
		int sumTotal = 0;
		for (int i = 0; i < n; i++)
			sumTotal += arr[i];

		return findMinRecursiveWayUtil(arr, n, 0, sumTotal);
	}

	static int findMinRecursiveWayUtil(int[] arr, int i, int calculated, int total) {
		if (i == 0)
			return Math.abs((total - calculated) - calculated);
		int dec = findMinRecursiveWayUtil(arr, i - 1, calculated + arr[i - 1], total);
		int sam = findMinRecursiveWayUtil(arr, i - 1, calculated, total);
		return Math.min(dec, sam);

	}

	static int findMin(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		boolean dp[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (arr[i - 1] <= j) {
					dp[i][j] |= dp[i][j] || dp[i - 1][j - arr[i - 1]];
				}
			}
		}

		print(dp);

		int diff = Integer.MAX_VALUE;
		for (int j = (int) Math.ceil((double )sum / 2); j >= 0; j--) {
			if (dp[n][j] == true) {
				diff = sum - 2 * j;
				break;
			}
		}

		return Math.abs(diff);
	}

	static void print(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
