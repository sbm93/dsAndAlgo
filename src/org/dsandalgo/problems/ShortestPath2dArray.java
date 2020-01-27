package org.dsandalgo.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath2dArray {
	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 }, { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 }, };

		// Find shortest path from source (0, 0) to
		// destination (7, 5)
		int distance = BFS(mat, new Node(0, 0, 0), new Node(7, 5, 0));

		System.out.println("Shortrest distance for source to destination: " + distance);
	}

	public static int BFS(int[][] mat, Node source, Node destination) {
		int[] row = { -1, 0, 0, 1 };
		int[] col = { 0, -1, 1, 0 };
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		visited[source.x][source.y] = true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(source);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x, y = node.y, dist = node.dist;
			if (x == destination.x && y == destination.y)
				return dist;
			for (int i = 0; i < 4; i++) {
				int r = x + row[i], c = y + col[i];
				if (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == 1 && !visited[r][c]) {
					queue.add(new Node(r, c, dist + 1));
				}
			}
		}

		return -1;
	}
}

class Node {
	int x, y, dist;

	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
