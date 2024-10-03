package SinglyLinkedList;

public class Node<Type> {
	 
	Type element; // data
	Node<Type> next; // link/reference to the next node 
	
	public Node(){
		next = null;
		
	}
	    
	public Node(Type ele){
	    element = ele;
	       next = null;
	       
	}
	
	public void setElement(Type ele){
		element = ele;
		
	}
	    
	public Type getElement(){
	     return element;
	    }
	
	public Node<Type> getNext(){
		return next;
		
	}
	
	public void setNext(Node<Type> next){
		this.next = next;
		
	}

}
