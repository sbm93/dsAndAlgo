package org.dsandalgo.problems;

import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	public static void main(String[] args) {
		String[] str = { "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN" };
		String start = "TOON";
		String end = "PLEA";

		System.out.println(shortestChainLength(str, start, end));

	}

	static int shortestChainLength(String[] str, String start, String end) {
		Queue<Item> queue = new LinkedList<Item>();
		queue.add(new Item(start, 1));
		while (!queue.isEmpty()) {
			Item item = queue.poll();

			if (item.word.equalsIgnoreCase(end)) {
				return item.len;
			}

			for (int i = 0; i < str.length; i++) {
				if (str[i] == null)
					continue;
				if (isValid(item.word, str[i]) == true) {
					queue.add(new Item(str[i], item.len + 1));
					str[i] = null;
				}

			}
		}
		return 0;
	}
	
	static boolean isValid(String word, String s) {
		int l = word.length();
		int count = 0;
		for (int i = 0; i < l; i++) {
			if (word.charAt(i) != s.charAt(i))
				count = count + 1;
		}
		return count == 1 ? true : false;
	}
}

class Item {
	String word;
	int len;

	Item(String word, int len) {
		this.word = word;
		this.len = len;
	}
}