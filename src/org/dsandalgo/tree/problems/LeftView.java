package org.dsandalgo.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
	static void print(Node node) {
		int[] max = { 0 };
		printUtil(node, max, 1);
	}

	static void printUtil(Node node, int[] max, int level) {
		if (node == null)
			return;
		if (max[0] < level) {
			System.out.print(node.data + " ");
			max[0] = level;
		}
		printUtil(node.left, max, level + 1);
		printUtil(node.right, max, level + 1);

	}

	static void printWithBFS(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node tmp = queue.peek();
			System.out.print(tmp.data + " ");
			int count = queue.size();
			while(count-- != 0) {
				Node curr = queue.poll();
				if(curr.left != null) {
					queue.add(curr.left);
				}
				if(curr.right != null) {
					queue.add(curr.right);
				}
			}
		}
	}
}
