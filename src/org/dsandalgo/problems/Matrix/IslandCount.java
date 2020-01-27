package org.dsandalgo.problems.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCount {
	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		int mat[][] = { 
				{ 1, 1, 0, 0, 0 }, 
                { 0, 1, 0, 0, 1 }, 
                { 1, 0, 0, 1, 1 }, 
                { 0, 0, 0, 0, 0 }, 
                { 1, 0, 1, 0, 1 } };
		countIsland(mat);
	}

	static void countIsland(int[][] mat) {
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		int count = 0;
		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[0].length; j++)
				if (mat[i][j] == 1 && !visited[i][j]) {
					BFS(mat, i, j, visited);
					count += 1;
				}
		
		System.out.println(count);
	}

	static void BFS(int[][] mat, int row, int col, boolean[][] visited) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(row, col));
		visited[row][col] = true;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (int i = 0; i < 8; i++) {
				int nx = node.x + x[i];
				int ny = node.y + y[i];
				if (nx >= 0 && nx < mat.length && ny >= 0 && 
						ny < mat[0].length && mat[nx][ny] == 1
						&& !visited[nx][ny]) {
					queue.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

}
