package org.dsandalgo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Graph {
	private LinkedList<Integer>[] node;
	private int v;

	public Graph(int v) {
		this.v = v;
		node = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			node[i] = new LinkedList<Integer>();
		}
	}

	public void add(int n, int w) {
		node[n].add(w);
//		uncomment if undirectional
//		node[w].add(n);
	}

	public int getV() {
		return this.v;
	}

	public LinkedList<Integer>[] getNode() {
		return this.node;
	}

	@Override
	public String toString() {
		return "Graph [node=" + Arrays.toString(node) + "]";
	}

	public void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[v];
		visited[0] = true;
		queue.add(0);
		while (!queue.isEmpty()) {
			int index = queue.poll();
			System.out.print(index + " ");
			for (Integer idx : node[index]) {
				if (!visited[idx]) {
					queue.add(idx);
					visited[idx] = true;
				}
			}
		}
	}

	public void DFS() {
		boolean[] visited = new boolean[v];
		DFSUtils(0, visited);
	}

	private void DFSUtils(int i, boolean[] visited) {
		visited[i] = true;
		System.out.print(i + " ");
		for (Integer index : node[i]) {
			if (!visited[index]) {
				visited[index] = true;
				DFSUtils(index, visited);
			}
		}
	}

	public void transitiveClosure() {
		int[][] tc = new int[v][v];
		for (int i = 0; i < v; i++) {
			TCUtils(i, i, tc);
		}

		for (int[] it : tc) {
			System.out.println(Arrays.toString(it));
		}
	}

	private void TCUtils(int row, int col, int[][] tc) {
		tc[row][col] = 1;
		for (Integer index : node[row]) {
			if (tc[row][index] == 0) {
				TCUtils(row, index, tc);
			}
		}
	}

	private int countPathsUtils(int s, int d, boolean[] visited, int count) {
		visited[s] = true;
		if (s == d) {
			count++;
		} else {
			for (int n : node[s]) {
				if (!visited[n]) {
					count = countPathsUtils(n, d, visited, count);
				}
			}
		}

		visited[s] = false;
		return count;
	}

	public int countPaths(int s, int d) {
		boolean[] visited = new boolean[v];
		return countPathsUtils(s, d, visited, 0);
	}

	public int shortestPath(int s, int d) {
		boolean[] visited = new boolean[v];
		int[] distance = new int[v];
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);
		distance[s] = 1;
		while (!queue.isEmpty()) {
			int index = queue.poll();
//			System.out.print(index + " ");
			for (int n : node[index]) {
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					distance[n] = distance[index] + 1;
				}
				if (distance[d] > 0)
					return distance[d];
			}
		}

		return distance[d];
	}
}
