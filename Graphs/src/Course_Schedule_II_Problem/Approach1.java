package Course_Schedule_II_Problem;

import java.util.ArrayList;
import java.util.Stack;

public class Approach1 {
	public static void main(String[] args) {
		Approach1 m = new Approach1();
		
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
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i=0;i<v;i++) {
			edges.add(new ArrayList<>());
		}
		
		for(int[] ar: arr) {
			int p = ar[1];
			int q = ar[0];
			edges.get(p).add(q);
		}
		
		
		boolean[] visited = new boolean[v];
		boolean[] recursivePath = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				if(DFS(i, visited, recursivePath, edges)) {
					return new int[] {};
				}
			}
		}
		
		boolean[] vis = new boolean[v];
		Stack<Integer> ans = new Stack<>();
		
		for(int i=0;i<v;i++) {
			if(!vis[i]) {
				topologicalSorting(i, vis, ans, edges);
			}
		}
		
		int[] result = new int[ans.size()];
		int i = 0;
		
		while(ans.size() > 0) {
			result[i++] = ans.pop();
		}
		
		return result;
	}
	
	public void topologicalSorting(int source, boolean[] vis, Stack<Integer> ans, ArrayList<ArrayList<Integer>> edges) {
		vis[source] = true;
		
		for(int neigh: edges.get(source)) {
			if(!vis[neigh]) {
				topologicalSorting(neigh, vis, ans, edges);
			}
		}
		
		ans.add(source);
	}
	
	public boolean DFS(int source, boolean[] visited, boolean recursivePath[], ArrayList<ArrayList<Integer>> edges) {
		visited[source] = true;
		recursivePath[source] = true;
		
		for(int neigh: edges.get(source)) {
			if(!visited[neigh]) {
				if(DFS(neigh, visited, recursivePath, edges)) {
					return true;
				}
			} else if(recursivePath[neigh]) {
				return true;
			}
		}
		
		recursivePath[source] = false;
		return false;
	}
}