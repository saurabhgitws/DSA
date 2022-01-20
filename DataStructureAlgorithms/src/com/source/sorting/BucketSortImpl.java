package com.source.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BucketSortImpl {

	
	static int data[] = {100,10,50,70,50,40,80,20,60};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		bucketSort(data);
		
		bucketSort2(data);

	}
	
	public static void bucketSort(int arr[]) {
		
		int min_value = Integer.MAX_VALUE;
		int max_value = Integer.MIN_VALUE;
		
		for(int a: arr) {
			if(a< min_value) {
				min_value =a;
			}
			if(a > max_value) {
				max_value = a;
			}
		}
		
		int numberOfBuckets = (int)Math.ceil(Math.sqrt(arr.length));
		
		ArrayList<Integer> [] mBuckets = new ArrayList[numberOfBuckets];
		
		for(int i=0;i< numberOfBuckets;i++) {
			mBuckets[i] = new ArrayList<Integer>();
		}
		
		for(int value : arr) {
			int bucketIndex = (int)Math.ceil((value*numberOfBuckets)/max_value);
			if(bucketIndex==0)bucketIndex = bucketIndex+1;
			mBuckets[bucketIndex-1].add(value);
		}
		
		for(int i=0;i< numberOfBuckets;i++) {
			System.out.println("\nbucket "+i);
			for(int val: mBuckets[i]) {
				System.out.print(val+" ");
			}
		}
		
		for(int i=0;i< numberOfBuckets;i++) {
		   Collections.sort(mBuckets[i]);
		}

		for(int i=0;i< numberOfBuckets;i++) {
			System.out.println("\nbucket "+i);
			for(int val: mBuckets[i]) {
				System.out.print(val+" ");
			}
		}
		
		int index=0;
		
		
		for(int i=0;i< numberOfBuckets;i++) {
			for(int val: mBuckets[i]) {
				arr[index++] = val;
			}
		}
		
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
   public static void bucketSort2(int arr[]) {
		
		int min_value = Integer.MAX_VALUE;
		int max_value = Integer.MIN_VALUE;
		
		for(int a: arr) {
			if(a< min_value) {
				min_value =a;
			}
			if(a > max_value) {
				max_value = a;
			}
		}
		
		/* number of buckets */
	    int numberOfBuckets = max_value - min_value + 1;
		
		
		
		ArrayList<Integer> [] mBuckets = new ArrayList[numberOfBuckets];
		
		for(int i=0;i< numberOfBuckets;i++) {
			mBuckets[i] = new ArrayList<Integer>();
		}
		
		for(int value : arr) {
			int bucketIndex = (value - min_value) / numberOfBuckets;
			
			mBuckets[bucketIndex].add(value);
		}
		
		for(int i=0;i< numberOfBuckets;i++) {
			System.out.println("\nbucket "+i);
			for(int val: mBuckets[i]) {
				System.out.print(val+" ");
			}
		}
		
		for(int i=0;i< numberOfBuckets;i++) {
		   Collections.sort(mBuckets[i]);
		}

		for(int i=0;i< numberOfBuckets;i++) {
			System.out.println("\nbucket "+i);
			for(int val: mBuckets[i]) {
				System.out.print(val+" ");
			}
		}
		
		int index=0;
		
		
		for(int i=0;i< numberOfBuckets;i++) {
			for(int val: mBuckets[i]) {
				arr[index++] = val;
			}
		}
		
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
