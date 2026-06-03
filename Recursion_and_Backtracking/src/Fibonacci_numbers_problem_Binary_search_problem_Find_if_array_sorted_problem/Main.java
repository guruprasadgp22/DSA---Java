package Fibonacci_numbers_problem_Binary_search_problem_Find_if_array_sorted_problem;

public class Main {
	public static void main(String[] args) {
		int n = 6;
		
		Main m = new Main();
		System.out.println("Fibanacci: " + m.fibbonacci(n)); //0,1,1,2,3,5,8,13,....
		
		int[] arr = {1,2,3,4,5,6};
		System.out.println("Array Sorted: " + m.arraySorted(arr, n));
		
		System.out.println("Binary Search: " + m.binarySearch(arr, 0, 5, 3));
		
	}
	
	public int fibbonacci(int n) {
		if(n < 2) {
			return n;
		}
		
		return fibbonacci(n-1) + fibbonacci(n-2);
	}
	
	public boolean arraySorted(int[] arr, int n) {
		if(n == 0 || n == 1) {
			return true;
		}
		
		return arr[n-1] >= arr[n-2] && arraySorted(arr, n-1);
	}
	
	public int binarySearch(int[] arr, int start, int end, int k) {
		if(start > end) {
			return -1;
		}
		
		int mid = start + (end - start)/2;
		
		while(start < end) {
			if(arr[mid] == k) {
				return mid;
			}
			
			if(arr[mid] < k) {
				return binarySearch(arr, mid + 1, end, k);
			} else {
				return binarySearch(arr, start, mid - 1, k);
			}
		}
		
		return -1;
	}
}
