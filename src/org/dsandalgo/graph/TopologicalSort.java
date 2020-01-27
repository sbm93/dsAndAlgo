package org.dsandalgo.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
	static void topologicalSort(LinkedList<Integer>[] adj, int v) {
		Stack<Integer> stack = new Stack();
		boolean[] visited = new boolean[v];
		
		for (int i = 0; i < v; i++)
			if (!visited[i])
				topologicalSortUtil(adj, i, visited, stack);

		while (!stack.empty())
			System.out.print(stack.pop() + " ");
	}

	static void topologicalSortUtil(LinkedList<Integer>[] adj, int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		for (int n : adj[i]) {
			if(!visited[n])
				topologicalSortUtil(adj, n, visited, stack);
		}
		stack.add(i);
	}
}
