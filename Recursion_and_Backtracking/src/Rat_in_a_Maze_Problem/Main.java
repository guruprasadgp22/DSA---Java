package Rat_in_a_Maze_Problem;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[][] arr = {
			{1,0,0,0},
			{1,1,0,1},
			{1,1,0,0},
			{0,1,1,1}
		};
		int n = 4;
		Main m = new Main();
		
		List<String> result = m.findPath(arr, n);
		
		for(String ans: result) {
			System.out.println(ans);
		}
	}

	private List<String> findPath(int[][] arr, int n) {
		int row = 0;
		int col = 0;
		List<String> result = new ArrayList<>();
		String path = "";
		boolean[][] visited = new boolean[n][n];
		pathFinder(arr, n, row, col, result, path, visited);
		
		return result;
	}
	
	private void pathFinder(int[][] arr, int n, int row, int col, List<String> result, String path, boolean[][] visited) {
		if(row < 0 || col < 0 || col >= n || row >= n || arr[row][col] == 0 || visited[row][col] == true) {
			return;
		}
		 
		if(row == n-1 && col == n-1) {
			result.add(path);
			return;
		}
		
		visited[row][col] = true;
		
		pathFinder(arr, n, row+1, col, result, path+"D", visited);
		pathFinder(arr, n, row-1, col, result, path+"U", visited);
		pathFinder(arr, n, row, col-1, result, path+"L", visited);
		pathFinder(arr, n, row, col+1, result, path+"R", visited);
		
		visited[row][col] = false;
	}
}
