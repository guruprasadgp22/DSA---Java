package BFS_Traversal_in_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	void BFSTraversal(int source) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[v];
		
		queue.add(source);
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			int val = queue.poll();
			ans.add(val);
			
			for(int neighbor: list.get(val)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
		for(int ele: ans) {
			System.out.print(ele + " ");
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdges(0, 1);
		graph.addEdges(1, 2);
		graph.addEdges(1, 3);
		graph.addEdges(2, 4);
		
		graph.print();
		
		graph.BFSTraversal(0);
		
	}
}
