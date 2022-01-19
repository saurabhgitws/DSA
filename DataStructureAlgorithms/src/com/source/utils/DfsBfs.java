package com.source.utils;
import java.util.Scanner;




public class DfsBfs {

	/**
	 * @param args
	 */
	static int numberOfEdges;
	static int numberOfNode;
	static int matrix[][];
	static Vertex mVertex[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		numberOfNode=sc.nextInt();
		numberOfEdges=sc.nextInt();
		matrix=new int [numberOfNode+1][numberOfNode+1];
		mVertex=new Vertex[numberOfNode+1];
		for(int i=1;i<=numberOfEdges;i++){
			int start=sc.nextInt();
			int end=sc.nextInt();
			addEdges(start,end);
		}
		print();
		
	}

	static void addEdges(int start,int end){
		matrix[start][end]=1;
		matrix[end][start]=1;
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
	
	static int getAdjcVertex(int v){
		for(int i=1;i<=numberOfNode;i++){
			if(matrix[v][i]==1 && mVertex[i].isVisited==false){
				return i;
			}
		}
		return -1;
	}
	
	static void doDfs(int start){

		for (int i = 1; i <= numberOfNode; i++) {
			mVertex[i] = new Vertex(i, false);
		}

		System.out.println(" doDfs ");
		int stack[] = new int[numberOfNode];
		int top = -1;

		stack[++top] = start;
		mVertex[start].isVisited = true;
		System.out.println(mVertex[start].lable);

		while (top>=0) {
			int v = stack[top];
			int v1 = getAdjcVertex(v);
			if (v1 == -1) {
				--top;
			} else {
				stack[++top] = v1;
				mVertex[v1].isVisited = true;
				System.out.println(mVertex[v1].lable);

			}
		}

	}
	
	static void doBFS(int start) {
		for (int i = 1; i <= numberOfNode; i++) {
			mVertex[i] = new Vertex(i, false);
		}

		System.out.println(" doBfs ");

		int queue[] = new int[numberOfNode];
		int front = -1;
		int rear = -1;

		rear = (rear + 1) % numberOfNode;
		queue[rear] = start;
		mVertex[start].isVisited = true;
		System.out.println(mVertex[start].lable);

		while (rear != front) {
			front = (front + 1) % numberOfNode;
			int v = queue[front];
			int v1;
			while ((v1 = getAdjcVertex(v)) != -1) {
				rear = (rear + 1) % numberOfNode;
				queue[rear] = v1;
				mVertex[v1].isVisited = true;
				System.out.println(mVertex[v1].lable);

			}
		}

	}
	
     static void doDfsBfs(){
 		doDfs(1);
 		doBFS(1);

	}
	
	static void findCycle(){
		
	}
	
}
class Vertex{
	public int lable;
	public boolean isVisited;
	
	public Vertex(int l,boolean visited){
		lable=l;
		isVisited=visited;
	}
}
