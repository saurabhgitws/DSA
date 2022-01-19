package com.source.utils;
public class Dijkstra {

	/**
	 * @param args
	 */
	static int graph[][];
	static int numberOfNodes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numberOfNodes=9;
		graph= new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };
		dijkstra(0);
		numberOfNodes=5;
		int graph1[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
               };
		mst(graph1);
	}

	static int minmumdist(int dis[], boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < numberOfNodes; i++) {
			if (dis[i] < min && visited[i] == false) {
				min = dis[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	static void dijkstra(int start) {
		int dis[] = new int[numberOfNodes];
		boolean visited[] = new boolean[numberOfNodes];
		for (int i = 0; i < numberOfNodes; i++) {
			dis[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		dis[start] = 0;

		for (int c = 0; c < numberOfNodes; c++) {
			int u = minmumdist(dis, visited);
			visited[u] = true;
			for (int v = 0; v < numberOfNodes; v++) {
				if(graph[u][v]!=0 && visited[v]==false 
						&& dis[u]!=Integer.MAX_VALUE && dis[u]+graph[u][v]<dis[v]){
					dis[v]=dis[u]+graph[u][v];
				}
			}
		}
		
		for(int i=0;i<numberOfNodes;i++){
			System.out.println(i+" "+dis[i]);
		}
	}

	static void mst(int graph[][]) {
		int dis[] = new int[numberOfNodes];
		int parent[] = new int[numberOfNodes];
		parent[0] = -1;
		boolean visited[] = new boolean[numberOfNodes];
		for (int i = 0; i < numberOfNodes; i++) {
			dis[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		dis[0] = 0;

		for (int c = 0; c < numberOfNodes; c++) {
			int u = minmumdist(dis, visited);
			visited[u] = true;
			for (int v = 0; v < numberOfNodes; v++) {
				if(graph[u][v]!=0 && visited[v]==false 
						 && graph[u][v]<dis[v]){
					parent[v]=u;
					dis[v]=graph[u][v];
				}
			}
		}
		
		System.out.println("Edge   Weight");
	    for (int i = 1; i < numberOfNodes; i++)
	        System.out.println(parent[i]+" - "+ i+"    "+
	                           graph[i][parent[i]]);
	}
	
}
