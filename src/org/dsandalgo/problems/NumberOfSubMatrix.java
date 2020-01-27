package org.dsandalgo.problems;

public class NumberOfSubMatrix {

	public static void main(String[] args) {
		
		System.out.println(countSubMatrix2D(new Points(4, 3), new Points(3, 2)));
	}
	
	private static int countSubMatrix2D(Points p, Points k) {
		
		int count = subMatrixInRow(p.x, k.x) * subMatrixInRow(p.y, k.y);
		if(p.x != p.y || k.x != k.y) {
			count += subMatrixInRow(p.x, k.y) * subMatrixInRow(p.y, k.x);
		}
		return count;
	}

	private static int countSubMatrix1D(int n, int m, int k) {

		int subMatrixInRow = subMatrixInRow(n, k) * m;
		int subMatrixInCol = subMatrixInRow(m, k) * n;
		return subMatrixInCol + subMatrixInRow;

	}

	private static int subMatrixInRow(int n, int k) {
		if (k > n)
			return 0;
		return n - k + 1;
	}

}

class Points {
	int x, y;

	Points(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
