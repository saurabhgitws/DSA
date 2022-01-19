package com.source.binarytree;

class BinarySearchTree {

	class Node {
		int key;
		Node left;
		Node right;

		public Node(int _item) {
			this.key = _item;
			this.left = null;
			this.right = null;
		}
	}

	Node mRoot;

	Node searchNode = null;

	public BinarySearchTree() {
		this.mRoot = null;
	}

	public void insert(int _item) {
		insert(mRoot, _item);
	}

	private void insert(Node _root, int _item) {
		if (mRoot == null) {
			mRoot = new Node(_item);
			return;
		}

		if (_root == null) {
			return;
		}

		if (_item < _root.key) {
			if (_root.left == null) {
				_root.left = new Node(_item);
			} else {
				insert(_root.left, _item);
			}
		} else {
			if (_root.right == null) {
				_root.right = new Node(_item);
			} else {
				insert(_root.right, _item);
			}
		}
	}

	public Node search(int _item) {
		searchNode = null;
		search(mRoot, _item);
		return searchNode;
	}

	private void search(Node _root, int _item) {
		if (mRoot == null) {
			System.out.println("Tree Empty");
			return;
		}

		if (_root == null) {
			return;
		}

		if (_item == _root.key) {
			// System.out.println("Item found");
			searchNode = _root;
			return;
		}

		if (_item < _root.key) {
			search(_root.left, _item);
		}
		if (_item > _root.key) {
			search(_root.right, _item);
		}
	}

	public void delete(int _item) {

		// Case 1: if leaf node : just delete
		// Case 2: node has one child : replace it
		// Case 3: one has two child: inorder successor of the node

		delete(mRoot, _item);
	}

	private Node delete(Node _root, int _item) {

		if (mRoot == null) {
			System.out.println("Tree Empty");
			return null;
		}

		if (_root == null) {
			return null;
		}

		if (_item < _root.key) {
			_root.left = delete(_root.left, _item);
					}
		if (_item > _root.key) {
			_root.right = delete(_root.right, _item);
		}

		if (_root.key == _item) {
  
			// Case 1 : Node is Leaf node
			if (_root.left == null && _root.right == null) {
				_root = null;

			}else 		// Case 2 : Node has one Child
			if (_root.left == null || _root.right == null) {

				if (_root.left != null) {

					_root = _root.left;

				}

				if (_root.right != null) {
					_root = _root.right;

				}
			}else if(_root.left != null && _root.right != null) {
				 Node temp= inOrderSuccesor(_root.right); // find minimum element
			     //Exchange the data between node and temp  
				_root.key = temp.key;  
                //Delete the node duplicate node from right subtree  
				_root.right = delete(_root.right, temp.key);  
			}

		}

		return _root;
	}

	
	
	private Node inOrderSuccesor(Node _root) {
		if (_root.left != null) {
			return inOrderSuccesor(_root.left);
		}else{
			return _root;
		}
	}
	

	public void inOrder() {
		inOrder(mRoot);
	}

	private void inOrder(Node _root) {
		if (mRoot == null) {
			System.out.println("Tree Empty");
			return;
		}
		if (_root == null) {
			return;
		}
		inOrder(_root.left);
		System.out.print(" " + _root.key);

		inOrder(_root.right);
	}

	public void preOrder() {
		preOrder(mRoot);
	}

	private void preOrder(Node _root) {
		if (mRoot == null) {
			System.out.println("Tree Empty");
			return;
		}
		if (_root == null) {
			return;
		}
		System.out.print(" " + _root.key);
		preOrder(_root.left);
		preOrder(_root.right);
	}

	public void postOrder() {
		postOrder(mRoot);
	}

	private void postOrder(Node _root) {
		if (mRoot == null) {
			System.out.println("Tree Empty");
			return;
		}
		if (_root == null) {
			return;
		}
		postOrder(_root.left);
		postOrder(_root.right);
		System.out.print(" " + _root.key);

	}

	public void printTree() {
		System.out.println();
		System.out.println("pre order Tree Travseral");// 100,20,10,30,200,150,300
		preOrder();

		System.out.println();
		System.out.println("In order Tree Travseral"); // 10,20,30,100,150,200,300
		inOrder();

		System.out.println();
		System.out.println("post order Tree Travseral");// 10,30,20,150,300,200,100
		postOrder();

	}
}

public class BinaryTreeSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree mBinarySearchTree = new BinarySearchTree();
		mBinarySearchTree.insert(100);
		mBinarySearchTree.insert(20);
		mBinarySearchTree.insert(10);
		mBinarySearchTree.insert(30);
		mBinarySearchTree.insert(200);
		mBinarySearchTree.insert(300);
		mBinarySearchTree.insert(150);
		System.out.println();
		System.out.println("pre order Tree Travseral");// 100,20,10,30,200,150,300
		mBinarySearchTree.preOrder();

		System.out.println();
		System.out.println("In order Tree Travseral"); // 10,20,30,100,150,200,300
		mBinarySearchTree.inOrder();

		System.out.println();
		System.out.println("post order Tree Travseral");// 10,30,20,150,300,200,100
		mBinarySearchTree.postOrder();

		BinarySearchTree.Node n = (BinarySearchTree.Node) mBinarySearchTree
				.search(151);
		if (n == null) {
			System.out.println("Item not found");
		} else {
			System.out.println("Item found");
		}

		mBinarySearchTree.insert(8);
		System.out.println();
		mBinarySearchTree.inOrder();
		mBinarySearchTree.insert(29);
		System.out.println();
		mBinarySearchTree.inOrder();
		mBinarySearchTree.insert(35);
		System.out.println();
		mBinarySearchTree.inOrder();

		System.out.println("\n Delete...");

		mBinarySearchTree.delete(300);
		System.out.println();
		mBinarySearchTree.inOrder();
		
		mBinarySearchTree.delete(10);
		System.out.println();
		mBinarySearchTree.inOrder();
		
		mBinarySearchTree.delete(20);
		System.out.println();
		mBinarySearchTree.inOrder();

		/*
		 * mBinarySearchTree.delete(10); System.out.println();
		 * mBinarySearchTree.inOrder(); mBinarySearchTree.delete(30);
		 * System.out.println(); mBinarySearchTree.inOrder();
		 */

	}

}
