package Bellman_Ford_Algorithm_Single_Source_Shortest_Path_Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair {
	int v;
	int weight;
	
	Pair(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}
}

public class Main {
	
	public int[] fellmonFordAlg(int src, List<List<Pair>> graph, int n) {
		int[] ans = new int[n];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[src] = 0;
		
		for(int i=0;i<n-1;i++) {
			for(int u=0;u<n;u++) {
				for(Pair pair: graph.get(u)) {
					if(ans[pair.v] > ans[u] + pair.weight) {
						ans[pair.v] = ans[u] + pair.weight;
					}
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int v = 5;
		List<List<Pair>> graph = new ArrayList<>();
		for(int i=0;i<v;i++) {
			graph.add(new ArrayList<>());
		}
		
		graph.get(0).add(new Pair(1, 2));
		graph.get(0).add(new Pair(2, 4));
		graph.get(1).add(new Pair(2, -4));
		graph.get(1).add(new Pair(4,-1));
		graph.get(2).add(new Pair(3, 2));
		graph.get(3).add(new Pair(4, 4));
		
		Main m = new Main();
		int[] ans = m.fellmonFordAlg(0, graph, v);
		
		for(int ele: ans) {
			System.out.print(ele + " ");
		}
	}
}
