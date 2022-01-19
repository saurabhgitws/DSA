package com.source.tries;


class TriesNode{
	TriesNode[] childeren;
	boolean isLeaf;
	int count;
	public TriesNode(){
		childeren=new TriesNode[26];
		isLeaf=false;
		count=0;
	}
}


class Tries{
	TriesNode root;
	
	public Tries() {
        root = new TriesNode();
    }
	
	public void insert(String word){
		TriesNode node=root;
		for(int l=0;l<word.length();l++){
			char c=word.charAt(l);
			int index=c-'a';
			if(node.childeren[index]==null){
				TriesNode tmp= new TriesNode();
				node.childeren[index]=tmp;
				node=tmp;
				node.count++;
				
			}else{
				node=node.childeren[index];
				node.count++;
			}
		}
		node.isLeaf=true;
	}
	
    public boolean search(String word){
    	TriesNode node=searcNode(word);
    	
    	if(node!=null)
    		return true;
		return false;
	}
    
    public boolean searchwithPrefix(String word){
         TriesNode node=searcNode(word);
    	
    	if(node!=null)
    		return true;
		return false;
	}
    
    public TriesNode searcNode(String word){
    	TriesNode node=root;
    	for(int l=0;l<word.length();l++){
    		char c=word.charAt(l);
    		int index= c-'a';
    		if(node.childeren[index]!=null){
    			node=node.childeren[index];
    		}else{
    			return null;
    		}
    		
    	}
    	if(node==root)
		return null;
    	
    	return node;
	}
}
public class TrieSampleImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries mTries = new Tries();
		mTries.insert("hello");
		mTries.insert("how");
		
	}

}
/*
 * 
Hello
root = TriesNode [null]
  children = TriesNode[26]
    count =1
    isLeaf =false
    [7] = TriesNode                           //H
	  children = TriesNode[26]
	    [4] = TriesNode                       //E
		  children = TriesNode[26]
		    [11] = TriesNode                  //L
			  children = TriesNode[26]
			    [11] = TriesNode              //L 
				  children = TriesNode[26]
				    [14] = TriesNode          //O   
					  children = TriesNode[26]
					  count =1
					  isLeaf =true
				count =1
                isLeaf =false
 			count =1
			isLeaf =false
		count =1	
		isLeaf =false
	count =1


Hello
root = TriesNode [null]
  children = TriesNode[26]
    [7] = TriesNode                           //H
	  children = TriesNode[26]
	    [4] = TriesNode                       //E
		  children = TriesNode[26]
		    [11] = TriesNode                  //L
			  children = TriesNode[26]
			    [11] = TriesNode              //L 
				  children = TriesNode[26]
				    [14] = TriesNode          //O   
					  children = TriesNode[26]
					  count =1
					  isLeaf =true
				count =1
                isLeaf =false
 			count =1
			isLeaf =false
		count =1	
		isLeaf =false
	count =1

*/		
