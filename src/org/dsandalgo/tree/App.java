package org.dsandalgo.tree;

public class App {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(10);
		bst.add(7);
		bst.add(8);
		bst.add(12);
		bst.add(6);
		bst.add(11);
		bst.add(14);
		bst.add(15);
		bst.add(17);

//		bst.inOrderTraversal();
//		System.out.println("\n");
//		bst.remove(18);
//		bst.inOrderTraversal();
//		bst.remove(14);
//		bst.remove(12);
//		System.out.println("\n");
//		bst.inOrderTraversal();
//		System.out.println("\n");
//		System.out.println(bst.getMax());
//		System.out.println("\n");
//		bst.breadthFirstSearch();
//		System.out.println(bst.height());
//		System.out.println(bst.numberOfLeaves());

//		bst.breadthFirstSearch();
//		System.out.println("\n");
//		Tree<Integer> clone = bst.clone();
//		clone.remove(10);
//		clone.breadthFirstSearch();

		bst.inOrderTraversal();
		System.out.println("\n");
//		addGreater(bst.getRoot(), 0);
//		bst.inOrderTraversal();

//		100 94 87 79 69 58 46 32 17 

//		94 87 79 69 58 46 32 17 0 

//		Node p = BSTUtils.findLowestCommonAncestor(bst.getRoot(), 6, 8);
//		Node p = lowestCommonAnccestorBST(bst.getRoot(), 6, 8);
//		System.out.println(p.getData());
		
//		int dist = BSTUtils.lowestCommonAnccestorBST(bst.getRoot(), 10, 17);
//		
//		System.out.println(dist);
		
        
	}
}
