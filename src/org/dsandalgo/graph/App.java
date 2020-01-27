package org.dsandalgo.graph;

public class App {

	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.add(0, 1);
		g.add(0, 2);
		g.add(1, 2);
		g.add(1, 5);
		g.add(2, 3);
		g.add(2, 4);
		g.add(2, 5);
		g.add(2, 6);
		g.add(3, 4);
		g.add(3, 6);
		g.add(3, 7);
		g.add(4, 6);
		g.add(4, 7);
		g.add(5, 6);
		g.add(5, 8);
		g.add(6, 7);
		g.add(6, 8);

//		System.out.println(g);

//		g.BFS();
//		System.out.println("\n");
//		g.DFS();
//		
//		g.transitiveClosure();

		/*
		 * Note: BFS doesn't give shortest path but the first possible path available
		 */
//		System.out.println(g.shortestPath(1, 5));

//		System.out.println(g.countPaths(1, 5));
		
		TopologicalSort.topologicalSort(g.getNode(), g.getV());
	}

}
