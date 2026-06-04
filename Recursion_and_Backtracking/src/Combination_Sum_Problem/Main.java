package Combination_Sum_Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
	HashSet<List<Integer>> unique = new HashSet<>();
	
	public static void main(String[] args) {
		int[] arr = {1,2,4};
		int target = 8;
		
		Main m = new Main();
		List<List<Integer>> result = m.combinationSum(arr, target);
		
		for(List<Integer> ls: result) {
			System.out.println(ls);
		}
	}
	
	public List<List<Integer>> combinationSum(int[] arr, int target) {
		int n = arr.length;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> comb = new ArrayList<>();
		combSum(arr, 0, n, result, comb , target);
		
		return result;
	}
	
	private void combSum(int[] arr, int idx, int n, List<List<Integer>> result, List<Integer> combination, int target) {
		if(target == 0) {
			if(!unique.contains(combination)) {
				unique.add(new ArrayList<>(combination));
				result.add(new ArrayList<>(combination));
			}
			return;
		}
		
		if(idx == n || target < 0) {
			return;
		}
		
		combination.addLast(arr[idx]);
		combSum(arr, idx+1, n, result, combination, target-arr[idx]);
		combSum(arr, idx, n, result, combination, target-arr[idx]);
		
		combination.removeLast();
		
		combSum(arr, idx+1, n, result, combination, target);
	}
}
