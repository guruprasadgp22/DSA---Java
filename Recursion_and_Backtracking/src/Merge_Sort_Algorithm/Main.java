package Merge_Sort_Algorithm;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,6,7,3,4,5,9,2};
		Main m = new Main();
		m.divide(arr, 0, 7);
		
		for(int ele:arr) {
			System.out.print(ele + " ");
		}
	}
	
	public void divide(int[] arr, int start, int end) {
		if(start < end) {
			int mid = start + (end - start)/2;
			divide(arr, start, mid);
			divide(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	public void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid+1;
		int k = 0;
		int m = mid;
		int n = end;
		int[] ans = new int[end-start+1];
		
		while(i <= m && j <= n) {
			if(arr[i] < arr[j]) {
				ans[k] = arr[i];
				i++;
				k++;
			} else {
				ans[k] = arr[j];
				j++;
				k++;
			}
		}
		
		while(i <= m) {
			ans[k] = arr[i];
			k++;
			i++;
		}
		
		while(j <= n) {
			ans[k] = arr[j];
			k++;
			j++;
		}
		
		for(int p=0;p<ans.length;p++) {
			arr[start+p] = ans[p];
		}
	}
}
