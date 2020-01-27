package org.dsandalgo.tree;

public class BSTUtils {
	public static int lowestCommonAnccestorBST(Node<Integer> node, int n1, int n2) {
		if (node == null)
			return 0;

		if (node.getData() > n1 && node.getData() > n2) {
			return lowestCommonAnccestorBST(node.getLeftChild(), n1, n2);
		}

		if (node.getData() < n1 && node.getData() < n2) {
			return lowestCommonAnccestorBST(node.getRightChild(), n1, n2);
		}

		if (node.getData() >= n1 && node.getData() <= n2) {
			return distance(node, n1) + distance(node, n2);
		}

		return 0;
	}

	private static int distance(Node<Integer> node, int a) {
		if (node.getData() == a)
			return 0;
		if (node.getData() > a)
			return 1 + distance(node.getLeftChild(), a);
		return 1 + distance(node.getRightChild(), a);
	}

	// Example f binary tree not binary search tree;
	public static Node<Integer> findLowestCommonAncestor(Node<Integer> node, int n1, int n2) {
		if (node == null)
			return null;

		if (node.getData() == n1 || node.getData() == n2)
			return node;

		Node left = findLowestCommonAncestor(node.getLeftChild(), n1, n2);
		Node right = findLowestCommonAncestor(node.getRightChild(), n1, n2);

		if (left != null && right != null)
			return node;

		return left != null ? left : right;

	}

	public static int addGreater(Node<Integer> node, int sum) {
		if (node == null) {
			return sum;
		}

		sum = addGreater(node.getRightChild(), sum);

//		int tmp = sum + node.getData();
		sum = sum + node.getData();
		node.setData(sum);

		sum = addGreater(node.getLeftChild(), sum);
		return sum;
	}
}
