package org.dsandalgo.tree.problems;

import java.util.HashMap;

public class DiagonalSum {
	static void diagonalSum(Node node) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		diagonalSumUtil(node, map, 0);
		System.out.println(map);
	}

	static void diagonalSumUtil(Node node, HashMap<Integer, Integer> map, int level) {
		if (node == null)
			return;
		while (node != null) {
			if (node.left != null) {
				diagonalSumUtil(node.left, map, level + 1);
			}
			int sum = map.get(level) != null ? map.get(level) + node.data : node.data;
			map.put(level, sum);
			node = node.right;
		}
	}

}
