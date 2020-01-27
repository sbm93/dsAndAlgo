package org.dsandalgo.minSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalsAlgo {

	int vertices; // V-> no. of vertices & E->no.of edges
	List<Edge> allEdges = new ArrayList<>(); // collection of all edges

	// Creates a graph with V vertices and E edges
	KruskalsAlgo(int v) {
		this.vertices = v;
	}

	public void addEgde(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		allEdges.add(edge); // add to total edges
	}

	public List<Edge> getEdges() {
		return allEdges;
	}

	public void kruskalMST() {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

		for (int i = 0; i < allEdges.size(); i++)
			pq.add(allEdges.get(i));

		// create a parent []
		int[] parent = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			parent[i] = i;
		}

		ArrayList<Edge> mst = new ArrayList<>();

		int index = 0;

		while (index < vertices - 1) {

			Edge edge = pq.poll();

			// check if adding this edge create a cycle
			int x_set = find(parent, edge.src);
			int y_set = find(parent, edge.dest);

			// if x_set == y_set it is a cycle or it will create a cycle
			// we need to ignore it.

			if (x_set != y_set) {
				mst.add(edge);
				index++;
				union(parent, x_set, y_set);
			}

		}

		System.out.println("Minimum Spanning tree");

		for (int i = 0; i < mst.size(); i++) {
			Edge edge = mst.get(i);
			System.out.println(
					"Edge-" + i + " source: " + edge.src + " destination: " + edge.dest + " weight: " + edge.weight);
		}

	}

	public int find(int[] parent, int vertex) {
		// chain of parent pointers from x upwards through the tree
		// until an element is reached whose parent is itself
		if (parent[vertex] != vertex)
			return find(parent, parent[vertex]);
		return vertex;
	}

	public void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		// make x as parent of y
		parent[y_set_parent] = x_set_parent;
	}

}

class Edge implements Comparable<Edge> {
	int src, dest, weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	// Comparator function used for sorting edges
	// based on their weight
	public int compareTo(Edge compareEdge) {
		return this.weight - compareEdge.weight;
	}
};
