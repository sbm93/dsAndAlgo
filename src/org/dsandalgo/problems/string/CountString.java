package org.dsandalgo.problems.string;

public class CountString {
	public static void main(String[] args) {
		int n = 3; // Total number of characters
		/*
		 * Exponential Soluation
		 */
		System.out.println(countStr(n, 1, 2));

		/*
		 * Efficient Solution - not really efficient, dont look
		 */
		System.out.println(countStr(2, 1, 2));
	}

	static int countStrEff(int n, int bCount, int cCount) {

		return 0;
	}

	static int countStr(int n, int bCount, int cCount) {

		if (bCount < 0 || cCount < 0)
			return 0;
		if (n == 0)
			return 1;
		if (bCount == 0 && cCount == 0)
			return 1;

		int res = countStr(n - 1, bCount, cCount);
		res += countStr(n - 1, bCount - 1, cCount);
		res += countStr(n - 1, bCount, cCount - 1);

		return res;

	}
}
