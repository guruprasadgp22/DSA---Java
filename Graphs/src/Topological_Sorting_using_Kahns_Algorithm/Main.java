package Topological_Sorting_using_Kahns_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	
	void addEdge(int u, int v) {
		list.get(u).add(v);
	}
	
	void print() {
		for(int i=0;i<v;i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
	
	void topologicalSorting() {
		HashMap<Integer, Integer>  map = new HashMap<>();
		for(int i=0;i<v;i++) {
			map.put(i, 0);
		}
		for(int i=0;i<v;i++) {
			for(int j: list.get(i)) {
				map.put(j, map.get(j)+1);
			}
		}
		
		System.out.println(map); 
		
		Queue<Integer> queue = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			ans.add(temp);
			
			for(int neigh: list.get(temp)) {
				map.replace(neigh, map.get(neigh)-1);
				
				if(map.get(neigh) == 0) {
					queue.add(neigh);
				}
			}
		}
		
		System.out.println(ans);
	}
}
public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 0);
		graph.addEdge(0, 3);
		graph.addEdge(4, 0);
//		
		graph.print();
		graph.topologicalSorting();
	}
}
