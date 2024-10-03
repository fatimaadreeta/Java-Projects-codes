package Assignment2;


//node of binary search tree

public class BSTNode {
	
	int key;
	BSTNode left, right;
	
	BSTNode(int key){
		this.key = key;
		left = right = null;
	}
	
	public String toString() {
		return "node: "+this.key;
	}

}
