package com.source.tries;

import javax.swing.text.rtf.RTFEditorKit;

class TrieNode{
	int count ;
	boolean endOfWord; //End of Word
	TrieNode children [];
	
	public TrieNode(){
		this.count = 0;
		this.endOfWord = false;
		this.children = new TrieNode[26];
	}
}

class Trie{
	TrieNode mRoot;
	
	public Trie(){
		this.mRoot = new TrieNode();
	}
	
	public void insert(String word){
		
		TrieNode currenntNode = mRoot;
		
		for(int i=0 ;i< word.length() ;i++){
			TrieNode node = new TrieNode();
			char c = word.charAt(i);
			int index = c-'a';
			if(currenntNode.children[index]==null){
				currenntNode.children[index] = node;
				currenntNode = node;
				currenntNode.count++;  
			}else{
				currenntNode = currenntNode.children[index];
				currenntNode.count++;
			}
		}
		currenntNode.endOfWord =true;
		
		System.out.println("Inserted "+word);
	}
	
	public void search(String word){
		if(searchWord(word)!=null){
			System.out.println("Found "+word);
		}else{
			System.out.println("Not Found "+word);
		}
		
	}
	
	public TrieNode searchWord(String word){
		TrieNode currentNode = mRoot;
		for(int i=0;i< word.length();i++){
			char c = word.charAt(i);
			int index = c-'a';
			if(currentNode.children[index]!=null){
				currentNode = currentNode.children[index];
			}else{
				return null;
			}
		}
		
		if(currentNode.endOfWord == true){
			System.out.println("Ties has this "+word);
		}else{
			System.out.println("Ties has prefix of this "+word);
		}
		if(currentNode == mRoot)
			return null;
		return currentNode;
	}
	
	public boolean searchPrefix(String word){
		if(searchWord(word)!=null)
			return true;
		return false;
	}
	
	
	//TODO:
	//Case 1#Some Other word prefix is same as this word (BCDE,BCKG)//Remove BCDE
	//Case 2#This word is prefix of some other word (BCDE,BCDEF) //Remove BCDE
	//Case 3#Some other word is prefix of this word (BCDE,BC) //Remove BCDE
	//Case 4#NO one dependent on this word (K)
	public void delete(){
		
	}
	
}


public class TrieSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trie trie = new Trie();
		trie.insert("abcde");
		trie.insert("bxy");
		trie.insert("abce");
		
		trie.search("abcde"); // Found word
		trie.search("abcd");  // Found only prefix
		trie.search("abde");  // Not found
		

	}

}
