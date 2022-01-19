package com.source.linkedlist;

class LinkedList {

	class Node {
		int item;
		Node next;

		public Node(int _item) {
			this.item = _item;
			this.next = null;
		}
	}
	
	Node mHead; 
	
	public LinkedList(){
		mHead = null;
	}

	public void insertAtEnd(int _item) {
        Node node = new Node(_item);
		if(mHead==null){
			mHead = node;
		}else{
			Node n = mHead;
			while(n.next!=null){
				n= n.next;
			}
			n.next =node;
		} 
	}

	public void insertAtStart(int _item) {
        Node node = new Node(_item);
		if(mHead==null){
			mHead = node;
		}else{
			Node n = mHead;
			node.next=n;
			mHead = node;
		}
	}

	public void insertAsOrdered(int _item) {
		Node node = new Node(_item);
		if(mHead==null){
			mHead = node;
		}else{
			if(mHead.next ==null){
				if(mHead.item > node.item){
					Node n = mHead;
					node.next=n;
					mHead = node;
				}else{
					mHead.next= node;
				}
			}else{
				if(mHead.item > node.item){
					Node n = mHead;
					node.next=n;
					mHead = node;
				}else{
					Node n = mHead;
					while(n.next!=null){
						if( n.next !=null && n.next.item > node.item ){
							Node temp = n.next;
							n.next = node;
							node.next = temp;
							return;
						}
						n= n.next;
					}
					n.next = node;
				}
			}
		}

	}

	public void insertAfter(Node prev_node, int _item) {
		
		if(prev_node == null){
			System.out.println("Invalid Node");
			return;
		}
		
		Node node = new Node(_item);
		
		node.next= prev_node.next;
		prev_node.next= node;

	}

	public void deleteAtEnd() {
        
		if(mHead == null ){
			System.out.println("List Empty");
			return;
		}
		
		if(mHead.next ==null){
			mHead =null;
			return;
		}
		Node n = mHead;
		while(n.next!=null){
			if(n.next.next==null){
				n.next = null;
				break;
			}
			n= n.next;
		}
		
		
	}

	public void deleteAtStart() {
		if(mHead == null ){
			System.out.println("List Empty");
			return;
		}
		if(mHead.next ==null){
			mHead =null;
			return;
		}else{
		  Node n = mHead.next;
		  mHead = n;
		}
	}

	public void delete(int _item) {
		boolean found =false;
		if(mHead ==null){
			System.out.println("List Empty");
			return;
		}
		
		if(mHead.item ==_item){
			Node n = mHead.next;
			mHead = n;
			System.out.println("Item deleted");
			return;
		}else{
			Node n = mHead;
			while(n!=null){
				if(n.next!=null){
				    if(n.next.item==_item ){
					 n.next = n.next.next;
					 found =true;
					 break;
				    }
				}
				
				n = n.next;
			}
			if(found){
				System.out.println("Item deleted");
				found =false;
			}else{
				System.out.println("Item not deleted");
			}
		}
		
		

	}
	
	public void print(){
		if(mHead==null){
			System.out.println("List Empty");
			return;
		}
		System.out.println();
		Node n= mHead;
		while(n!=null){
			System.out.print("["+n.item +"]->");
			n= n.next;
		}
		
	}
	
	public void search(int _item){
		if(mHead==null){
			System.out.println("List Empty");
			return;
		}
		Node n= mHead;
		while(n!=null){
			if(n.item==_item){
				System.out.println("["+n.item +"]->");
				return;
			}
			n= n.next;
		}
		System.out.println("\nItem not found");
	}
}

public class LinkedListSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
       	//linkedList.print();
		/*linkedList.insertAtStart(17);
		linkedList.insertAtStart(15);
		linkedList.print();
		linkedList.insertAtEnd(25);
		linkedList.insertAtEnd(35);
		linkedList.print();
		linkedList.insertAsOrdered(12);
		linkedList.insertAsOrdered(20);
		linkedList.insertAsOrdered(40);
		linkedList.insertAsOrdered(20);
		linkedList.print();
		linkedList.insertAfter(linkedList.mHead.next,16 );
		linkedList.print();
		linkedList.search(99);
		linkedList.search(16);*/
		
		
       	linkedList.insertAtStart(17);
       	linkedList.insertAtStart(12);
       	linkedList.insertAtStart(15);
       	linkedList.print();
		//linkedList.deleteAtStart();
		//linkedList.print();
		//linkedList.deleteAtStart();
		//linkedList.print();
		linkedList.deleteAtEnd();
		linkedList.print();
		linkedList.deleteAtEnd();
		linkedList.print();
		linkedList.deleteAtEnd();
		linkedList.print();
		
	 	linkedList.insertAtStart(17);
       	linkedList.insertAtStart(12);
       	linkedList.insertAtStart(15);
      	linkedList.insertAtStart(13);
      	linkedList.insertAtStart(14);
       	linkedList.print();
		linkedList.delete(1);
		linkedList.print();
		
		linkedList.delete(14);
		linkedList.print();
		
		
		linkedList.delete(12);
		linkedList.print();
		
		linkedList.delete(17);
		linkedList.print();
		
		linkedList.deleteAtStart();
	    linkedList.print();
	}

}
