package KNIGHTS_TOUR_Problem;

public class Main {
	public static void main(String[] args) {
		int[][] grid1 = {
				{0,3,6},
				{5,8,1},
				{2,7,4}
		};
		
		int[][] grid2 = {
				{0, 11, 2, 17, 20},
				 {3, 16, 19, 12, 7},
				 {10, 1, 6, 21, 18},
				 {15, 4, 23, 8, 13}, 
				 {24, 9, 14, 5, 22}
		};
		
		Main m = new Main();
		System.out.println("Output: " + m.knightTour(grid1, 0, 0, 3, 0));
		System.out.println("Output: " + m.knightTour(grid2, 0, 0, 5, 0));
	}
	
	public boolean knightTour(int[][] grid, int row, int col, int n, int expVal) {
		if(row < 0 || col < 0 || col >= n || row >= n || grid[row][col] != expVal) {
			return false;
		}
		
		if(expVal == n*n - 1) {
			return true;
		}
		
		boolean ans1 = knightTour(grid, row-2, col+1, n, expVal+1);
		boolean ans2 = knightTour(grid, row-1, col+2, n, expVal+1);
		boolean ans3 = knightTour(grid, row+1, col+2, n, expVal+1);
		boolean ans4 = knightTour(grid, row+2, col+1, n, expVal+1);
		boolean ans5 = knightTour(grid, row+2, col-1, n, expVal+1);
		boolean ans6 = knightTour(grid, row+1, col-2, n, expVal+1);
		boolean ans7 = knightTour(grid, row-1, col-2, n, expVal+1);
		boolean ans8 = knightTour(grid, row-2, col-1, n, expVal+1);
		
		return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
	}
}