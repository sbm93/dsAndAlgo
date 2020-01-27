package org.dsandalgo.binaryindexedtree;

public class App {
	public static void main(String[] args) {
		int freq[] = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = freq.length;

		// Build fenwick tree from given array
		BinaryIndexedTree.constructBITree(freq, n);

		System.out.println("Sum of elements in arr[0..5]" + " is " + BinaryIndexedTree.getSum(5));

		freq[3] += 6;

		BinaryIndexedTree.updateBIT(n, 3, 6);

		System.out.println("Sum of elements in arr[0..5]" + " after update is " + BinaryIndexedTree.getSum(5));

	}
}
