package com.source.searching;

public class BinarySearchImpl {

	static int data[] = {11,33,44,66,77,88,99,100,200,1000};
	static int size =10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res = binarySearch(data, 0, size-1, 199);
		if(res == -1) {
			System.out.println("key not found");
		}else {
			System.out.println("Key found");
		}	
		
	}
	
	public static int binarySearch(int arr[],int low,int high,int key) {
		if(high >= low) {
			int mid =(low)+(high-low)/2;
			if(key == arr[mid]) {
				return mid;
			}
			
			if(key < arr[mid]) 
				return binarySearch(arr, low, mid-1, key);
			else
				return binarySearch(arr, mid+1, high, key);
		}
		return -1;
	}

}
