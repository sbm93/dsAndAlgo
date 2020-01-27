package org.dsandalgo.tree.problems;

public class DistanceFromK {
	static int printKDistanceNodes(Node root, Node node, int k) {
		if (root == null)
			return -1;

		if (root == node) {
			printKNodeDown(root, k);
			return 0;
		}

		int left = printKDistanceNodes(root.left, node, k);
		if (left != -1) {
			if (left + 1 == k) {
				System.out.println(root.data + " ");
			} else {
				printKNodeDown(root.right, k - left - 2);
			}
			return left + 1;
		}

		int right = printKDistanceNodes(root.right, node, k);
		if (right != -1) {
			if (right + 1 == k) {
				System.out.print(root.data + " ");
			} else {
				printKNodeDown(root.left, k - right - 2);
			}
			return right + 1;
		}

		return -1;

	}

	static void printKNodeDown(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.print(node.data + " ");
		}

		printKNodeDown(node.left, k - 1);
		printKNodeDown(node.right, k - 1);
	}

}
