package org.dsandalgo.problems;

public class GeneratePalindromicNumber {
	public static void main(String[] args) {
		
		int n = 10000;
		generateNumber(n);
		
	}

	static void generateNumber(int n) {
		int number;

		for (int j = 0; j < 2; j++) {
			int i = 1;
			while ((number = create(i, 10, j % 2)) < n) {
				System.out.println(number + " ");
				i++;
			}
		}

	}

	static int create(int input, int b, int isOdd) {

		int n = input;
		int palin = input;

		if (isOdd == 1)
			n /= b;

		while (n > 0) {
			palin = palin * b + (n % b);
			n /= b;
		}

		return palin;
	}
}
