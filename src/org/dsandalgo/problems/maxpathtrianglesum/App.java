package org.dsandalgo.problems.maxpathtrianglesum;

public class App {
	public static void main(String[] args) {
		int tri[][] = { { 3, 0, 0, 0 }, { 7, 4, 0, 0 }, { 2, 4, 6, 0 }, { 8, 5, 9, 3 } };
		maxPathSum(tri);
	}

	static void maxPathSum(int[][] tri) {
		/*
		 * { 1, 0, 0 } { 4, 8, 0 } { 1, 5, 3 }
		 */
		for (int i = tri.length - 2; i >= 0; i--) {
			for (int j = 0; j < tri[0].length - 1; j++) {
				if (tri[i + 1][j] > tri[i + 1][j + 1]) {
					tri[i][j] += tri[i + 1][j];
				} else {
					tri[i][j] += tri[i + 1][j + 1];
				}
			}
		}

		System.out.println(tri[0][0]);
	}
}
