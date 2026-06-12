package Flood_Fill_Algorithm;

public class Main {
	public static void main(String[] args) {
		int[][] arr = {
				{1,0,1,1},
				{0,1,0,1},
				{1,1,1,1}
		};
		Main m = new Main();
		m.dfs(arr, 1, 1, 1, 2);
		
		for(int ele[]: arr) {
			System.out.println(ele[0] + " " + ele[1] + " " + ele[2] + " " + ele[3]);
		}
	}
	
	void dfs(int[][] arr, int currU, int currV, int orgCol, int newCol) {
		if(currU < 0 || currV < 0 || currU >= arr.length || currV >= arr[currU].length || arr[currU][currV] != orgCol || arr[currU][currV] == newCol) {
			return;
		}
		
		arr[currU][currV] = newCol;
		dfs(arr, currU-1, currV, orgCol, newCol);
		dfs(arr, currU, currV+1, orgCol, newCol);
		dfs(arr, currU+1, currV, orgCol, newCol);
		dfs(arr, currU, currV-1, orgCol, newCol);
	}
}
