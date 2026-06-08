package Number_of_Islands;

public class Main {
	public static void main(String[] args) {
		int[][] grid = {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,1}
		};
		
		Main m = new Main();
		
		System.out.println(m.isLand(grid));
	}
	
	public int isLand(int[][] grid) {
		int isLands = 0;
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(!visited[i][j] && grid[i][j] == 1) {
					DFS(i, j, visited, grid);
					isLands++;
				}
			}
		}
		
		return isLands;
	}
	
	public void DFS(int i, int j, boolean visited[][], int grid[][]) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true) {
			return;
		}
		
		visited[i][j] = true;
		DFS(i-1, j, visited,grid);
		DFS(i, j+1, visited,grid);
		DFS(i+1, j, visited,grid);
		DFS(i, j-1, visited,grid);
	}
}