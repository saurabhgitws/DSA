package com.source.sorting;

import java.util.Random;

public class SelectionSortImpl {


	static int size =9;
	static int data[] = new int[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		input(data);
		print(data);
		selectionSort(data);
		print(data);

	}
	
	
	public static void selectionSort(int arr[]) {
		
		for(int i=0;i< arr.length;i++) {
			int min_index =i;
			for(int j=i;j<arr.length;j++) {
				if(arr[min_index] > arr[j]) {
				  min_index = j;
				}
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
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
