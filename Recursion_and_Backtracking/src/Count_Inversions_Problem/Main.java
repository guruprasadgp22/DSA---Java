package Count_Inversions_Problem;

public class Main {
	public static void main(String[] args) {
		int[] arr = {6,3,5,2,7};
		
		Main m = new Main();
		System.out.println("Brute Force approoach: " + m.countInversion(arr));
		
		System.out.println("Optimal approach: " + m.mergeSort(arr, 0, 4));
	
	}
	
	public int mergeSort(int[] arr, int start, int end) {
		int count = 0;
		
		if(start < end) {
			int mid = start + (end - start)/2;
			count += mergeSort(arr, start, mid);
			count += mergeSort(arr, mid + 1, end);
			count += merge(arr, start, mid, end);
		}
		
		return count;
	}
	
	public int merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid+1;
		int k = 0;
		int m = mid;
		int n = end;
		int count = 0;
		
		int[] temp = new int[end - start + 1];
		
		while(i <= m && j <= n) {
			if(arr[i] <=  arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			} else {
				temp[k] = arr[j];
				k++;
				j++;
				count += (mid - i + 1);
			}
		}
		
		while(i <= m) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		
		while(j <= n) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		
		for(int p=0; p<temp.length;p++) {
			arr[p+start] = temp[p];
		}
		
		return count;
	}
	
//	Approach 1 
	public int countInversion(int[] arr) {
		int count = 0;
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i] > arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
