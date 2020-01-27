package org.dsandalgo.backtracking;

import java.util.ArrayList;

public class allPossiblePalindromeInString {

	public static String substr = "";

	public static void main(String[] args) {
		String str = "abaaab";
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		ArrayList<String> subset = new ArrayList<String>();

		print(str, subset, 0);
		System.out.println(results);
	}

	private static void print(String string, ArrayList<String> subset, int index) {
		int len = string.length();
		String str = "";
		ArrayList<String> current = new ArrayList<String>(subset);

		if (index >= len) {
			System.out.print(subset + " ");
		}
		for (int i = index; i < len; i++) {
			str += string.charAt(i);
			if (isPalindrom(str)) {
				subset.add(str);
				print(string, subset, i + 1);
				subset = new ArrayList<String>(current);
			}
		}

	}

	static boolean isPalindrom(String string) {
		if (string.length() == 0) {
			return false;
		}
		int start = 0, end = string.length() - 1;
		while (start < end) {
			if (string.charAt(start++) != string.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}
