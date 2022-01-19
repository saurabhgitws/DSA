package com.source.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BVertex{
	int label;
	ArrayList<Integer> adjcentVertex;
	public BVertex(int l) {
		this.label = l;
		adjcentVertex = new ArrayList<Integer>();
	}
	
}

class TopologyBFSSort{
	
	int numberOfVertex;
	
	int inDegree[];
	BVertex mVertex[];
	
	
	
	public TopologyBFSSort(int maxVertex) {
		
		this.numberOfVertex = maxVertex;
		
		mVertex = new BVertex[numberOfVertex];
		for(int i=0;i<numberOfVertex;i++) {
			mVertex[i] = new BVertex(i);
		}
		
		inDegree = new int[numberOfVertex];
		
	}
	
	public void addEdge(int start,int end) {
		mVertex[start].adjcentVertex.add(end);
	}
	
	public void topologySortBFS() { // int numMaxEdge ,TVetex mVertexArr[]
		
		int topology[];
		topology = new int[numberOfVertex];
		int index=0;
		
		//update inDegree of each vertex
		for(int i=0;i<numberOfVertex;i++) {
			for(int v : mVertex[i].adjcentVertex) {
				inDegree[v]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0;i<numberOfVertex;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int adj : mVertex[v].adjcentVertex) {
				inDegree[adj]--;
				if(inDegree[adj]==0) {
					queue.add(adj);
				}
			}
			topology[index++] = v;
		}
		
		
		System.out.println("\n topologySortBFS \n");
		for(int i=0;i<numberOfVertex;i++) {
			System.out.print(topology[i]+" ");
		}
	} 
}


public class TopologyBFSSortImpls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TopologyBFSSort mtoTopologyBFSSort = new TopologyBFSSort(6);
        mtoTopologyBFSSort.addEdge(2, 3);
        mtoTopologyBFSSort.addEdge(3, 1);
        mtoTopologyBFSSort.addEdge(4, 0);
        mtoTopologyBFSSort.addEdge(4, 1);
        mtoTopologyBFSSort.addEdge(5, 0);
        mtoTopologyBFSSort.addEdge(5, 2);
        
        mtoTopologyBFSSort.topologySortBFS();
        
	}

}
/*
topologySortBFS 

4 5 0 2 3 1 

*/
