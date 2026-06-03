package Permutations_of_an_Array_and_String;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<int[]> result = new ArrayList<>();
		
		Main m = new Main();
		m.permutation(arr, 0, result);
		
		for(int[] ar: result) {
			for(int i=0;i<ar.length;i++) {
				System.out.print(ar[i] + " ");
			}
			System.out.println();
		}
	}
	
	public void permutation(int[] arr, int index, List<int[]> result) {
		if(index == arr.length) {
			result.add(arr.clone());
			return;
		}
		
		for(int i=index;i<arr.length;i++) {
			swap(arr,index, i);
			permutation(arr, index+1, result);
			swap(arr, index, i);
		}
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
