package org.dsandalgo.problems.Matrix;

import java.util.Arrays;

public class FloodFillAlgorithm {
	public static void main(String[] args) {
		int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1}, 
                {1, 1, 1, 1, 1, 1, 0, 0}, 
                {1, 0, 0, 1, 1, 0, 1, 1}, 
                {1, 2, 2, 2, 2, 0, 1, 0}, 
                {1, 1, 1, 2, 2, 0, 1, 0}, 
                {1, 1, 1, 2, 2, 2, 2, 0}, 
                {1, 1, 1, 1, 1, 2, 1, 1}, 
                {1, 1, 1, 1, 1, 2, 2, 1}, 
                }; 
		int x = 4, y = 4, newC = 3; 
		floodFill(screen, x, y, newC); 
		
		for (int i = 0; i < screen.length; i++) {
			System.out.println(Arrays.toString(screen[i]));
		}

	}

	static void floodFill(int[][] screen, int x, int y, int newC) {
		int prevC = screen[x][y];
		floodFillUtil(screen, x, y, prevC, newC);
	}

	static void floodFillUtil(int[][] screen, int x, int y, int prevC, int newC) {
		if (x < 0 || x >= screen.length || y < 0 || y > screen[0].length)
			return;
		if (screen[x][y] != prevC)
			return;

		screen[x][y] = newC;

		floodFillUtil(screen, x + 1, y, prevC, newC);
		floodFillUtil(screen, x - 1, y, prevC, newC);
		floodFillUtil(screen, x, y + 1, prevC, newC);
		floodFillUtil(screen, x, y - 1, prevC, newC);

	}

}
