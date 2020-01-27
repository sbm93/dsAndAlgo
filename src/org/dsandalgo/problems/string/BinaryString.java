package org.dsandalgo.problems.string;

/*
 * Given a binary string, count number of substrings that start and end with 1. 
 * For example, if the input string is “00100101”, 
 * then there are three substrings “1001”, “100101” and “101”.
 */
public class BinaryString {
	public static void main(String[] args) {
		String str = "10100101";
		System.out.println(getCount(str));
	}

	static int getCount(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1')
				count++;
		}
		return count * (count-1) / 2;
	}
}
