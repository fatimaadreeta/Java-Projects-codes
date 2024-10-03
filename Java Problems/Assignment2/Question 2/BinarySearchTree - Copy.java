package Assignment2;


public class BinarySearchTree {
	
	BSTNode root; //the very first requirement of a tree
	
	/*upon creating the BST, the node/root is null*/
	public BinarySearchTree() {
		root = null;
	}
	
	boolean isEmpty(){
		return (root==null);
	}
	
	/*if there is no node in the tree, create 
	 * a node with key and declare it root
	 * if there is a node, recursively call the insert() function
	 */
	public void insert(int key) {
		if(isEmpty()) {
			root = new BSTNode(key);//for root
		}
		else {
			insert(key, root);
		}
	}
	/* if key is less than node's key, create left child with key
	 * if there is a left child - check in respect of the left child
	 * if key is less than left child - create its left child with key
	 *  if key is greater than left child, create its right child. */
	
	/*if key is greater than node's key, create right child
	 * if key has a right child - than check in respect of that child
	 * if key is less than right child, create its left child. if
	 * key is greater than left child, create its right child. 
	 */
	private void insert(int key, BSTNode node) {
		
		if(key<node.key) {
			/*
			 * if left of node empty, create a new node with the
			 * key and insert it as left child of node
			 */
			if(node.left == null) {
				node.left = new BSTNode(key);//base case
			}
			else {
				insert(key, node.left);//recursive call
				//keep on going until there's an empty 
				//left child
			}
		}
		else if(key>node.key) {
			if(node.right == null) {
				node.right = new BSTNode(key);//base case
			}
			else {
				insert(key, node.right);//recursive call
			}
		}
		else {
			node = new BSTNode(key);//overwrite the existing node
		}
	}
	
	/*
	 * searches a node in respect to root/node
	 * if key is less than node's key, searches left
	 * if key is more than node's key, searches right
	 * if key is equal node's key, searchNode is node
	 * if key not found searchNode is null
	 */
	private BSTNode search(BSTNode node, int key) {
		BSTNode searchNode = null;
		
		if(key<node.key) {
			searchNode = search(node.left, key);
		}
		else if(key>node.key) {
			searchNode = search(node.right, key);
		}
		else if(key==node.key) {
			searchNode = node;
		}
		else {
			searchNode = null;
		}
		return searchNode;
	}
	
	public BSTNode search(int key) {
		if(isEmpty()) {
			return null;
		}
		else {
			return search(root, key);
		}
	}
	

	/*BST algorithm follows inOrder() for insertion, search and deletion*/
	public void inOrder() {
		if(isEmpty()) {
			System.out.println("Empty tree");
		}
		else {
			inOrder(root);
		}
	}
	private void inOrder(BSTNode node) {
		//<left><root><right>
		if(node!=null) {
			inOrder(node.left);
			System.out.println(node.key+" ");
			inOrder(node.right);
		}
	}
	
	
	/*deleted for three scenarios
	 * 1)key is less than root
	 * 2)key is greater than root
	 * 3)either left child or right child is null or there is no child
	 */

	public BSTNode delete(BSTNode node, int key) {
		//create a temp BSTNode
		BSTNode temp = null;
		if(node==null) {
			return null;
		}
		//1
		if(key<node.key) {
			node.left = delete(node.left, key);
		}
		//2
		else if(key>node.key) {
			node.right = delete(node.right, key);
		}
		//3
		else {
			if(node.left==null || node.right==null) {
				//if node.left null, then temp is node.right and vice versa
				temp = node.left == null? node.right : node.left;
				if(temp == null) {
					return node;
				}
				else {
					return temp;
				}
			} else {
				//fetches its child, then makes its key its node-key
				BSTNode inOrderChild = getChild(node);
				node.key = inOrderChild.key;
			}
		}
		return node;
		
	}
	
	public BSTNode getChild(BSTNode node) {
		if(node==null) {
			return node;
		}
		
		BSTNode temp = node.right;//changge
		
		while(temp.left != null) {
			temp = temp.left;
		}
		
		return temp;
	}
	
}
