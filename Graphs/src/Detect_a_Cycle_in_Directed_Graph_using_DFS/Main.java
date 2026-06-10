package Detect_a_Cycle_in_Directed_Graph_using_DFS;

import java.util.ArrayList;
import java.util.List;

class Graph {
	int v;
	List<List<Integer>> list;
	
	Graph(int v) {
		this.v = v;
		list = new ArrayList<>(v);
		
		for(int i=0;i<v;i++) {
			list.add(new ArrayList<>());
		}
	}
	
	void addEdge(int u, int v) {
		list.get(u).add(v);
	}
	
	void print() {
		for(int i=0;i<v;i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
	
	boolean isCycle() {
		boolean[] visited = new boolean[v];
		boolean[] recursive = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(DFS(i, visited, recursive)) {
				return true;
			} 
		}
		
		return false;
	}

	private boolean DFS(int source, boolean[] visited, boolean[] recursive) {
		visited[source] = true;
		recursive[source] = true;
		
		for(int neigh: list.get(source)) {
			if(!visited[neigh]) {
				if(DFS(neigh, visited, recursive)) {
					return true;
				}
			} else if(recursive[neigh]) {
				return true;
			}
		}
		
		recursive[source] = false;
		return false;
	}
}
public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(1, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 1);
		
		graph.print();
		
		System.out.println("Output: " + graph.isCycle());
	}
}
