package Quick_Sort_Algorithm;

public class Main {
	public static void main(String[] args) {
		int[] arr = {9,3,2,1,5,3,4,2,7,};
		Main m = new Main();
		m.quickSort(arr, 0, 8);
		
		for(int ele: arr) {
			System.out.print(ele + " ");
		}
	}
	
	public void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int pivotIdx = partition(arr, start, end);
			quickSort(arr, start, pivotIdx-1);
			quickSort(arr, pivotIdx+1, end);
		}
	}

	private int partition(int[] arr,int start, int end) {
		int pivot = arr[end];
		int index = start-1;
		
		for(int i=start;i<end;i++) {
			if(arr[i] <= pivot) {
				index++;
				swap(arr, index, i);
			}
		}
		
		index++;
		swap(arr, index, end);
		return index;
	}	
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}