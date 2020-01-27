package org.dsandalgo.problems.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class KMostFrequentElements {
	public static void main(String[] args) {
		int[] arr = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int k = 4;
//		Use HashMap to get the solution
		kMostFrequentNumbers(arr, k);
	}

	static void kMostFrequentNumbers(int[] arr, int k) {
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
//		System.out.println(map);

		LinkedList<Integer>[] a = new LinkedList[n];
		for (int i = 0; i < n; i++)
			a[i] = new LinkedList<Integer>();

		for (Entry<Integer, Integer> mp : map.entrySet()) {
			a[mp.getValue()].add(mp.getKey());
		}

		for (int i = n - 1; i >= 0; i--) {
			for (Integer vl : a[i]) {
				System.out.println(vl);
				k--;
				if (k == 0)
					return;
			}
		}
	}
}
