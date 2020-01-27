package org.dsandalgo.problems.subsetsum;

import java.util.Vector;

public class App {
	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
//		int set[] = { 1, 2, 1, 1, 1 };
		int sum = 9;
		int n = set.length;
		/*
		 * We can use recursion but it gives us exponetial time complexity which is -
		 * O(2^n) this soluation is not suggested to be used
		 */
//        System.out.println(SubsetSumUtil.isSubsetSum(set, n, sum)); 

		/*
		 * DP solution
		 */
//		System.out.println(SubsetSumUtil.findSubsetSum(set, n, sum));

		/*
		 * Helpful to print all the available subsets
		 */
		Vector<Integer> v = new Vector<Integer>();
		printAllSubsetsRec(set, n, v, sum);

	}

	static void printAllSubsetsRec(int arr[], int n, Vector<Integer> v, int sum) {

		if (sum == 0) {
			for (int i = 0; i < v.size(); i++)
				System.out.print(v.get(i) + " ");
			System.out.println();
			return;
		}

		if (n == 0)
			return;

		printAllSubsetsRec(arr, n - 1, v, sum);
		Vector<Integer> v1 = new Vector<Integer>(v);
		v1.add(arr[n - 1]);
		printAllSubsetsRec(arr, n - 1, v1, sum - arr[n - 1]);
	}

}
