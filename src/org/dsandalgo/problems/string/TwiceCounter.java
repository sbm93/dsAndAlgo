package org.dsandalgo.problems.string;

import java.util.HashMap;
import java.util.Map.Entry;

public class TwiceCounter {
	public static void main(String[] args) {
		String string = "hate love peace love peace hate love peace love peace";
		String[] strArr = string.split(" ");
		System.out.println(getCount(strArr));
	}

	static int getCount(String[] string) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < string.length; i++) {
			if (map.containsKey(string[i])) {
				map.put(string[i], map.get(string[i]) + 1);
			} else {
				map.put(string[i], 1);
			}
		}
		int res = 0;
		for (Entry<String, Integer> m : map.entrySet()) {
			if (m.getValue() == 2) {
				res++;
			}
		}

		return res;
	}
}
