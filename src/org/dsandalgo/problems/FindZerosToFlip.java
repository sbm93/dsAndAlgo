package org.dsandalgo.problems;

public class FindZerosToFlip {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1 };
		int m = 2;
		System.out.println("Indexes of zeroes to be flipped are ");

		findZeroes(arr, m);
	}

	private static void findZeroes(int[] arr, int m) {
		int l = 0, r = 0, bestL = 0, bestWindow = 0, zeroCount = 0;

		while (r < arr.length) {

			if (zeroCount <= m) {
				if (arr[r] == 0)
					zeroCount++;
				r++;
			}

			if (zeroCount > m) {
				if (arr[l] == 0)
					zeroCount--;
				l++;
			}
			
			if(r-l > bestWindow && zeroCount <= m) {
				bestWindow = r - l;
				bestL = l;
			}
		}
		
		for(int i=0; i<bestWindow;i++) {
			if(arr[bestL+i] == 0)
				System.out.println(bestL+i+" ");
		}
	}

	private static void findZeroesMine(int[] arr, int m) {
		int s = 0, e = 0, count = 0, max = 0;
		int lastZeroPointer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				if (count == m) {
					count = 1;
					s = lastZeroPointer;
				} else
					count++;
				lastZeroPointer = i;
			}

			if (max < i - s) {
				max = i - s;
			}

		}

		System.out.println(max);
	}
}
