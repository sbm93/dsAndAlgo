package org.dsandalgo.problems.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArray {
	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };

		kSort(arr, 3);
		
		System.out.println(Arrays.toString(arr));

	}

	static void kSort(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int i;
		for (i = 0; i < k + 1; i++)
			queue.add(arr[i]);

		int index = 0;
		for (i = k + 1; i < arr.length; i++) {
			arr[index++] = queue.poll();
			queue.add(arr[i]);
		}
		
		while(!queue.isEmpty()) {
			arr[index++] = queue.poll();
		}
	}
}
