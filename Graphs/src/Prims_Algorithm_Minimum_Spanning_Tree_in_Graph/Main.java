package Prims_Algorithm_Minimum_Spanning_Tree_in_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
	int v;
	int w;
	Pair(int v, int w) {
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
				 {0, 1, 5}
		};
		int v = 2;
		
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
			
			list.get(u).add(new Pair(v, w));
			list.get(v).add(new Pair(u, w));
		}
		
		HashSet<Integer> set = new HashSet<>();
		PriorityQueue<Pair> queue = new PriorityQueue<>();
	    int minCost = 0;
		queue.add(new Pair(0, 0));
		minCost += 0;
		while(!queue.isEmpty()) {
			Pair temp = queue.poll();
			
			if(!set.contains(temp.v)) {
				minCost += temp.w;
				for(Pair pair: list.get(temp.v)) {
					queue.add(new Pair(pair.v, pair.w));
					set.add(temp.v);
				}
			}
		}
		
		return minCost;
	}
}
