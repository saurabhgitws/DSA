package com.source.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TVertex{
	int lable;
	ArrayList<Integer> adjecentVertex;
	
	public TVertex(int l) {
		this.lable = l;
		adjecentVertex = new ArrayList<Integer>();
	}
}

class TopologySort{
	
	int numberOfVertex;
	TVertex mVertext[];
	
	public TopologySort(int maxVertex) {
	    this.numberOfVertex = maxVertex;
	    mVertext = new TVertex[numberOfVertex];
	    for(int i=0;i<numberOfVertex;i++) {
	    	mVertext[i]= new TVertex(i);
	    }
	}
	
	public void addEdge(int start,int end) {
		mVertext[start].adjecentVertex.add(end);
	}
	
	public void topologySortBFS() {
		
		int inDegree[] = new int[numberOfVertex];
		int topologyArr[] = new int[numberOfVertex];
		int index =0;
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0;i<numberOfVertex;i++) {
			for(int adj : mVertext[i].adjecentVertex) {
				inDegree[adj]++;
			}
		}
		
		for(int i=0;i<numberOfVertex;i++) {
			if(inDegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int ver = queue.poll();
			for(int adj: mVertext[ver].adjecentVertex) {
				inDegree[adj]--;
				if(inDegree[adj]==0) {
					queue.add(adj);
				}
			}
			
			topologyArr[index++]= ver;
		}
		
		System.out.println("\ntopologySortBFS \n");
		for(int i=0;i<numberOfVertex;i++) {
			System.out.print(topologyArr[i]+" ");
		}
	}
	
	public void topologySortDFS() {
		int isVisited[] = new int[numberOfVertex];
		int topologyArr[] = new int[numberOfVertex];
		Stack<Integer> stack = new Stack<Integer>();
		
		int index =0;
		
		for(int i=0;i<numberOfVertex;i++) {
			if(isVisited[i]==0) {
				doDFS(i, isVisited, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			topologyArr[index++] = stack.pop();
		}
		
		System.out.println("\ntopologySortDFS \n");
		for(int i=0;i<numberOfVertex;i++) {
			System.out.print(topologyArr[i]+" ");
		}
		
	}
	
	private void doDFS(int ver,int isVisted[],Stack stack) {
		isVisted[ver]=1;
		
		for(int adj : mVertext[ver].adjecentVertex) {
			if(isVisted[adj]==0) {
				doDFS(adj, isVisted, stack);
			}
		}
		
		stack.add(ver);
	}
	
}

public class TopologySortImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologySort  mtoTopologySort = new TopologySort(6);
		mtoTopologySort.addEdge(2, 3);
		mtoTopologySort.addEdge(3, 1);
		mtoTopologySort.addEdge(4, 0);
		mtoTopologySort.addEdge(4, 1);
		mtoTopologySort.addEdge(5, 0);
		mtoTopologySort.addEdge(5, 2);
        
		
		mtoTopologySort.topologySortBFS();
		mtoTopologySort.topologySortDFS();
	}

}


/*

topologySortBFS 

4 5 0 2 3 1 
 
topologySortDFS 

5 4 2 3 1 0 


*/
