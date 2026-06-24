package Prims_Algorithm_Minimum_Spanning_Tree_in_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
	int u;
	int v;
	int w;
	Pair(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Pair other) {
		return Integer.compare(this.w, other.w);
	}
}

public class Main {
	public static void main(String[] args) {
		int[][] Edges = {
				 {0, 1, 10},
				 {0, 2, 15},
				 {0, 3, 30},
				 {1, 3, 40},
				 {2, 3, 50}
		};
		int v = 4;
		
		Main m = new Main();
		System.out.println("Output: " + m.spanningTree(v, Edges));
	}
	
	public int spanningTree(int V, int[][] edges) {
		List<List<Pair>> list = new ArrayList<>();
		for(int i=0;i<V;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			list.get(u).add(new Pair(u, v, w));
			list.get(v).add(new Pair(v, u, w));
		}
		
		HashSet<Integer> set = new HashSet<>();
		int[][] ans = new int[V][2];
		int i=0;
		PriorityQueue<Pair> queue = new PriorityQueue<>();
	    int minCost = 0;
		queue.add(new Pair(-1, 0, 0));
		minCost += 0;
		while(!queue.isEmpty()) {
			Pair temp = queue.poll();
			
			if(!set.contains(temp.v)) {
				minCost += temp.w;
				if(temp.u != -1) {
					ans[i][0] = temp.u;
					ans[i][1] = temp.v;
					i++;
				}
				for(Pair pair: list.get(temp.v)) { 
					queue.add(new Pair(temp.v, pair.v, pair.w));
				}
				
				set.add(temp.v);
			}
		}
		for(int[] ed: ans) {
			System.out.println(ed[0] + " - " + ed[1]);
		}
		return minCost;
	}
}
