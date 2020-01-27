package org.dsandalgo.weightedgraph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import javafx.scene.Parent;

public class WeightedGraph {
	int v;
	LinkedList<Node>[] adj;

	public WeightedGraph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Node>();
		}
	}

	public void addEdge(int s, int d, int w) {
		adj[s].add(new Node(d, w));
//		Uncomment below for undirectional
		adj[d].add(new Node(s, w));
	}


	public void dijkstra(Integer source, Integer dest) {
		int[] distance = new int[v];
		for (int i = 0; i < v; i++)
			distance[i] = Integer.MAX_VALUE;
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
		Set<Integer> settled = new HashSet<>();
		Map<Integer, Integer> parent = new HashMap<Integer, Integer>();

		priorityQueue.add(new Node(source, source));
		distance[source] = 0;
		parent.put(source, null);
		while (settled.size() != v) {
			int u = priorityQueue.poll().node;
			
			if(settled.contains(u))
				continue;	
			
			settled.add(u);
//			e_neighbours(u, priorityQueue, Settled, distance);
			for(Node v : adj[u]) {
				if(!settled.contains(v.node)) {
					if((distance[u] + v.cost) < distance[v.node] ) {
						parent.put(v.node, u);
						distance[v.node] = distance[u] + v.cost;
					}
					
					priorityQueue.add(new Node(v.node, distance[v.node]));
				}
			}
		}
		
		System.out.println("Total cost: " + distance[dest]);
		System.out.print("Path: " + dest + " ");
		while (parent.containsKey(dest)) {
			System.out.print(parent.get(dest) + " ");
			dest = parent.get(dest);
		}
		
	}
	@Override
	public String toString() {
		return "WeightedGraph [v=" + v + ", adj=" + Arrays.toString(adj) + "]";
	}

}

class Node implements Comparable<Node> {
	public int node;
	public int cost;

	public Node() {
	}

	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}

	@Override
	public String toString() {
		return "Node [node=" + node + ", cost=" + cost + "]";
	}
}