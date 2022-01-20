package com.source.sorting;

import java.util.Random;

public class QuickSortImpl {

	static int size =9;
	static int data[] = new int[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		input(data);
		print(data);
		quickSort(data,0,size-1);
		print(data);

	}
	
	
	public static void quickSort(int arr[],int low,int high) {
		
		if(low< high) {
			int pivot = partition(arr, low, high);
			
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
		}
	}
	
	public static int partition(int arr[],int low,int high) {
		int pivot = arr[high];
		int i=low-1;
		
		
		for(int j=low;j< high;j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i] ;
				arr[i] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}
	public static void input(int arr[]) {
		Random random = new Random();
		for(int i=0;i<arr.length;i++) {
			int randomInteger = random.nextInt(100);
			arr[i] = randomInteger;
		}
	}
	
	public static void print(int arr[]) {
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
