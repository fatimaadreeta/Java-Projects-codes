package Palindrome;

import SinglyLinkedList.Node;

public class SLinkedList<Type> {
	
	private int size = 0;
	private Node<Type> head; // refers to the first node of the linked list
	private Node<Type> tail;

    public SLinkedList() {
        head = tail = null;//initially: empty linked list
        size = 0;
    } 
    
    public int size() {
    	return size;
    }
    
    public Node<Type> getHead(){
        return head;
    }
    
    public void setHead(Node<Type> head) {
    	this.head = head;
    }
    
    public boolean isEmpty(){
        boolean isNull = false;
        if(size == 0){
            isNull =  true;//if head is null, list is empty
        }
        return isNull;
    }
    
    /**
	 * @return the tail
	 */
	public Node<Type> getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node<Type> tail) {
		this.tail = tail;
	}

	// adding element at the front of linked list
    public void addFront(Type ele){
    	Node<Type> newNode = new Node<Type>(ele);
        newNode.setNext(head);
        
        if(isEmpty())
        	tail = newNode;
        head = newNode;
        	
        size++;
    }
    
    public void addLast(Type ele){
    	Node<Type> newNode = new Node<Type>(ele);
    	
    	if(isEmpty()) {
    		head = newNode;
    		tail = head;
    	}
    	else {
    		tail.setNext(newNode);//tail will be now pointing towards newNode
    		tail = newNode;//the newNode is the new tail
    		
    	}
    	
    	size++;
    }
    
    public Type removeFirst(){
        
        if(isEmpty()){
            return null;
        }
        
        Type ele = head.getElement(); // Element to be removed
        head = head.getNext(); // update head

        size--;
        return ele;
    }
    
    public Type removeLast() {
    	if(isEmpty()) {
    		return null;
    	}
    	
    	Type ele = tail.getElement();//element to be removed
    	//remove last element
    	Node<Type> temp = head; 
    	
    	//TODO: loop through the list
    	//last node(next is null)
    	
    	while(temp!=null) {
    		ele = temp.getElement();
    		temp = temp.getNext();
    		
    		if(temp.getNext()==null) {
    			ele = temp.getElement();
    		}
    	}
    	size--;//element removed
    	return ele;
    }
}