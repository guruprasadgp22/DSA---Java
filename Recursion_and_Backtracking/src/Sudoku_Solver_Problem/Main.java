package Sudoku_Solver_Problem;

public class Main {
	public static void main(String[] args) {
		int[][] board = new int[9][9];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				board[i][j] = 0;
			}
		}
		
		Main m = new Main();
		m.solveSuduko(board, 0, 0);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean solveSuduko(int[][] board, int row, int col) {
		if(row == 9) {
			return true;
		}
		
		int nextRow = row;
		int nextCol = col + 1;
		if(nextCol == 9) {
			nextCol = 0;
			nextRow = row + 1;
		}
		
		if(board[row][col] != 0) {
			return solveSuduko(board, nextRow, nextCol);
		}
		
		for(int digit = 1;digit <= 9; digit++) {
			if(isSafe(board, row, col, digit)) {
				board[row][col] = digit;
				
				if(solveSuduko(board, nextRow, nextCol)) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		
		return false;
	}

	private boolean isSafe(int[][] board, int row, int col, int digit) {
		for(int i=0;i<9;i++) {
			if(board[row][i] == digit) {
				return false;
			}
		}
		
		for(int i=0;i<9;i++) {
			if(board[i][col] == digit) {
				return false;
			}
		}
		
		int startRow = (row/3) * 3;
		int startCol = (col/3) * 3;
		
		for(int i=startRow; i<=startRow+2;i++) {
			for(int j=startCol; j <= startCol+2;j++) {
				if(board[i][j] == digit) {
					return false;
				}
			}
		}
		
		
		return true;
	}
}
