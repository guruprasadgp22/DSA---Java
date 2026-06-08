package Detect_a_Cycle_in_Undirected_Graph_using_DFS;

import java.util.ArrayList;
import java.util.List;

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
				if(DFSTraversal(i, visited, -1)) {
					return true;
				}
			}
		}
		
		return false;
	}

	boolean DFSTraversal(int source, boolean[] visited, int parent) {
		visited[source] = true; 
		
		for(int neighbor: list.get(source)) {
			if(!visited[neighbor]) {
				if(DFSTraversal(neighbor, visited, source)) {
					return true;
				}
			} else if(parent != neighbor) {
				return true;
			}
		}
		
		return false;
	}
}

public class Main {
	public static void main(String[] args) {
		 Graph graph = new Graph(5);
		 graph.addEdges(0, 1);
//		 graph.addE dges(0, 2);
		 graph.addEdges(0, 3);
		 graph.addEdges(1, 2);
		 graph.addEdges(3, 4);
		 
		 graph.print();
		 
		 System.out.println("Output: " + graph.cycleDetection());
	}
}