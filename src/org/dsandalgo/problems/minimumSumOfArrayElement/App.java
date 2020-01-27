package org.dsandalgo.problems.minimumSumOfArrayElement;

import java.util.LinkedList;
import java.util.List;

public class App {
	public static void main(String[] args) {

		/*
		 * Note to self: if we are looking for subset Sorting an array wont give me the
		 * required ans.
		 */
		int arr[] = { 3, 4, 4, 9 };
		int n = arr.length;
//		System.out.println("The mini mum difference between 2 sets is " 
//				+ MinimumSumOfArrayElementUtil.findMin(arr, n));

//		System.out.println(
//				"The minimum difference between 2 sets is " 
//		+ MinimumSumOfArrayElementUtil.findMinRecursiveWay(arr, n));
		int sum = 12;
//		System.out.println(isSubsetSum(arr, n, sum));
//		
		System.out.println();
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println(isSubsetSum(arr, n, sum, list));
	}

	static boolean isSubsetSum(int set[], int n, int sum, LinkedList<Integer> list) {
		if (sum == 0) {
			System.out.println(list);
			return true;
		}
		if (sum < 0)
			return false;
		if (n == 0 && sum != 0)
			return false;
		
		boolean without = isSubsetSum(set, n - 1, sum, list);
		list.add(set[n-1]);
		boolean with = isSubsetSum(set, n - 1, sum - set[n-1], list);
		list.remove(list.size()-1);
		return with || without;
	}

	static boolean custom(int arr[], int n, int sum) {
		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
				}
			}
		}

		MinimumSumOfArrayElementUtil.print(dp);

		int j = sum;
		int i = n;
		List<Integer> ls = new LinkedList<Integer>();
		while (j > 0 && i > 0) {
			while (i > 0 && dp[i - 1][j] == true)
				i--;
			ls.add(arr[i - 1]);
			j -= arr[i - 1];

		}
		System.out.println(ls);

		return dp[n][sum];
	}

	static boolean isSubsetSumDP(int set[], int n, int sum) {
		boolean subset[][] = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}
		MinimumSumOfArrayElementUtil.print(subset);
		return subset[sum][n];
	}

}
