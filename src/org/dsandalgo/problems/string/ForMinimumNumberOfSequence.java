package org.dsandalgo.problems.string;

/*
 *  Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. 
 *  Devise an algorithm to print the minimum number following that pattern. 
 *  Digits from 1-9 and digits can’t repeat.

	Examples:

	   Input: D        Output: 21
	   Input: I        Output: 12
	   Input: DD       Output: 321
	   Input: II       Output: 123
	   Input: DIDI     Output: 21435
	   Input: IIDDD    Output: 126543
	   Input: DDIDDIID Output: 321654798 
 */
public class ForMinimumNumberOfSequence {
	public static void main(String[] args) {
		String inputs[] = { "IDID", "I", "D", "DD", "II", "DIDI", "IIDDD", "DDIDDIID" };

		for (String input : inputs) {
			System.out.println(getMinNumberForPattern(input));
		}

	}

	static String getMinNumberForPattern(String input) {

		char[] result = new char[input.length() + 1];
		int count = 1;
		for (int i = 0; i <= input.length(); i++) {
			if (i == input.length() || input.charAt(i) == 'I') {
				for (int j = i - 1; j >= -1; j--) {

					result[j + 1] = (char) ((int) '0' + count++);

					if (j >= 0 && input.charAt(j) == 'I')
						break;
				}
			}
		}
		return new String(result);
	}

}
