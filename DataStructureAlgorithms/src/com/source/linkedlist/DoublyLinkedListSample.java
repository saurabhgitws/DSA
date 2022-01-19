package com.source.linkedlist;

class DoublyLinkedList {

	class Node {
		int item;
		Node next;
		Node prev;

		public Node(int _item) {
			this.item = _item;
			this.next = null;
			this.prev = null;
		}
	}

	Node mHead;

	public DoublyLinkedList() {
		mHead = null;
	}

	public void insertAtEnd(int _item) {
		Node node = new Node(_item);
		if(mHead ==null){
			mHead = node;
			return;
		}
		
		Node n = mHead;
		while(n.next!=null){
			n = n.next;
		}
		
		n.next = node;
		node.prev =n;
	}

	public void insertAtStart(int _item) {
		Node node = new Node(_item);
		if(mHead ==null){
			mHead = node;
			return;
		}
		
		node.next = mHead;
		mHead.prev = node;
		mHead =node;
	}

	public void insertAsOrdered(int _item) {
		Node node = new Node(_item);
		if(mHead ==null){
			mHead = node;
			return;
		}
		
		if(mHead.item > node.item){
			node.next = mHead;
			mHead.prev = node;
            mHead = node;   			
		}else{
			Node n = mHead;
			while(n.next!=null){
				if(n.next.item > node.item && n.next!=null){
					Node temp=n.next;
					n.next = node;
					node.prev =n;
					node.next = temp;
					temp.prev = node;
					return;
				}
				
				n = n.next;
			}
			n.next =node;
			node.prev =n;
		}
		

	}

	public void insertAfter(Node prev_node, int _item) {
		
		if(mHead == null){
			System.out.println("List Empty");
			return;
		}
		
		if(prev_node == null){
			System.out.println("Invalid Node");
			return;
		}
		Node node = new Node(_item);
		Node n = prev_node.next;
		prev_node.next =node;
		node.prev = prev_node;
		node.next = n;
		
	}

	public void deleteAtEnd() {

		if (mHead == null) {
			System.out.println("List Empty");
			return;
		}

		if (mHead.next == null) {
			mHead = null;
			return;
		} else {
			Node n = mHead;
			while (n.next != null) {
				if (n.next.next == null) {
					n.next = null;
					return;
				}

				n = n.next;
			}
		}
	}

	public void deleteAtStart() {
		
		if(mHead == null){
			System.out.println("List Empty");
			return;
		}
		
		if(mHead.next == null){
			mHead =null;
			return;
		}else{
			 mHead = mHead.next;
			 mHead.prev =null;
			 return;
		}
	}

	public void delete(int _item) {
		
		if(mHead == null){
			System.out.println("List Empty");
			return;
		}
		
		if (mHead.item == _item) {
			if (mHead.next == null) {
				mHead = null;
			} else {
				mHead = mHead.next;
				mHead.prev = null;
			}
		}else{
			Node n = mHead;
			while(n!=null){
				if(n.next.item == _item && n.next != null){
					n.next = n.next.next;
					if(n.next != null){
						n.next.prev =n;
					}
					return;
				  }
				
				n = n.next;
			}
		}
	}

	public void print() {
		
		if(mHead ==null){
			System.out.println("List Empty");
			return;
		}
		System.out.println();
		Node n = mHead;
		while(n!=null){
			System.out.print("["+n.item+"]->");
			n = n.next;
		}
		
	}
	
	public void reversePrint(){
		if(mHead ==null){
			System.out.println("List Empty");
			return;
		}
		System.out.println();
		Node n = mHead;
		/*while(n!=null){
			System.out.println();
			if(n.prev==null){
				System.out.print("NULL");
			}
			else{
				System.out.print(n.prev.item);
			}
			
			
		    System.out.print("<-["+n.item+"]->");
			
			
			
			if(n.next==null){
				System.out.print("NULL");
			}
			else{
				System.out.print(+n.next.item);
			}
			n=n.next;
		}*/
		while(n.next!=null){
			n=n.next;
		}
		Node temp = n;
		while(temp!=null){
			System.out.print("<-["+temp.item+"]");
			temp = temp.prev;
		}
	}

	public void search(int _item) {
		if(mHead == null){
			System.out.println("List Empty");
			return;
		}
		boolean found = false;
		Node n = mHead;
		while(n!=null){
			if(n.item == _item){
				found = true;
				break;
			}
			n = n.next;
		}
		
		if(found){
			System.out.println("Item found");
			found = false;
		}else{
			System.out.println("Item not found");
		}
	}
}

public class DoublyLinkedListSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList linkedList = new DoublyLinkedList();
       	/*linkedList.print();
		linkedList.insertAtStart(17);
		linkedList.insertAtStart(15);
		
		linkedList.print();
		linkedList.insertAtEnd(25);
		linkedList.insertAtEnd(35);
		linkedList.print();
		linkedList.insertAsOrdered(12);
		linkedList.insertAsOrdered(20);
		linkedList.insertAsOrdered(40);
		linkedList.insertAsOrdered(20);
		
		linkedList.insertAfter(linkedList.mHead.next,16 );
		linkedList.print();
		linkedList.reversePrint();*/
		
		/*linkedList.insertAtStart(17);
		linkedList.insertAtStart(15);
		linkedList.insertAtStart(16);
		linkedList.print();
		linkedList.deleteAtStart();
		linkedList.print();
		linkedList.insertAtStart(19);
		linkedList.print();
		linkedList.deleteAtEnd();
		linkedList.print();*/
		
		linkedList.insertAtStart(17);
		linkedList.insertAtStart(15);
		linkedList.insertAtStart(16);
		linkedList.insertAtStart(11);
		linkedList.insertAtStart(12);
		linkedList.print();
		linkedList.search(99);
		linkedList.search(11);
		linkedList.delete(12);
		linkedList.print();
		linkedList.delete(16);
		linkedList.print();
		linkedList.delete(15);
		linkedList.print();
		linkedList.delete(17);
		linkedList.print();

		
	}

}
