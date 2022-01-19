package com.source.heap;


class HeapSort{
	public void sort(int arr[]) {
		int n = arr.length;
		//Build Max Heap;
		
		for(int i = n/2-1 ;i>=0;i--) {
		  heapify(arr, n, i);
		}
		
		// HeapSort
		
		for(int i = n-1 ;i>=0;i--) {
			  int temp = arr[0];
			  arr[0] = arr[i];
			  arr[i] = temp;
			  heapify(arr, n, 0);
		}
			
	}
	
	public void heapify(int arr[],int n ,int i) {
		int leftchild = 2*i+1;
		int rightchild = 2*i+2;
		int largest = i;
		
		if(leftchild < n && arr[leftchild] > arr[largest]) {
			largest = leftchild;
		}
		
		if(rightchild < n && arr[rightchild] > arr[largest]) {
			largest = rightchild;
		}
		
		if(largest!=i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			heapify(arr, n, largest);
		}
	}
	
	
}

public class HeapSortImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  int arr[] = { 1, 12, 9, 5, 6, 10 };
		  
	      HeapSort hs = new HeapSort();
	      hs.sort(arr);
	  
	      System.out.println("Sorted array is");
	      printArr(arr);

	}
	
	  public static void printArr(int arr[]) {
		int n= arr.length;
		for(int i=0;i< n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
