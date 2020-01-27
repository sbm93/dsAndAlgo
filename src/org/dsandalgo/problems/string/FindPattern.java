package org.dsandalgo.problems.string;

/*
 * Given a dictionary of words, find all strings that matches the given pattern 
 * where every character in the pattern is uniquely mapped 
 * to a character in the dictionary.
 */
public class FindPattern {
	public static void main(String[] args) {
		String[] dict = { "abb", "abc", "xyz", "xyy" };
		String pattern = "foo";

		int numericPattern = getPattern(pattern);
		findMatchedWords(dict, numericPattern);

	}

	static void findMatchedWords(String[] dict, int pattern) {
		for (int i = 0; i < dict.length; i++) {
			int numericPattern = getPattern(dict[i]);

			if (numericPattern == pattern) {
				System.out.print(dict[i] + " ");
			}
		}
	}

	static int getPattern(String str) {
		int resultPattern = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == str.charAt(i)) {
				resultPattern = addition(resultPattern, resultPattern % 10);
			} else {
				resultPattern = addition(resultPattern, resultPattern % 10 + 1);
			}
		}

		return resultPattern;
	}

	static int addition(int val, int num) {
		return val * 10 + num;
	}
}
