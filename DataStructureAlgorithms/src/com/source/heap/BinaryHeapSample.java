package com.source.heap;

class BinaryHeap {
	int Max;
	int size;
	int mHeap[];
    int FRONT =1 ;   
	public BinaryHeap(int _max) {
		this.size = 0;
		this.Max = _max;
		mHeap = new int[Max+1];
	}

	public int parent(int index) {
		return (index ) / 2;
	}

	public int leftChild(int index) {
		return (2 * index );
	}

	public int rightChild(int index) {
		return (2 * index + 1);
	}

	public boolean isLeafNode(int index) {
      
		if ((index >= (size / 2)) && (index <=size)){
			   return true;
		}
			
	    return false;
	
	}

	public int peekOfHeap() {
		if (size > 0)
			return mHeap[FRONT];
		else
			return -1;

	}

	public int heapSize() {
		return size;
	}

	public void print() {
		if (size == 0) {
			System.out.println("\n print () :Binary Heap is Empty");
			return;
		}
		System.out.println();
		for (int i = 1; i <=size; i++) {
			System.out.print(mHeap[i] + ",");
		}
	}

	public void printHeap() {
		if (size == 0) {
			System.out.println("\n printHeap () :Binary Heap is Empty");
			return;
		}
		System.out.println();
		for (int i = 1; i <=size / 2; i++) {
			System.out.println("Parent " + mHeap[i] + " left Child :"
					+ mHeap[leftChild(i)] + " right Child "
					+ mHeap[rightChild(i)]);
		}

	}

	public void insert(int _item) {
		mHeap[size+1] = _item;
		heapyfyUp(size);
		size++;
		System.out.println(_item + " inserted");
	}

	public void delete() {
		if (size == 0) {
			System.out.println("\n delete(): Binary Heap  Empty");
			return;
		}
		int del = mHeap[FRONT];
		System.out.println("\n" + del + " deleted");
		mHeap[FRONT] = mHeap[size];
		size--;
		heapyfyDown(FRONT);

	}

	public void heapyfyUp(int index) {
		while ((mHeap[index] < mHeap[parent(index)])) {
			int temp = mHeap[index];
			mHeap[index] = mHeap[parent(index)];
			mHeap[parent(index)] = temp;
			index = parent(index);
		}
	}

	public void heapyfyDown(int index) {

		if ( (mHeap[index] > mHeap[leftChild(index)]
				|| mHeap[index] > mHeap[rightChild(index)])) {
			while (!isLeafNode(index) ) {
				if (mHeap[leftChild(index)] < mHeap[rightChild(index)]) {
					int temp = mHeap[index];
					mHeap[index] = mHeap[leftChild(index)];
					mHeap[leftChild(index)] = temp;
					index = leftChild(index);
				} else if (mHeap[leftChild(index)] > mHeap[rightChild(index)]) {
					int temp = mHeap[index];
					mHeap[index] = mHeap[rightChild(index)];
					mHeap[rightChild(index)] = temp;
					index = rightChild(index);
				}
			}
		}
	}

	public void minHeap() {
        for( int i = size/2 ;i>=1 ;i--){
        	heapyfyDown(i);
        	System.out.println(peekOfHeap());
        	
        }
	}
}

public class BinaryHeapSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryHeap binaryHeap = new BinaryHeap(15);
		binaryHeap.insert(22);
		binaryHeap.insert(15);
		binaryHeap.insert(17);
		binaryHeap.insert(11);
		binaryHeap.insert(9);
		binaryHeap.insert(18);
		binaryHeap.insert(20);
		binaryHeap.insert(40);
		binaryHeap.insert(32);
		binaryHeap.insert(35);
		binaryHeap.insert(19);
		binaryHeap.insert(21);
		binaryHeap.insert(3);
		binaryHeap.insert(7);
		binaryHeap.insert(41);
		//binaryHeap.print();
		binaryHeap.printHeap();
		
		//binaryHeap.minHeap();

		for(int i=0;i<=15;i++){
			binaryHeap.delete();
			binaryHeap.print();
		}
		

	}

}
