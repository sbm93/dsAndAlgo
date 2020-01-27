package org.dsandalgo.problems.array;

public class MedianOfSortedArray {
	public static void main(String[] args) {
		int ar1[] = { 1, 12, 15, 26, 38 };
		int ar2[] = { 2, 13, 17, 30, 45 };

		System.out.println(findMedian(ar1, ar2, ar1.length, ar2.length));
	}

	static int findMedian(int[] arr1, int[] arr2, int m, int n) {
		int i = 0, j = 0;
		int count;
		int m1 = -1, m2 = -1;
		if ((m + n) % 2 == 1) {
			for (count = 0; count <= (m + n) / 2; count++) {
				if (i != n && j != m) {
					m1 = (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
				} else if (i < m) {
					m1 = arr1[i++];
				} else {
					m1 = arr2[j++];
				}
			}
			return m1;
		} else {
			for (count = 0; count <= (m + n) / 2; count++) {
				m2 = m1;
				if (i != n && j != m) {
					m1 = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
				} else if (i < m) {
					m1 = arr1[i++];
				} else {
					m1 = arr2[j++];
				}

			}
			System.out.println(m1 + " " + m2);
			return (m1 + m2) / 2;
		}
	}
}
