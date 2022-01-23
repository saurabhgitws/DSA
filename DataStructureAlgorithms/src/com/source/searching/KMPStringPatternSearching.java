package com.source.searching;

import java.nio.file.Path;

public class KMPStringPatternSearching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
	}
	
	public static void KMPSearch(String pat,String txt) {
		int M=pat.length();
		int N = txt.length();
		
		int lps[] = new int[M];
		int j=0; // index of pat
		
		computeLPSArray(pat, M, lps);
		
		int i=0; //index of txt
				
		while(i<N) {
			if(pat.charAt(j)==txt.charAt(i)) {
				j++;
				i++;
			}
			if(j==M) {
				System.out.println("Found pattern at index " + (i - j));
				j= lps[j-1];
			}
			else if( i<N && pat.charAt(j)!=txt.charAt(i)) {
				if(j!=0) {
					j=lps[j-1];
				}
				else {
					i=i+1;
				}
			}
			
		}
				
	}
	
	static void computeLPSArray(String pat, int size, int lps[]) {
		
		int i=1;
		lps[0]=0;
		int len =0;
		while(i<size) {
			if(pat.charAt(i)== pat.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len!=0) {
					len = lps[len-1];
				}else { //len ==0
					lps[i] = len;
					i++;
				}
			}
		}
	}

}
