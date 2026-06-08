package DFS_Traversal_in_Graphs;

import java.util.ArrayList;
import java.util.List;

class Graph  {
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
	
	void DFS() {
		boolean[] visited = new boolean[v];
		List<Integer> ans = new ArrayList<>();
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				DFSTraversal(i, visited, ans);
			}
		}
		
		for(int ele: ans) {
			System.out.print(ele + " ");
		}
	}

	void DFSTraversal(int source, boolean[] visited, List<Integer> ans) {
		visited[source] = true;
		ans.add(source);
		
		for(int neighbor: list.get(source)) {
			if(!visited[neighbor]) {
				DFSTraversal(neighbor, visited, ans);
			}
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
		
		graph.DFS();
	}
}
