package com.source.sorting;

import java.util.Random;

public class MergeSortImpl {

	static int size =9;
	static int data[] = new int[size];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		input(data);
		print(data);
		mergeSort(data,size);
		print(data);

	}
	
	
	public static void mergeSort(int arr[],int len) {
		
		
		if(len <2) return;
		
		int mid =(len)/2;
		int left_arr[] = new int[mid];
		int right_arr[] = new int[len-mid];
		int k=0;
		for(int i=0;i<len;i++) {
			if(i<mid) {
				left_arr[i] = arr[i];
			}else {
				right_arr[k++] = arr[i];
			}
		}
		
		mergeSort(left_arr, mid);
		mergeSort(right_arr,len-mid);
		
		merge(left_arr, right_arr, arr, mid, len-mid);
		
		
	}
	
	public static void merge(int left_arr[],int right_arr[],int arr[],int left_length,int right_lenght) {
		int l = 0;
		int r =0;
		int i=0;
		
		while(l<left_length &&  r < right_lenght) {
			if(left_arr[l] < right_arr[r]) {
				arr[i++] = left_arr[l++];
			}else {
				arr[i++] = right_arr[r++];
			}
		}
		
		while(l<left_length) {
			arr[i++] = left_arr[l++];
		}
		
		while(r<right_lenght) {
			arr[i++] = right_arr[r++];
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
