package Course_Schedule_Problem;

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
	
	boolean isCycle() {
		boolean[] visited = new boolean[v];
		boolean[] recursive = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				if(DFS(i, visited, recursive)) {
					return false;
				}
			}
		}
		
		return true;
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
		int numCourse = 4;
		int preReq[][] = {
				{1, 0},
				{2, 0},
				{3, 1},
				{3, 2}
		};
		
		Graph graph = new Graph(numCourse);
		
		for(int i=0;i<preReq.length;i++) {
			graph.addEdge(preReq[i][0], preReq[i][1]);
		}
		
		System.out.println(graph.isCycle());
	}
}