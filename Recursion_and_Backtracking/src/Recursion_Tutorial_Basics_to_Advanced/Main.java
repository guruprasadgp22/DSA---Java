package Recursion_Tutorial_Basics_to_Advanced;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Main m = new Main();
		System.out.println("Sum: " + m.sum(n));
		
		m.print(n);
		System.out.println();
		
		System.out.println("Factorial: " + m.factorial(n));
		sc.close();
	}
	
	public int sum(int n) {
		if(n == 1) {
			return n;
		}
		return n + sum(n-1);
	}
	
	public void print(int n) {
		if(n==0) {
			return;
		}
		System.out.print(n + " ");
		print(n-1);
	}
	
	public int factorial(int n) {
		if(n<2) {
			return n;
		}
		return n*factorial(n-1);
	}
}
