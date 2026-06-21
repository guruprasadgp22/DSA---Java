package Dijkstra_s_Algorithm_Single_Source_Shortest_Path_Greedy_Method;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
	int destanation;
	int weight;
	
	Node(int destanation, int weight) {
		this.destanation = destanation;
		this.weight = weight;
	}
}

public class Approach1 {
	
	int[] dijkstra(List<List<Node>> graph, int n, int source) {
		int[] distance = new int[n];
		for(int i=0;i<n;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
			return a.weight - b.weight;
		});
		
		distance[0] = 0;
		queue.add(new Node(source, 0));
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			int u = temp.destanation;
			
			if(temp.weight > distance[u]) {
				continue;
			}
			
			for(Node v: graph.get(u)) {
				if(distance[v.destanation] > v.weight + distance[u]) {
					distance[v.destanation] = v.weight + distance[u];
					queue.add(new Node(v.destanation, distance[v.destanation]));
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String[] args) {
		List<List<Node>> list = new ArrayList<>(6);
		for(int i=0;i<6;i++) {
			list.add(new ArrayList<>());
		}
		list.get(0).add(new Node(1, 2));
		list.get(0).add(new Node(2, 4));
		list.get(1).add(new Node(3, 7));
		list.get(1).add(new Node(2, 1));
		list.get(2).add(new Node(4, 3));
		list.get(3).add(new Node(5, 1));
		list.get(4).add(new Node(3, 2));
		list.get(4).add(new Node(5, 5));
		Approach1 m = new Approach1();
		int[] arr = m.dijkstra(list, 6, 0);
		
		for(int ele: arr) {
			System.out.print(ele + " ");
		}
		
	}
}
