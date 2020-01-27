package org.dsandalgo.problems.array;

public class MinimumMovesToSortAnArray {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 4, 3, 2, 6, 1 };

		System.out.println(getMoves(arr));
	}

	static int getMoves(int[] arr) {
		int expected = arr.length;
		for (int i = arr.length - 1; i >= 0; i--) {

			if (arr[i] == expected)
				expected--;
		}

		return expected;
	}

}
