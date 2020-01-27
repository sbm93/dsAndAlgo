package org.dsandalgo.heap;

public class App {
	public static void main(String[] args) {
		Heap heap = new Heap(5);
		heap.add(10);
		heap.add(11);
		heap.add(12);
		heap.add(8);
		heap.add(20);

		print(heap);

		System.out.println(heap.poll());

		print(heap);
	}

	static void print(Heap heap) {
		for (int i : heap.getHead()) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}
}
