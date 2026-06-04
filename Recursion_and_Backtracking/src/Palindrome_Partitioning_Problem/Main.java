package Palindrome_Partitioning_Problem;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String str = "aab";
		List<List<String>> result = new ArrayList<>();
		List<String> current = new ArrayList<>();
		
		Main m = new Main();
		m.getAllParts(str, current, result);
		
		for(List<String> ls: result) {
			System.out.println(ls);
		}
	}
	
	public void getAllParts(String s, List<String> current, List<List<String>> result) {
		if(s.length() == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		
		for(int i=0;i<s.length();i++) {
			String part = s.substring(0, i+1);
			
			if(isPalindrome(part)) {
				current.addLast(part);
				getAllParts(s.substring(i+1), current, result);
				current.removeLast();
			}
		}
	}

	private boolean isPalindrome(String part) {
		int left = 0;
		int right = part.length()-1;
		
		while(left < right) {
			if(part.charAt(left) != part.charAt(right)) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
}