package Print_all_Subsets_I_and_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		int i = 0;
		
		
		Main m = new Main();
		m.subSet(arr, i, curr, result);
		
		for(List<Integer> res: result) {
			System.out.println(res);
		}
		System.out.println("----------- End -------------");
		
		int[] nums = {1,2,1};
		List<Integer> current = new ArrayList<>();
		List<List<Integer>> output = new ArrayList<>();
		int j = 0;
		
		Arrays.sort(nums);
		m.subSetDuplicate(nums, j, current, output);
		for(List<Integer> res: output) {
			System.out.println(res);
		}
	}
	
	public void subSetDuplicate(int[] nums, int i, List<Integer> current, List<List<Integer>> output) {
		if(i == nums.length) {
			output.add(new ArrayList<>(current));
			return;
		}
		
		current.add(nums[i]);
		subSetDuplicate(nums, i+1, current, output);
		
		current.removeLast();
		
		int index = i+1;
		
		while(index < nums.length && nums[index] == nums[index-1]) {
			index++;
		}
		
		subSetDuplicate(nums, index, current, output);
	}
	public void subSet(int[] arr, int i, List<Integer> curr, List<List<Integer>> result) {
		if(i == arr.length) {
			result.add(new ArrayList<>(curr));
			return;
		}
		
		curr.add(arr[i]);
		subSet(arr, i+1, curr, result);
		
		curr.removeLast();
		subSet(arr, i+1, curr, result);
	}
}
