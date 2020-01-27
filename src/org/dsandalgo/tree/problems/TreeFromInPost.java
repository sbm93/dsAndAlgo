package org.dsandalgo.tree.problems;

/*
 * Generate the tree with inorder and postorder lists
 */
public class TreeFromInPost {
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		int n = in.length;
		Node root = buildTree(in, post, n);
		
		preOrder(root);

	}
	
	static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.data + " " );
		preOrder(node.left);
		preOrder(node.right);
	}

	static Node buildTree(int[] in, int[] post, int n) {
		int[] i = { n - 1 };
		return builtTreeUtil(in, post, 0, n - 1, i);
	}

	private static Node builtTreeUtil(int[] in, int[] post, int start, int end, int[] index) {

		if (start > end)
			return null;

		Node node = new Node(post[index[0]]);
		index[0] = index[0] - 1;

		if (start == end)
			return node;

		/*
		 * find the index of this node in Inorder traversal
		 */
		int inIndex = search(in, start, end, node.data);
		
		node.right = builtTreeUtil(in, post, inIndex + 1, end, index);
		node.left = builtTreeUtil(in, post, start, inIndex - 1, index);
		
		return node;
	}

	static int search(int[] in, int start, int end, int data) {
		int i;
		for (i = start; i <= end; i++) {
			if (in[i] == data)
				break;
		}

		return i;
	}
}
