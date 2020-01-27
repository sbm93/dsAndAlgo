package org.dsandalgo.problems;

public class MaximumWaterStoredBetweenBuildings {

	public static void main(String[] args) {
		int height[] = { 2, 1, 3, 4, 6, 5 };
		int n = height.length;

		System.out.print(maxWater(height, n));
	}

	static int maxWater(int[] height, int n) {
		int i = 0, j = n - 1;
		int max = 0;
		while (i < j) {
			if (height[i] < height[j]) {
				max = Math.max(max, (j - i - 1) * height[i]);
				i++;
			} else if (height[j] < height[i]) {
				max = Math.max(max, (j - i - 1) * height[j]);
				j--;
			} else {
				max = Math.max(max, (j - i - 1) * height[i]);
				i++;
				j--;
			}
		}

		return max;
	}

}
