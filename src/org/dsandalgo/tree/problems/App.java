package org.dsandalgo.tree.problems;


public class App {
	public static void main(String[] args) {
		/*
		 * 								1
		 *	 			2								3
		 * 		9				6				4				5
		 * 			10		11				12		7
		 */					
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(9); 
        root.left.right = new Node(6); 
        root.right.left = new Node(4); 
        root.right.right = new Node(5); 
        root.right.left.left = new Node(12); 
        root.right.left.right = new Node(7); 
        root.left.right.left = new Node(11); 
        root.left.left.right = new Node(10); 
        
//        DiagonalSum.diagonalSum(root); 
//        LeftView.print(root);
//        LeftView.printWithBFS(root);
//        PrintRootToLeafPath.printPath(root);
//        DistanceFromK.printKDistanceNodes(root, root.left.right, 1);
//        PathSumClass.getSum(root);
//        PathSumClass.getPathWithSum(root, 20);
//        PrintKthNodeFromLeaf.print(root, 1);
        
	}
}
class Node {
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
	}
}
