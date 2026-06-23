package Bellman_Ford_Algorithm_Single_Source_Shortest_Path_Dynamic_Programming;

import java.util.Arrays;

public class Approach1 {
	public static void main(String[] args) {
		int[][] edges = {
				{0, 1, 4},
				{1, 2, -6}, 
				{2, 3, 5}, 
				{3, 1, -2}
		};
		
		int v = 5;
		
		Approach1 m = new Approach1();
		
		int[] arr = m.bellmonford(edges, v);
		
		for(int ele: arr) {
			System.out.print(ele + " ");
		}
	}
	
	public int[] bellmonford(int[][] edges, int n) {
		int distance[] = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		
		for(int i=0;i<n-1;i++) {
			for(int[] edge: edges) {
				int u = edge[0];
				int v = edge[1];
				int w = edge[2];
				
				if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w) {
					distance[v] = distance[u] + w;
				}
			}
		}
		
		for(int i=0;i<n-1;i++) {
			for(int[] edge: edges) {
				int u = edge[0];
				int v = edge[1];
				int w = edge[2];
				
				if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w) {
					return new int[] {-1};
				}
			}
		}
		
		return distance;
	}
}
