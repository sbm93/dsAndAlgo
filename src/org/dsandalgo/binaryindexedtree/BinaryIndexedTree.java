package org.dsandalgo.binaryindexedtree;

public class BinaryIndexedTree {
	final static int MAX = 1000;
	static int[] BITree = new int[MAX];

	static void constructBITree(int arr[], int n) {
		for (int i = 1; i <= n; i++)
			BITree[i] = 0;

		for (int i = 0; i < n; i++)
			updateBIT(n, i, arr[i]);
	}

	static void updateBIT(int n, int index, int val) {
		index = index + 1;
		while (index <= n) {
			BITree[index] += val;
			index += index & (-index);
		}
	}

	static int getSum(int index) {
		int sum = 0;
		index = index + 1;

		while (index > 0) {
			sum += BITree[index];
			index -= index & (-index);
		}

		return sum;
	}

}
