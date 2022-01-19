package com.source.heap;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

class Heap{
	int mHeap[];
	int size;
	int Max;
	
	public Heap() {
	
	}
		
	public Heap(int max) {
		this.Max = max;
		this.size=0;
		mHeap = new int[Max];
	}
	
	private  void init(int arr[]) {
		this.Max = arr.length;
		this.size=0;
		mHeap = new int[Max];
	}
	
	public void insert(int item) {
		if(size<Max) {
			mHeap[size]=item;
			heapifyUp(size);
			size++;
		}
	}
	
	public int remove() {
		int item =-1;
		if(size>=0) {
		 item = mHeap[0];
		 mHeap[0]= mHeap[size-1];
		 size--;
		 heapifyDown(0);
		}
		return item;
	}
	
	
	private void heapifyUp(int index) {

		if(index > 0 && mHeap[index] < mHeap[(index-1)/2]){
			int temp = mHeap[index];
			int parent = (index-1)/2;
			mHeap[index]= mHeap[parent];
			mHeap[parent] = temp;
			index = parent;
		}
		
	}
	
	private void heapifyDown(int index) {
		int leftChild = (index*2+1);
		int rightChild = (index*2+2);
		
		int smallest = index;
		
		if(leftChild < size && mHeap[leftChild] <= mHeap[smallest]) {
			smallest = leftChild;
		}
		
		if(rightChild < size && mHeap[rightChild] <= mHeap[smallest]) {
			smallest = rightChild;
		}
		
		if(smallest!=index) {
			int temp = mHeap[smallest];
			mHeap[smallest] = mHeap[index];
			mHeap[index]= temp;
			heapifyDown(smallest);
		}
		
	}
	
	public void printHeap() {
		System.out.println();
		for(int i=0;i<size/2;i++) {
			System.out.println("\n  Parent "+mHeap[i]);
			if((2*i+1) <size)
			System.out.print(" left:"+mHeap[2*i+1]);
			if((i*2+2) <size)
			System.out.print(" right:"+mHeap[i*2+2]);
		}
	}
	
	public void heapSort(int arr[]) {
		init(arr);
		for(int i=0;i<Max;i++) {
			insert(arr[i]);;
		}
		
		for(int i=size/2;i>=0;i--) {
			heapifyDown(i);
		}
		System.out.println();
		for(int i=0;i<Max;i++) {
			System.out.print(remove()+" ");
		}
		System.out.println();	
	}
}

public class HeapImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Heap heaps = new Heap(6);
		heaps.insert(1);
		heaps.insert(12);
		heaps.insert(9);
		heaps.insert(5);
		heaps.insert(6);
		heaps.insert(10);
		
		heaps.printHeap();
		System.out.println();
		for(int i=0;i<6;i++) {
			System.out.print(heaps.remove()+" ");
		}
		
		
		int arr[] = {1,12,9,5,6,10};
		Heap heap = new Heap();
		heap.heapSort(arr);
		
		
	}

}

/*
Parent 1
left:5 right:9
 Parent 5
left:12 right:6
 Parent 9
left:10
1 5 6 9 10 12 
1 5 6 9 10 12 
*/
