package org.dsandalgo.minSpanningTree;

public class App {
	public static void main(String[] args) {
		/*
		 * int vertices = 6; KruskalsAlgo graph = new KruskalsAlgo(vertices);
		 * graph.addEgde(0, 1, 4); graph.addEgde(0, 2, 3); graph.addEgde(1, 2, 1);
		 * graph.addEgde(1, 3, 2); graph.addEgde(2, 3, 4); graph.addEgde(3, 4, 2);
		 * graph.addEgde(4, 5, 6); graph.kruskalMST();
		 */
		
		int vertices = 5;
		
		PrimsAlgo graph = new PrimsAlgo(vertices);
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 3, 6);
		graph.addEdge(1, 3, 8);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 4, 5);
		graph.addEdge(2, 4, 7);
		graph.addEdge(3, 4, 9);
		
		graph.primMST();
	}
}
