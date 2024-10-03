package Palindrome;

import SinglyLinkedList.SLinkedList;


public class LinkedListStack <Type> implements Stack <Type>{
    
    SLinkedList<Type> sll = new SLinkedList<>();
    
    public int size() {
    	return sll.size();
    }
    
    
    public void push(Type e){
        sll.addFront(e);
    }
    
    public Type pop(){
        return sll.removeFirst();
    }
    
}