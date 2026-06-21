package Dijkstra_s_Algorithm_Single_Source_Shortest_Path_Greedy_Method;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
	int v;
	int weight;
	
	Edge(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}
}

class Graph {
	int vertice;
	List<List<Edge>> list;
	
	Graph(int vertice) {
		this.vertice = vertice;
		list = new ArrayList<>();
		
		for(int i=0;i<vertice;i++) {
			list.add(new ArrayList<>());
		}
	}
	
	void addEdges(int u, int v, int weight) {
		list.get(u).add(new Edge(v, weight));
	}
	
	void print() {
		for(int i=0;i<vertice;i++) {
			System.out.println("Vertice " + i +":");
			for(int j=0;j<list.get(i).size();j++) {
				System.out.println(list.get(i).get(j).v + " -> " + list.get(i).get(j).weight);
			}
		}
	}
	
	void dijkshtra() {
		PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> {
			return a.weight - b.weight;
		});
		
		ArrayList<Integer> dist = new ArrayList<>(vertice);
		for(int i=0;i<vertice;i++) {
			dist.add(Integer.MAX_VALUE);
		}
		dist.set(0, 0);
		queue.add(new Edge(0, 0));
		
		while(!queue.isEmpty()) {
			Edge val = queue.poll();
			int u = val.v;
			int wei = val.weight;
			
			for(Edge ed: list.get(u)) {
				if(dist.get(ed.v) > ed.weight + dist.get(u)) {
					dist.set(ed.v, ed.weight + dist.get(u));
					queue.add(new Edge(ed.v, dist.get(ed.v)));
				}
			}
		}
		
		System.out.println(dist);
	}
}

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdges(0, 1, 2);
		graph.addEdges(0, 2, 4);
		graph.addEdges(1, 2, 1);
		graph.addEdges(1, 3, 7);
		graph.addEdges(2, 4, 3);
		graph.addEdges(4, 3, 2);
		graph.addEdges(3, 5, 1);
		graph.addEdges(4, 5, 5);
		
		graph.print();
		
		graph.dijkshtra();
	}
}
