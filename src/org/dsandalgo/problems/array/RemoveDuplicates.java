package org.dsandalgo.problems.array;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int n = arr.length;

		n = remove(arr, n);

		// Print updated array
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	static int remove(int[] arr, int n) {
		int lastIndex = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] != arr[i - 1]) {
				arr[++lastIndex] = arr[i];
			}
		}

		return lastIndex + 1;
	}

}
