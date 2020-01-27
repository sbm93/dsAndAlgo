package org.dsandalgo.tree.problems;

public class PrintRootToLeafPath {

	static void printPath(Node node) {
		int len = 0;
		int[] path = new int[1000];

		printPathRec(node, len, path);
	}

	static void printPathRec(Node node, int len, int[] path) {
		if (node == null)
			return;

		path[len++] = node.data;

		if (node.left == null && node.right == null) {
			print(path, len);
		} else {
			printPathRec(node.left, len, path);
			printPathRec(node.right, len, path);
		}
	}

	static void print(int[] path, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
}
