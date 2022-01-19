package com.source.utils;
import java.util.Arrays;


public class KMPAlgo {

	/**
	 * @param args
	 */
	static String inputStr="abcabcdabcabcabceabca";
	static String pattern="abce";
	static int patternIndex[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		searchSubString(inputStr.toCharArray(),pattern.toCharArray());
		
	}

	public static int[] preProcessPattern(char[] ptrn) {
	    int i = 0, j = -1;
	    int ptrnLen = ptrn.length;
	    int[] b = new int[ptrnLen + 1];
	 
	    b[i] = j;
	    while (i < ptrnLen) {            
	            while (j >= 0 && ptrn[i] != ptrn[j]) {
	            // if there is mismatch consider the next widest border
	            // The borders to be examined are obtained in decreasing order from 
	            //  the values b[i], b[b[i]] etc.
	            j = b[j];
	        }
	        i++;
	        j++;
	        b[i] = j;
	    }
	    return b;
	}
	
	 public static void searchSubString(char[] text, char[] ptrn) {
	        int i = 0, j = 0;
	        // pattern and text lengths
	        int ptrnLen = ptrn.length;
	        int txtLen = text.length;
	 
	        // initialize new array and preprocess the pattern
	        int[] b = preProcessPattern(ptrn);
	 
	        while (i < txtLen) {
	            while (j >= 0 && text[i] != ptrn[j]) {
	                j = b[j];
	            }
	            i++;
	            j++;
	 
	            // a match is found
	            if (j == ptrnLen) {
	                System.out.println("found substring at index:" + (i - ptrnLen));
	                j = b[j];
	            }
	        }
	    }
	
}
