package Course_Schedule_II_Problem;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		
		int numCourse = 4;
		int preReq[][] = {
				{1, 0},
				{2, 0},
				{3, 1},
				{3, 2}
		};
		
		int[] ans = m.findOrder(numCourse, preReq);
		for(int ele: ans) {
			System.out.print(ele + " ");
		}
	}
	
	public int[] findOrder(int v, int[][] arr) {
		boolean[] visited = new boolean[v];
		boolean[] recursivePath = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				if(DFS(i, visited, recursivePath, arr)) {
					return new int[] {};
				}
			}
		}
		
		boolean[] vis = new boolean[v];
		Stack<Integer> ans = new Stack<>();
		
		for(int i=0;i<v;i++) {
			if(!vis[i]) {
				topologicalSorting(i, vis, ans, arr);
			}
		}
		
		int[] result = new int[ans.size()];
		int i = 0;
		
		while(ans.size() > 0) {
			result[i++] = ans.pop();
		}
		
		return result;
	}
	
	public void topologicalSorting(int source, boolean[] vis, Stack<Integer> ans, int[][] edges) {
		vis[source] = true;
		
		for(int i=0;i<edges.length;i++) {
			int v = edges[i][0];
			int u = edges[i][1];
			
			if(source == u) {
				if(!vis[v]) {
					topologicalSorting(v, vis, ans, edges);
				}
			}
		}
		
		ans.add(source);
	}
	
	public boolean DFS(int source, boolean[] visited, boolean recursivePath[], int[][] edges) {
		visited[source] = true;
		recursivePath[source] = true;
		
		for(int i=0;i<edges.length;i++) {
			int v = edges[i][0];
			int u = edges[i][1];
			
			if(source == u) {
				if(!visited[v]) {
					if(DFS(v, visited, recursivePath, edges)) {
						return true;
					}
				} else if(recursivePath[v]) {
					return true;
				}
			}
		}
		
		recursivePath[source] = false;
		return false;
	}
}