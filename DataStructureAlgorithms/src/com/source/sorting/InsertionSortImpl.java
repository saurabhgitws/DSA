package com.source.sorting;

import java.util.Random;

public class InsertionSortImpl {

	static int size =9;
	static int data[] = new int[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		input(data);
		print(data);
		insertionSort(data);
		print(data);

	}
	
	
	public static void insertionSort(int arr[]) {
		
		for(int i=1;i< arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
				  int temp = arr[j];
				  arr[j] = arr[j-1];
				  arr[j-1] = temp;
				}
			}
		}
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
