package N_Queens_Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char[][] board = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = '.';
			}
		}
		
		List<List<String>> result = new ArrayList<>();
		int row = 0;
		
		Main m = new Main();
		m.nQueenSolver(board, row, n, result);
		
		for(List<String> ls: result) {
			System.out.println(ls);
		}
		
		sc.close();
	}
	
	public void nQueenSolver(char[][] board, int row, int n, List<List<String>> result) {
		if(row == n) {
			List<String> ans = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				ans.add(new String(board[i]));
			}
			
			result.add(ans);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(isSafe(board, row, i, n)) {
				board[row][i] = 'Q';
				nQueenSolver(board, row+1, n, result);
				board[row][i] = '.';
			}
		}
	}
	
	private boolean isSafe(char[][] board, int row, int col, int n) {
		for(int i=0;i<n;i++) {
			if(board[row][i] == 'Q') {
				return false;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		
		for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		for(int i=row, j=col; i>=0 && j<n; i--, j++) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}
}
