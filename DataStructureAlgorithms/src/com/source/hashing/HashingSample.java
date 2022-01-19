package com.source.hashing;

class HashNode{
	String key;
	String value;
	HashNode next;
	
	public HashNode(String _key,String _value){
		this.key=_key;
		this.value=_value;
		this.next = null;
	}
}
class Hashing{
	
     HashNode [] hashTable;
     int Max;
     int size;
     
     
     public Hashing (int _size){
    	 this.Max =_size;
    	 hashTable = new HashNode[Max];
     }
     
	public int myhashCode(String _key) {
		int hash = 1797;
		for (int i = 0; i < _key.length(); i++) {
			int c = _key.charAt(i);
			hash = ((hash << 5) + hash) + c;
		}
		if (hash < 0)
			hash = hash * -1;
		return (hash % Max);
	}
     
     public void print(){
    	
    	 for(int i=0;i<Max;i++){
    		 //System.out.println();
    		 HashNode head = hashTable[i];
    		 System.out.print("["+(i)+ "]=>");
    		 if(head==null){
    			 System.out.print("NULL");
    		 }else{
    			 while(head!=null){
    				 System.out.print("["+head.value+"]=>");
    				 head = head.next;
    			 }
    		 }
    		 System.out.println();
    	 }
     }
	
     public String get(String _key){
    	 int index = myhashCode(_key);
    	 HashNode head = hashTable[index];
    	 if( head == null ){
    		 return null;
    	 }else{
    		 while(head!=null){
    			 if(head.key.equals(_key)){
    				 return head.value;
    			 }
    			 head = head.next;
    		 }
    	 }
    	 
    	 return null;
     }
     
     public String insert(String _key,String _value){
    	 int index = myhashCode(_key);
    	 HashNode head = hashTable[index];
    	 
    	 HashNode node = new HashNode(_key, _value);
    	 
    	 if(head!=null){
    		 HashNode n = head;
    		 while(n.next!=null){
    			 if(n.key.equals(node.key)){
    				 n.value= node.value;
    				 break;
    			 }
    			 else{
    				 n = n.next;
    			 }
    		 }
    		 n.next=node;
    		 
    	 }else{
    		 head = node;
    		 hashTable[index] = head;
    	 }
    	 size++;
    	 //System.out.println("Item "+_value+ " Inserted at "+index+ " Current Size "+ size);
    	 return _value;
     }
     
     public String delete(String _key){
    	 int index = myhashCode(_key);
    	 HashNode head = hashTable[index];
    	 String Item = null;
    	 
    	 if(head== null){
    	    return Item;
    	 }
    	 if(head.key.equals(_key)){
       		 Item =head.value;
   		     if(head.next==null){
             	 head= null;
             	 hashTable[index]=null;
        		 return Item; 
    		 }
    		 else{
    			 hashTable[index]=head.next ;
    			return Item; 
    		 }
    	 }else{
    		 while(head!=null){
    			 if(head.next.key.equals(_key) && head.next!=null){
    				 Item =head.next.value;
    				 head.next = head.next.next ;
    				 return Item;
    			 }
    			 head = head.next;
    		 }
    	 }
    	 
    	 return Item; 
    	 
     }
     
}

public class HashingSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashing mHashing = new Hashing(10);
		mHashing.insert("1234", "abcd1");
		mHashing.insert("2345", "abcd2");
		mHashing.insert("3344",  "abcd3");
		mHashing.insert("4455",  "abcd4");
		mHashing.insert("7799",  "abcd5");
		mHashing.insert("1100",  "abcd6");
		mHashing.insert("2000",  "abcd7");
		mHashing.insert("3300",  "abcd8");
		mHashing.insert("6666",  "abcd9");
		mHashing.insert("7777",  "abcd10");
		mHashing.insert("9999",  "abcd11");
		mHashing.insert("5555",  "abcd12");
		mHashing.insert("8899",  "abcd13");
		
		mHashing.print();
		mHashing.insert("3300",  "abcd888");
		mHashing.print();
		if(mHashing.get("7799")!=null){
			System.out.println("Item found");
		}else{
			System.out.println("Item not found");
		}
		if(mHashing.get("7700")!=null){
			System.out.println("Item found");
		}else{
			System.out.println("Item not found");
		}
		
		
		if(mHashing.delete("7700")!=null){ // Not found
			System.out.println("Item deleted");
			 mHashing.print();
		}else{
			System.out.println("Item not found");
		} 
		
		if(mHashing.delete("1100")!=null){ // head with next null
			System.out.println("Item deleted");
			 mHashing.print();
		}else{
			System.out.println("Item not found");
		}
		
		if(mHashing.delete("1234")!=null){ // head with next
			System.out.println("Item deleted");
			 mHashing.print();
		}else{
			System.out.println("Item not found");
		}
		
		if(mHashing.delete("7777")!=null){ // middle node
			System.out.println("Item deleted");
			 mHashing.print();
		}else{
			System.out.println("Item not found");
		}
		
		if(mHashing.delete("5555")!=null){ // last node
			System.out.println("Item deleted");
			 mHashing.print();
		}else{
			System.out.println("Item not found");
		}
	}

}
