package org.dsandalgo.minSpanningTree;

import java.util.Arrays;
import java.util.LinkedList;

public class PrimsAlgo {
	private LinkedList<Node>[] node;
	private int v;

	public PrimsAlgo(int v) {
		this.v = v;
		node = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			node[i] = new LinkedList<Node>();
		}
	}

	public void addEdge(int src, int dest, int weight) {
		node[src].add(new Node(dest, weight));
//		uncomment if undirectional
		node[dest].add(new Node(src, weight));
	}

	int minKey(int key[], boolean mstSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int i = 0; i < key.length; i++)
			if (mstSet[i] == false && key[i] < min) {
				min = key[i];
				min_index = i;
			}

		return min_index;
	}

	void primMST() {
		int[] parent = new int[this.v];
		int[] key = new int[this.v];

		boolean[] mstSet = new boolean[this.v];

		for (int i = 0; i < this.v; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < this.v; count++) {
			int u = minKey(key, mstSet);

			mstSet[u] = true;

			for (Node n : node[u]) {
				if (mstSet[n.dest] == false && n.weight < key[n.dest]) {
					key[n.dest] = n.weight;
					parent[n.dest] = u;
				}
			}
		}

//		printMST(parent, key);

		System.out.println("Edge \tWeight");
		for (int i = 1; i < parent.length; i++)
			System.out.println(parent[i] + " - " + i + "\t" + key[i]);

	}

	static void printMST(int parent[], int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < parent.length; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	static class Node {
		int dest;
		int weight;

		Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
}
