package org.dsandalgo.problems.array;

import java.util.Arrays;

/*
 * Find a triplet that sum to a given value
 */
public class FindAllTriplet {
	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int sum = 22;
		int arr_size = A.length;
		System.out.println(findTriplet(A, sum, arr_size));
	}

	static boolean findTriplet(int[] arr, int sum, int n) {

		int l, r;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < n - 2; i++) {
			l = i + 1;
			r = n - 1;
			while (l < r) {
				if(arr[i] + arr[l] + arr[r] == sum) {
					System.out.printf("Triplet is %d, %d, %d \n", arr[i], arr[r], arr[l]);
					return true;
				} else if(arr[i] + arr[l] + arr[r] < sum) {
					l++;
				} else {
					r--;
				}
				
			}
		}
		return false;
	}
}
