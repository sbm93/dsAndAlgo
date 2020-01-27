package org.dsandalgo.heap;

public class Heap {
	private int[] head;
	private int size;
	private int capacity;

	Heap(int capacity) {
		head = new int[capacity];
		this.size = 0;
		this.capacity = capacity;
	}

	public int[] getHead() {
		return head;
	}

	public void add(int data) {
		if (isFull()) {
			throw new RuntimeException("Heap is full...");
		}
		head[this.size++] = data;
		fixUp(this.size - 1);
	}

	private void fixUp(int index) {
		int parentIndex = (index - 1) / 2;

		if (index > 0 && head[parentIndex] < head[index]) {
			int tmp = head[index];
			head[index] = head[parentIndex];
			head[parentIndex] = tmp;
			fixUp(parentIndex);
		}

	}

	public int getMax() {
		return head[0];
	}

	private void fixDown(int index) {
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		int largestIndex = index;

		if (leftIndex < capacity && head[leftIndex] > head[index]) {
			largestIndex = leftIndex;
		}

		if (rightIndex < capacity && head[rightIndex] > head[largestIndex]) {
			largestIndex = rightIndex;
		}

		if (largestIndex != index) {
			int tmp = head[index];
			head[index] = head[largestIndex];
			head[largestIndex] = tmp;
			fixDown(largestIndex);
		}

	}

	public int poll() {
		int max = getMax();

		head[0] = head[--size];
		head[size] = 0;

		fixDown(0);

		return max;
	}

	private boolean isFull() {
		return this.size == head.length;
	}

}
