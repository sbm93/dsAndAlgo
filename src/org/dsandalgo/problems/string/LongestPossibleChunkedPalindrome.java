package org.dsandalgo.problems.string;

public class LongestPossibleChunkedPalindrome {
	public static void main(String[] args) {

		System.out.println("V : " + LPCRec("V"));
		System.out.println("VOLLVO : " + LPCRec("VOLLVO"));
		System.out.println("VOLVOV : " + LPCRec("VOLVOV"));
		System.out.println("ghiabcdefhelloadamhelloabcdefghi : " + LPCRec("ghiabcdefhelloadamhelloabcdefghi"));

		System.out.println("ghiabcdefhelloadamhelloabcdefghik : " + LPCRec("ghiabcdefhelloadamhelloabcdefghik"));

		System.out.println("antaprezatepzapreanta : " + LPCRec("antaprezatepzapreanta"));
		
		System.out.println("geeksforgeeks : " + LPCRec("geeksforgeeks"));
		
		System.out.println("ab : " + LPCRec("ab"));
		
		
	}

	static int LPCRec(String str) {

		int i = 0, j = str.length() - 1;
		int count = 0;

		if (str.length() == 1)
			return count + 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				j--;
			} else {
				int a = j, b = str.length() - i;
				while (a < b) {
					if (str.charAt(i) != str.charAt(a)) {
						return count + 1;
					}
					i++;
					a++;
				}
				if (i != j) {
					count += 2;
				}
			}
		}

		return count + 1;

	}
}
