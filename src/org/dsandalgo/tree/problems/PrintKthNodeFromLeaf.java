package org.dsandalgo.tree.problems;

public class PrintKthNodeFromLeaf {
	public static void print(Node node, int k) {
		int[] level = new int[1];
		level[0] = -1;
		printKthNode(node, k, level);
	}

	public static void printKthNode(Node node, int k, int[] level) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			level[0] = k;
		}
		boolean fl = false;
		printKthNode(node.left, k, level);
		if (level[0] == 0) {
			System.out.print(node.data + " ");
			fl = true;
		}
		printKthNode(node.right, k, level);
		if (level[0] == 0 && !fl) {
			System.out.print(node.data + " ");
		}
		level[0] -= 1;
	}
}
