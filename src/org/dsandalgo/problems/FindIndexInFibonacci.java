package org.dsandalgo.problems;

public class FindIndexInFibonacci {
	public static void main(String[] args) {
		System.out.println(findIndex(55));
	}
	
	private static int findIndex(int k) {
		
		int a = 0, b = 1;
		int pos = 1;
		int c = 1;
		while(c < k) {
			c  = a + b;
			pos++;
			a = b;
			b = c;
		}
		return pos;
	}
}
