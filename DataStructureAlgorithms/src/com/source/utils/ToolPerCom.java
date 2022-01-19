package com.source.utils;

import java.util.Arrays;

public class ToolPerCom {

	/**
	 * @param args
	 */
	static int cost[]={1,2,3,4};
	static int out[];
	static int arr[]={1,2,3};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out=new int[4];
		combination(0,0,0);
		out=new int[4];
		permute(0);

	}
	static void combinationWithLoop(int a[],int n,int r){
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					System.out.println(a[i]+" "+a[j]+" "+a[k]);
				}
			}
		}
	}
	
	static void PermutationWithLoop(int a[],int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j)continue;
				for(int k=0;k<n;k++){
					if(k==j||i==k)continue;
					for(int l=0;l<n;l++){
						if(l==j||i==l||k==l)continue;
						for(int m=0;m<n;m++){
							if(i==m||m==k||m==l||j==m)continue;
							System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+a[l]+" "+a[m]);
						}
					}
				}
			}
		}
	}
	static void combination(int index,int sum,int r){
		if(index==cost.length){
			
			System.out.println(Arrays.toString(out)+"="+sum);
			
			return;
		}
		combination(index+1,sum,r);
		out[r]=cost[index];
		combination(index+1,sum+cost[index],r+1);
		out[r]=0;
	}
	
	static void combinationWithoutRepeatation(int index,int r){
		//System.out.println(index+" "+r);
		if(index==arr.length || r==out.length){
			if(r==out.length)
			   System.out.println(Arrays.toString(out));
			return;
		}
		

		combinationWithoutRepeatation(index+1,r);
		out[r]=arr[index];
		combinationWithoutRepeatation(index+1,r+1);


		
	}
	
	static boolean visited[]=new boolean[4];
	static void permute(int index){
		if(index==cost.length){
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i=0;i<cost.length;i++){
			if(visited[i]==true)continue;
			visited[i]=true;
			out[index]=cost[i];
			permute(index+1);
			visited[i]=false;
		}
	}


/*
[0, 0, 0, 0]=0
[4, 0, 0, 0]=4
[3, 0, 0, 0]=3
[3, 4, 0, 0]=7
[2, 0, 0, 0]=2
[2, 4, 0, 0]=6
[2, 3, 0, 0]=5
[2, 3, 4, 0]=9
[1, 0, 0, 0]=1
[1, 4, 0, 0]=5
[1, 3, 0, 0]=4
[1, 3, 4, 0]=8
[1, 2, 0, 0]=3
[1, 2, 4, 0]=7
[1, 2, 3, 0]=6
[1, 2, 3, 4]=10
*/
	static void generateBitArrayfor(int number,int bitSize){
    	int a[]=new int[bitSize];
    	number=6;
    	for(int num=6;num<=number;num++){
    		int mask=1<<bitSize-1;
    	   		for(int i=0;i<a.length;i++){
    			if((mask&number)!=0)
    				a[i]=1;
    			else
    				a[i]=0;
    			mask = mask >> 1;
    		}
    		
    		System.out.println(Arrays.toString(a));
    	}
    }
	 static void generateBitArray(int size){
	    	size=4;
	    	int a[]=new int[size];
	        int number =2;    	
	    	int mask = 1 << size-1;
	    	for(int i=0; i<a.length; i++) {
	            if( (mask & number) != 0 )
	            	a[i]=1;
	            else
	            	a[i]=0;
	           mask = mask >> 1;
	        }
	    	System.out.println(Arrays.toString(a));

	    	
	    }
	    
	 private static void permute(int[] a, int k) {
			//System.out.println("permute="+k);
			for(int i = k; i < a.length; i++){
				swap(a, i, k);
				permute(a, k+1);
				// System.out.println("in loop permute="+(k+1));
				swap(a, k, i);
			}
			if (k == a.length -1){
				System.out.println(Arrays.toString(a));
			}
		}

		private static void swap(int[] a, int i, int k) {
			int temp=a[i];
			a[i]=a[k];
			a[k]=temp;

		}
		
		/* arr[]  ---> Input Array
	    data[] ---> Temporary array to store current combination
	    start & end ---> Staring and Ending indexes in arr[]
	    index  ---> Current index in data[]
	    r ---> Size of a combination to be printed */
	    static void combinationUtil(int arr[], int data[], int start,
	                                int end, int index, int r)
	    {
	        // Current combination is ready to be printed, print it
	        if (index == r)
	        {
	            for (int j=0; j<r; j++)
	                System.out.print(data[j]+" ");
	            System.out.println("");
	            return;
	        }
	        //combinationUtil(arr, data, start, end, index+1, r);
	        // replace index with all possible elements. The condition
	        // "end-i+1 >= r-index" makes sure that including one element
	        // at index will make a combination with remaining elements
	        // at remaining positions
	        for (int i=start; i<=end && end-i+1 >= r-index; i++)
	        {
	            data[index] = arr[i];
	            combinationUtil(arr, data, i+1, end, index+1, r);
	        }
	    }
	 
	    // The main function that prints all combinations of size r
	    // in arr[] of size n. This function mainly uses combinationUtil()
	    static void printCombination(int arr[], int n, int r)
	    {
	        // A temporary array to store all combination one by one
	        int data[]=new int[r];
	 
	        // Print all combination using temprary array 'data[]'
	      //combinationUtil(int arr[], int data[], int start,int end, int index, int r)
	        combinationUtil(arr, data, 0, n-1, 0, r);
	    }
}
