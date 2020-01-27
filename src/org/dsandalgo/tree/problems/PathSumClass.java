package org.dsandalgo.tree.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PathSumClass {
	public static void getSum(Node root) {
		ArrayList<Integer> subset = new ArrayList<Integer>();

		getAllPathSum(root, subset, 0);

		System.out.println(subset);
	}

	private static void getAllPathSum(Node node, ArrayList<Integer> subset, int sum) {
		if (node == null) {
			return;
		}
		sum += node.data;
		if (node.left == null && node.right == null) {
			subset.add(sum);
		} else {
			getAllPathSum(node.left, subset, sum);
			getAllPathSum(node.right, subset, sum);
		}
	}

	public static void getPathWithSum(Node root, int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subset = new ArrayList<Integer>();

		getPathWithSum(root, results, subset, sum);

		for (ArrayList<Integer> k : results) {
			System.out.println(k);
		}
	}

	private static void getPathWithSum(Node node, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> subset,
			int sum) {
		if (node == null) {
			return;
		}

		subset.add(node.data);
		sum -= node.data;

		if (node.left == null && node.right == null && sum == 0) {
			results.add(new ArrayList<Integer>(subset));
		} else {
			getPathWithSum(node.left, results, subset, sum);
			getPathWithSum(node.right, results, subset, sum);
		}
		subset.remove(subset.size() - 1);
	}
}
