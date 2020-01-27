package org.dsandalgo.weightedgraph;

public class App {
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(9);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(1, 2, 8);
		
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 5, 4);
		graph.addEdge(2, 8, 2);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(7, 6, 1);
		graph.addEdge(6, 8, 6);
		graph.addEdge(7, 8, 7);
		
		graph.dijkstra(0, 4);
		
		
	}
}

