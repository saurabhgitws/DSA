package com.source.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
	int numberofVertex;
	
	Vertex mVertex[];
	
	int Matrix[][];
	
	public Graph(int maxEdge) {
		this.numberofVertex = maxEdge+1;
		
		Matrix = new int[numberofVertex][numberofVertex];
		
		mVertex = new Vertex[numberofVertex];
		
		for(int i=1;i<numberofVertex;i++) {
			mVertex[i] = new Vertex(i);
		}
	}
	
	public void addEdge(int start,int end) {
		Matrix[start][end] =1;
		Matrix[end][start] = 1;
	}
	
	public void doBFSRecursicvee(int start){
		System.out.println("\n doBFSRecursicvee \n");
		for(int i=1;i<numberofVertex;i++) {
			mVertex[i].isVisited = false;
		}
		
		Queue<Integer> queue= new LinkedList<Integer>();
		
		queue.add(start);
		mVertex[start].isVisited = true;
		System.out.print(mVertex[start].label+" ");
		while(!queue.isEmpty()){
			int ver = queue.poll();
			
			int v =-1; 
			while((v= adjecentVertex(ver))!=-1) {
				queue.add(v);
				mVertex[v].isVisited = true;
				System.out.print(mVertex[v].label+" ");

			}
			
		}
		
	}
	
	public void doDFSRecursive(int start) {
		System.out.println("\n doDFSRecursive \n");
		for(int i=1;i<numberofVertex;i++) {
			mVertex[i].isVisited = false;
		}
		
		Stack<Integer> stack= new Stack<Integer>();
		
		stack.add(start);
		mVertex[start].isVisited = true;
		System.out.print(mVertex[start].label+" ");
		while(!stack.isEmpty()) {
			int ver = stack.peek();
	
			int v=-1;
			if((v=adjecentVertex(ver))!=-1) {
				stack.add(v);
				mVertex[v].isVisited = true;
				System.out.print(mVertex[v].label+" ");

			}else {
				stack.pop();
			}
		}

	}
	
	private int adjecentVertex(int v) {
		for(int i=1;i<numberofVertex;i++) {
			if(Matrix[v][i]==1 && !mVertex[i].isVisited)
				return i;
		}
		
		return  -1;
	}
}

class Vertex{
	int label;
	boolean isVisited;
	
	public Vertex(int l) {
		this.label=l;
		this.isVisited = false;
	}
}
public class GraphImpls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph mgGraph = new Graph(12);
		
		mgGraph.addEdge(1, 2);
		mgGraph.addEdge(1, 3);
		mgGraph.addEdge(1, 4);
		mgGraph.addEdge(2, 5);
		mgGraph.addEdge(2, 6);
		mgGraph.addEdge(4, 7);
		mgGraph.addEdge(4, 8);
		mgGraph.addEdge(5, 9);
		mgGraph.addEdge(5, 10);
		mgGraph.addEdge(7, 11);
		mgGraph.addEdge(7, 12);
		
		mgGraph.doBFSRecursicvee(1);
		mgGraph.doDFSRecursive(1);
	}

}


/*
doBFSRecursicvee 

1 2 3 4 5 6 7 8 9 10 11 12 

doDFSRecursive 

1 2 5 9 10 6 3 4 7 11 12 8 

*/
