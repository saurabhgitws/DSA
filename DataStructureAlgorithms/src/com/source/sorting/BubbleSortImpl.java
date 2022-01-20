package com.source.sorting;

import java.util.Random;

public class BubbleSortImpl {

	static int size =9;
	static int data[] = new int[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		input(data);
		print(data);
		bubbleSort(data);
		print(data);

	}
	
	
	public static void bubbleSort(int arr[]) {
		
		for(int i=0;i< arr.length-1;i++) {
			for(int j=0;j< arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
				  int temp = arr[j];
				  arr[j] = arr[j+1];
				  arr[j+1] = temp;
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
