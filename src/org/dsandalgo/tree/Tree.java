package org.dsandalgo.tree;

public interface Tree<T> {
	
	
	void add(T data);
	void remove(T data);
	
	void inOrderTraversal();
	void preOrderTraversal();
	void postOrderTraversal();
	void breadthFirstSearch();
	
	T getMax();
	
	int height();
	
	int numberOfLeaves();
	
	Tree<T> clone();
	

}
