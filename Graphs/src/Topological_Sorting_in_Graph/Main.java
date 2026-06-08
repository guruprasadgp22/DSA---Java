package Topological_Sorting_in_Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	void addEdge(int u, int v) {
		list.get(u).add(v);
	}
	
	void print() {
		for(int i=0;i<v;i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
	
	void topologicalSort() {
		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				DFS(i,visited, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void DFS(int source, boolean[] visited, Stack<Integer> stack) {
		visited[source] = true;
		
		for(int neighbor: list.get(source)) {
			if(!visited[neighbor]) {
				DFS(neighbor, visited, stack);
			}
		}
		
		stack.add(source);
	}
}

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		
		graph.print();
		
		graph.topologicalSort();
	}
}