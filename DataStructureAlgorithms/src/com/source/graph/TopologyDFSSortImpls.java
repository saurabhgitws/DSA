package com.source.graph;

import java.util.ArrayList;
import java.util.Stack;

class DVertex{
	int label;
	ArrayList<Integer> adjecentVertex;
	
	public DVertex(int l) {
		this.label = l;
		adjecentVertex = new ArrayList<Integer>();
	}
	
	
}

class TopologyDFSSort{
	
	int isVisited[];
	int numberOfVertex;
	DVertex mVertex[];
	
	public TopologyDFSSort(int maxVertex) {
		this.numberOfVertex = maxVertex;
		isVisited = new int[numberOfVertex];
		
		mVertex = new DVertex[numberOfVertex];
		
		for(int i=0;i<numberOfVertex;i++) {
			mVertex[i] = new DVertex(i);
		}
	}
	
	public void addEdge(int start,int end) {
		mVertex[start].adjecentVertex.add(end);
	}
	
	private void doDFS(int ver,Stack stk) {
		isVisited[ver]=1;
		for(int adj : mVertex[ver].adjecentVertex) {
			if(isVisited[adj]==0)
			   doDFS(adj,stk);
		}
		
		stk.add(ver);
		
	}
	
	public void topologySortDFS() {
		
		int topology[] = new int[numberOfVertex];
		int index =0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<numberOfVertex;i++) {
			if(isVisited[i]==0) {
				doDFS(i,stack);
			}
		}
		
		while(!stack.isEmpty()) {
			topology[index++] = stack.pop();
		}
		System.out.println("\n topologySortDFS \n");
		for(int i=0;i<numberOfVertex;i++) {
			System.out.print(topology[i]+" ");
		}
	}
	
}

public class TopologyDFSSortImpls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologyDFSSort  mtoTopologyBFSSort = new TopologyDFSSort(6);
        mtoTopologyBFSSort.addEdge(2, 3);
        mtoTopologyBFSSort.addEdge(3, 1);
        mtoTopologyBFSSort.addEdge(4, 0);
        mtoTopologyBFSSort.addEdge(4, 1);
        mtoTopologyBFSSort.addEdge(5, 0);
        mtoTopologyBFSSort.addEdge(5, 2);
        
        mtoTopologyBFSSort.topologySortDFS();
        
	}

}

/*
topologySortDFS 

5 4 2 3 1 0 


*/
