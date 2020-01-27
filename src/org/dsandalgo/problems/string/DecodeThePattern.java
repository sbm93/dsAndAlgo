package org.dsandalgo.problems.string;

/*
 * Given a pattern as below and an integer n your task is to decode it and print nth row of it. The pattern follows as :
	1
	11
	21
	1211
	111221
	............
 */
public class DecodeThePattern {
	public static void main(String[] args) {
		int count = 9;
		System.out.println(findPattern("1", count));
	}

	static String findPattern(String str, int n) {
		if (n == 0)
			return str;

		String comm = "";
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (comm.length() > 0 && comm.charAt(comm.length() - 1) != str.charAt(i)) {
				result = result + comm.length() + comm.charAt(comm.length() - 1);
				comm = "";
			}

			comm += str.charAt(i);
		}

		result = result + comm.length() + comm.charAt(comm.length() - 1);
		return findPattern(result, n - 1);
	}
}
