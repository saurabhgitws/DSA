package com.source.utils;
class Qz<E>{
	int front;
	int rear;
	int count;
	E[] array;
	int MAX=1000;
	public Qz(){
		array= (E[])new Object[MAX];
		front=0;
	    rear=-1;
	    count=0;
	}
	
	public E add(E val){
		if(rear == MAX-1) // deal with wraparound
			rear = -1;
			array[++rear] = val; // increment rear and
			count++;
		return val;
	}
	
	public E remove(){
		E temp = array[front++]; // get value and incr front
		if(front == MAX) // deal with wraparound
		front = 0;
		count--; // one less item
		return temp;
	}
	
	/*public E peek(){
		if(count==0)return null;
		if(count>0){
		
				--count;
		return array[front++];
		}*/
		
	
	
	public boolean isEmpty(){
		if(count==0)
			return true;
		else
			return false;
	}
	
	public int size(){
		return count;
	}
}

class S<T>{
	int MAX=1000;
	int size=0;
	int top=-1;
	@SuppressWarnings("unchecked")
	T[] array = (T[]) new Object[MAX];
	
	public void push(T value){
		if(size<MAX){
			array[++top]=value;
			size++;
		}
	}
	
	public T peek(){
		if(size==0)return null;
		T t = array[top];
		return t;
	}
	
	public T pop(){
		if(size==0)return null;
		T t = array[top];
		--top;
		--size;
		return t;
	}
	
	public boolean isEmpty(){
		if(size==0)return true;
		return false;
	}
	
	public int size(){
		
		return size;
	}

}

public class StackQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
