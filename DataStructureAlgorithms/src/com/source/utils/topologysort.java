package com.source.utils;
import java.util.Scanner;


public class topologysort {

	/**
	 * @param args
	 */
	static int numberOfEdges;
	static int numberOfNode;
	static int matrix[][];
	static Vertextp mVertextp[];
	static int  mStack[];
	static int top;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		numberOfNode=sc.nextInt();
		numberOfEdges=sc.nextInt();
		matrix=new int [numberOfNode+1][numberOfNode+1];
		mVertextp=new Vertextp[numberOfNode+1];
		
		for (int i = 1; i <= numberOfNode; i++) {
			mVertextp[i] = new Vertextp(i, false,numberOfNode);
		}
		for(int i=1;i<=numberOfEdges;i++){
			int start=sc.nextInt();
			int end=sc.nextInt();
			addEdges(start,end);
		}

		print();
		WorkOrder();
		
	}

	static void addEdges(int start,int end){
		matrix[start][end]=1;
		mVertextp[start].addChild(end);
	}
	
	static void print(){
		for(int i=1;i<=numberOfNode;i++){
			System.out.println();
			for(int j=1;j<=numberOfNode;j++){
				System.out.print(matrix[i][j]+" ");
			}
		}
		System.out.println();
	}
	

	
	static void doDfs(int v){

		mVertextp[v].isVisited=true;
		for(int i=0;i<mVertextp[v].childIndex;i++){
			if(mVertextp[mVertextp[v].child[i]].isVisited==false){
				doDfs(mVertextp[v].child[i]);
			}
		}
		mStack[++top]=v;
	}

	
	static void WorkOrder(){
		mStack=new int[numberOfNode];
		top=-1;
		for(int i=1;i<=numberOfNode;i++){
			if(mVertextp[i].isVisited==false)
			doDfs(mVertextp[i].lable);
		}
		
		for(int j=top;j>=0;j--){
			System.out.println(mStack[j]);
		}
	}
	
}
class Vertextp{
	public int lable;
	public boolean isVisited;
	public int childIndex;
	public int child[];
	public Vertextp(int l,boolean visited,int maxChild){
		child=new int[maxChild];
		lable=l;
		childIndex=0;
		isVisited=visited;
	}
	
	public void addChild(int c){
		child[childIndex++]=c;
	}
}
