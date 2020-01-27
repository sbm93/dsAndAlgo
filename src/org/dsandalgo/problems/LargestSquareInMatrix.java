package org.dsandalgo.problems;

public class LargestSquareInMatrix {

	public static void main(String[] args) {

		int[][] mat = { 
				{ 0, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 1, 0 }, 
				{ 0, 1, 1, 1, 0 }, 
				{ 1, 1, 1, 1, 0 }, 
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } 
			};

		findMaxSubSquare(mat);

	}

	private static void findMaxSubSquare(int[][] mat) {
		int max = 0;
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					mat[i][j] = 1 + Math.min(mat[i][j - 1], Math.min(mat[i - 1][j], mat[i - 1][j - 1]));
					if (max < mat[i][j])
						max = mat[i][j];
				}
			}
		}

		System.out.println(max);
	}

}
