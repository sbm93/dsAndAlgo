package org.dsandalgo.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LetterCombinations {
	public static void main(String[] args) {

		String[] table = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		int[] numbers = { 2, 3 };
		ArrayList<String> list = letterCombinationsUtil(numbers, table);
		System.out.println(list);

	}

	private static ArrayList<String> letterCombinationsUtil(int[] numbers, String[] table) {
		ArrayList<String> list = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add("");
		
		while (!queue.isEmpty()) {
			String s = queue.poll();
			if (s.length() == numbers.length) {
				list.add(s);
			} else {
				String val = table[numbers[s.length()]];
				for (int i = 0; i < val.length(); i++) {
					queue.add(s + val.charAt(i));
				}
			}

		}

		return list;
	}
}
