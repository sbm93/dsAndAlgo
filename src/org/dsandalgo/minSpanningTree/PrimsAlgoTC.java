package org.dsandalgo.minSpanningTree;

public class PrimsAlgoTC {
	public static void main(String[] args) {
		int graph[][] = new int[][] { 
			{ 0, 2, 0, 6, 0 }, 
			{ 2, 0, 3, 8, 5 }, 
			{ 0, 3, 0, 0, 7 }, 
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 } };

		// Print the solution
		primMST(graph);
	}

	static void primMST(int[][] graph) {
		int[] parent = new int[graph.length];
		int[] key = new int[graph.length];

		boolean[] mstSet = new boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < graph.length; count++) {
			int u = minKey(key, mstSet);

			mstSet[u] = true;

			for (int v = 0; v < graph.length; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}

		printMST(parent, graph);

	}

	static void printMST(int parent[], int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < parent.length; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	static int minKey(int key[], boolean mstSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < key.length; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}
}
