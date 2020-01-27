package org.dsandalgo.problems.string;

/*
 * Find uncommon characters of the two strings
 */
public class RemoveCharacter {
	public static void main(String[] args) {
		String str1 = "characters";
		String str2 = "alphabets";
		findAndPrintUncommonChars(str1, str2);
	}

	static void findAndPrintUncommonChars(String str1, String str2) {

		int MAX_CHAR = 26;
		int[] present = new int[MAX_CHAR];
		for (int i = 0; i < str1.length(); i++)
			present[str1.charAt(i) - 'a'] = 1;

		for (int i = 0; i < str2.length(); i++) {
			if (present[str2.charAt(i) - 'a'] == 1 || present[str2.charAt(i) - 'a'] == -1) {
				present[str2.charAt(i) - 'a'] = -1;
			} else {
				present[str2.charAt(i) - 'a'] = 2;
			}
		}

		for (int i = 0; i < MAX_CHAR; i++) {
			if (present[i] > 0) {
				System.out.println((char) (i + 'a'));
			}
		}
	}
}
