package org.dsandalgo.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellWith1 {
	public static void main(String[] args) {
		int[][] mat = { 
				{ 0, 0, 0, 1 }, 
				{ 0, 0, 1, 1 }, 
				{ 0, 1, 1, 0 } };
		findMinDistance(mat);
	}

	static void findMinDistance(int[][] mat) {
		int[][] distance = new int[mat.length][mat[0].length];
		Queue<Loc> queue = new LinkedList<Loc>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				distance[i][j] = Integer.MAX_VALUE;
				if (mat[i][j] == 1) {
					distance[i][j] = 0;
					queue.add(new Loc(i, j));
				}
			}
		}

		int[] x = { -1, 0, 1, 0 };
		int[] y = { 0, -1, 0, 1 };
		
		while (!queue.isEmpty()) {
			Loc loc = queue.poll();
			for (int i = 0; i < x.length; i++) {
				int r = loc.x + x[i];
				int c = loc.y + y[i];
				if (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length
						&& distance[r][c] > distance[loc.x][loc.y] + 1) {
					distance[r][c] = distance[loc.x][loc.y] + 1;
					queue.add(new Loc(r, c));
				}
			}
		}

		for (int i = 0; i < distance.length; i++) {
			System.out.println(Arrays.toString(distance[i]));
		}
	}
}

class Loc {
	int x, y;

	Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
