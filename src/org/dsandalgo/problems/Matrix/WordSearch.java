package org.dsandalgo.problems.Matrix;

public class WordSearch {

	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		int R = 3;
		int C = 13;
		char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
				{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		patternSearch(grid, "GEEKS");
		System.out.println();
	}

	static void patternSearch(char[][] grid, String search) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (search2D(grid, row, col, search))
					System.out.println("pattern found at " + row + ", " + col);
			}
		}
	}

	static boolean search2D(char[][] grid, int row, int col, String word) {
		if (grid[row][col] != word.charAt(0))
			return false;
		int len = word.length();

		for (int dir = 0; dir < 8; dir++) {

			int rdir = row + x[dir], cdir = col + y[dir];
			int k;
			for (k = 1; k < len; k++) {
				if (rdir < 0 || rdir >= grid.length || cdir < 0 || cdir >= grid[0].length)
					break;

				if (grid[rdir][cdir] != word.charAt(k))
					break;
				rdir += x[dir];
				cdir += y[dir];
			}

			if (k == len) {
				return true;
			}
		}

		return false;
	}
}
