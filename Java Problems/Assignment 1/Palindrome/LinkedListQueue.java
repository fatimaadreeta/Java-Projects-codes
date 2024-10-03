package Palindrome;


import SinglyLinkedList.SLinkedList;


public class LinkedListQueue<Type> implements Queue <Type> {
    
    SLinkedList<Type>  linkedQueue = new SLinkedList<>();
    
    public int sz() {
    	return linkedQueue.size();//size of the queue
    }
    
    public void enqueue(Type ele){
        linkedQueue.addLast(ele);
    }
    
    public Type dequeue(){
        return linkedQueue.removeFirst();
    }
    
}