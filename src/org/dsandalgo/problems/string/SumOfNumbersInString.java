package org.dsandalgo.problems.string;

public class SumOfNumbersInString {
	public static void main(String[] args) {
		String string = new String("1abc2x30yz67");
		System.out.println(getSum(string));
	}

	static int getSum(String string) {
		int sum = 0;
		String num = "";
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				num += string.charAt(i);
			} else if (num.length() > 0) {
				sum += Integer.parseInt(num);
				num = "";
			}
		}
		sum += Integer.parseInt(num);
		return sum;
	}
}
