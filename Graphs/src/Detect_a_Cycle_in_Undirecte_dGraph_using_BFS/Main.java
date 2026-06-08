package Detect_a_Cycle_in_Undirecte_dGraph_using_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
	int child;
	int parent;
	
	Pair(int child, int parent) {
		this.child = child;
		this.parent = parent;
	}
}

class Graph {
	int v;
	List<List<Integer>> list;
	
	Graph(int v) {
		this.v = v;
		list = new ArrayList<>();
		
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
	}
	
	void addEdges(int u, int v) {
		list.get(u).add(v);
		list.get(v).add(u);
	}
	
	void print() {
		for(int i=0;i<v;i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
	
	boolean cycleDetection() {
		boolean[] visited = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				if(DFSTraversal(i, visited)) {
					return true;
				}
			}
		}
		
		return false;
	}

	boolean DFSTraversal(int source, boolean[] visited) {
		Queue<Pair> queue = new LinkedList<>();
		
		queue.add(new Pair(source, -1));
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			Pair temp = queue.poll();
			int child = temp.child;
			int parent = temp.parent;
			
			for(int neighbor: list.get(child)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(new Pair(neighbor,child));
				} else if(neighbor != parent) {
					return true;
				}
			}
		}
		
		return false;
	}
}

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdges(0, 1);
		graph.addEdges(0, 2);
		graph.addEdges(0, 3);
		graph.addEdges(1, 2);
		graph.addEdges(3, 4);
		
		graph.print();
		
		System.out.println("Output: " + graph.cycleDetection());
	}
}
