package org.dsandalgo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void add(T data) {
		if (root == null) {
			root = new Node<T>(data);
		} else {
			add(root, data);
		}
	}
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	private void add(Node<T> node, T data) {
		if (data.compareTo(node.getData()) < 0) {
			if (node.getLeftChild() == null)
				node.setLeftChild(new Node<T>(data));
			else
				add(node.getLeftChild(), data);
		} else {
			if (node.getRightChild() == null)
				node.setRightChild(new Node<T>(data));
			else
				add(node.getRightChild(), data);
		}
	}

	@Override
	public void remove(T data) {
		if (root != null)
			remove(root, data);
	}

	private Node<T> remove(Node<T> node, T data) {
		if (node == null)
			return node;

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(remove(node.getLeftChild(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(remove(node.getRightChild(), data));
		} else {
			if (node.getLeftChild() == null && node.getRightChild() == null)
				return null;
			if (node.getLeftChild() == null)
				return node.getRightChild();
			if (node.getRightChild() == null)
				return node.getLeftChild();
			Node<T> maxNode = getMax(node.getLeftChild());
			remove(node, maxNode.getData());
			node.setData(maxNode.getData());
		}

		return node;

	}

	private Node<T> getMax(Node<T> node) {
		if (node.getRightChild() == null)
			return node;
		return getMax(node.getRightChild());
	}

	@Override
	public T getMax() {
		return getMax(root).getData();
	}

	@Override
	public void inOrderTraversal() {
		inorder(root);
	}

	private void inorder(Node<T> node) {
		if (node == null)
			return;
		inorder(node.getLeftChild());
		System.out.print(node.getData() + " ");
		inorder(node.getRightChild());
	}

	@Override
	public void preOrderTraversal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postOrderTraversal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void breadthFirstSearch() {
		if (root != null)
			breadthFirstSearch(root);
	}

	private void breadthFirstSearch(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node<T> tmp = queue.poll();

			System.out.print(tmp.getData() + " ");
			if (tmp.getLeftChild() != null)
				queue.add(tmp.getLeftChild());
			if (tmp.getRightChild() != null)
				queue.add(tmp.getRightChild());
		}
	}
	
	@Override
	public int height() {
		return height(root);
	}
	
	private int height(Node<T> node) {
		if(node == null)
			return 0;
		int left = height(node.getLeftChild());
		int right = height(node.getRightChild());
		
		return 1 + (left > right ? left : right);
	}
	
	@Override
	public int numberOfLeaves() {
		return numberOfLeaves(root);
	}
	
	private int numberOfLeaves(Node<T> node) {
		if(node == null)
			return 0;
		return numberOfLeaves(node.getLeftChild()) + numberOfLeaves(node.getRightChild()) + 1;
	}
	
	@Override
	public Tree<T> clone() {
		BinarySearchTree<T> clone = new BinarySearchTree<T>();
		clone.root = clone(root);
		return clone;
	}
	
	private Node<T> clone(Node<T> node) {
		if(node == null)
			return null;
		Node<T> tmp = new Node<T>(node.getData());
		tmp.setLeftChild(clone(node.getLeftChild()));
		tmp.setRightChild(clone(node.getRightChild()));
		return tmp;
	}
	
}
