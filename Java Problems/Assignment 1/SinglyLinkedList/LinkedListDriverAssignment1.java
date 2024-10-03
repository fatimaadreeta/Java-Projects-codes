package SinglyLinkedList;
import java.util.Scanner;
/*B1901898 - Fatima Binte Faiz Adreeta*/
public class LinkedListDriverAssignment1{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//two empty nodes N1 and N2 is created
		SLinkedList<String> N1 = new SLinkedList<>();
		SLinkedList<String> N2 = new SLinkedList<>();
		
		//two integer values are taken from user as string
		System.out.println("Enter first number: ");
		String NodeString1 = scan.nextLine();
		System.out.println("Enter second number: ");
		String NodeString2 = scan.nextLine();
		
		//character arrays created based on user input
		//character array stores each number as a character inside the array
		char[] sll1 = new char[NodeString1.length()];
		char[] sll2 = new char[NodeString2.length()];
		
		
		//for first linked list - N1
		//a for loop traverses the String and starts storing each char
		//value in correct order: for example: 123 will be stored as [1][2][3]
		for(int i = 0; i < sll1.length; i++) {
			sll1[i] = (NodeString1.charAt(i));	
		}
		
		//for 2nd linked list - N2
		//numbers stored in char array in similar manner
		for(int i = 0; i < sll2.length; i++) {
			sll2[i] = (NodeString2.charAt(i));	
		}
		
		
		//for N1 - all integers stored in each node
		//integer values are stored as String by converting each char value to String
		//value is stored using addFront()
		//the number is stored in reverse
		for(int i= 0; i< sll1.length; i++) {
			String element = Character.toString(sll1[i]);
			N1.addFront(element);
		}
		
		//for N2 - all integers stored in each node
		for(int i = 0; i< sll2.length; i++) {
			String element = Character.toString(sll2[i]);
			N2.addFront(element);
		}

		//(i)addition 
		//a node called sum is created to Store the added value
		SLinkedList<Long> Sum = addNumbers(N1, N2);//method performs addtion between two linked list
		
		System.out.println("The sum is: ");
		Node<Long> temp = Sum.getHead();//Sum's head is stored in temp
		
		while(temp!=null) {
			System.out.print(temp.getElement());
	        temp = temp.getNext();
	        }
		System.out.println();
	       
       //(ii)concatenation
       //N1 and N2 will concatenate and will become 1 String list C
       
       SLinkedList<String> C = new SLinkedList<String>();
       C = addTwoLists(N1, N2);//method that concatenates two lists
       
       Node<String> headNode = C.getHead();//headNode is initialized as the head of C
       System.out.println("Concatenated String: ");
       while(headNode!=null) {
    	   System.out.print(headNode.getElement());
    	   headNode = headNode.getNext();
       }

       scan.close();  
	}


	//i)a method called add is created to solve the problem
	public static SLinkedList<Long> addNumbers(SLinkedList<String> n1, SLinkedList<String> n2) {
		SLinkedList<String> bigString = null; //a linkedList that is null
		SLinkedList<String> smallString = null;//a linkedList that is null
		SLinkedList<Long> AddedValues = new SLinkedList<>();// a new SLinkedList is created to store the value
		
		if(n1.size()>=n2.size()) {//if n1 is greater than n2
			bigString = n1;//the n1 will be stored as bigString
			smallString = n2;//the n2 will be stored as smallString
		}
		else if(n1.size()<n2.size()){
			bigString = n2;//the n2 will be stored as bigString
			smallString = n1;//the n1 will be stored as smallString
		}
		
		Node<String> temp1 = bigString.getHead();//storing the head of the bigger string in temp1
		Node<String> temp2 = smallString.getHead();//storing the head of the smaller string in temp2

		long num1 = 0, num2 = 0;//created two integer variables
		long carry = 0; //for addition
		long current_sum = 0;//value that will be stored inside linked list
		
		//loop will run as long as temp1 is not null, but 
		//even if temp2 is null the loop will run
		while(temp1!=null && (temp2!=null || temp2==null)) {
			num1 = Long.valueOf(temp1.getElement());
			
			//when all of temp2 elements have been traversed, but temp1 has elements
			if(temp2.getElement().equals(null)) {
				String numFix = temp2.getElement();
				num2 = Long.valueOf(numFix);
			}
			else {
				num2 = Long.valueOf(temp2.getElement());
			}
			
			long sum = num1+num2; //numbers are added and stored to sum
			
		//if the two added numbers are 10 or more than 10
			if(sum>=10 && (carry==1||carry==0)) {
				sum = (sum%10) + carry;//sum would be the mod value of sum
				carry = 1;//carry would be set to 1
				current_sum = sum; //the new value of sum is stored in current_sum
			}

		//if the value of two added number is less than 10 and there is a carry from previous addition
			else if(sum<10 && (carry==1 || carry==0)){
				sum = sum+carry;
				carry = 0;//the new carry is 0
				current_sum = sum;
			}
			
			//for final element addition when the smaller string has no more elements
			else if((temp2.getElement().equals(null)) && (carry==1||carry==0)){
				sum = num1+num2+carry;
				current_sum = sum;
			}
			
			
			//the final sum/current_sum value is added to the linked list
			AddedValues.addFront(current_sum); 
			
			temp1 = temp1.getNext();//the temp1 is now the next node
			temp2 = temp2.getNext();//the temp2 is now the next node
				
		}
		//to add the final carry
		if(temp1==null && carry==1) {
			num1 = num2 = 0; //as both of the lists have ended
			current_sum = num1+num2+carry;
			AddedValues.addFront(current_sum);//current_sum added at the front of the list
		}
		
		return AddedValues;
			
	} 
	
	//(ii) to concatenate two lists N1 and N2 and return a new list
	//N1 and N2 is not sorted, they are concatenated in the state user has given
	//to concatenate, the lists need to be in order of user input
	private static SLinkedList<String> addTwoLists(SLinkedList<String> n1, SLinkedList<String> n2) {
		
		SLinkedList<String> newList = new SLinkedList<>();
		
		//to reverse n1
		//to nodes to respectively store the node and the reference of the nest node
		Node<String> temp;
		Node<String> temp2;
		
		//the two nodes are initialized as null
		temp = null;
		temp2 = null;
		
		//while-loop to reverse the list
		
		while(n1.getHead()!=null) {
			temp2 = n1.getHead().getNext();//storting the address of the next node
			n1.getHead().setNext(temp);//head's pointer is set to null
			temp = n1.getHead();//temp is holding head now
			n1.setHead(temp2);//head is now head's next node
			}
		//n1 is reversed
		
		n1.setHead(temp);//final temp is updated as head
		
		//to reverse n2//to reverse n1
		//the two nodes are initialized as null
		temp = null;
		temp2 = null;
		
		//while-loop to reverse the list
		
		while(n2.getHead()!=null) {
			temp2 = n2.getHead().getNext();//storting the address of the next node
			n2.getHead().setNext(temp);//head's pointer is set to null
			temp = n2.getHead();//temp is holding head now
			n2.setHead(temp2);//head is now head's next node
		}
		n2.setHead(temp);
		//n2 is reversed
		
		//now concatenating two lists
		
		newList = n1;//n1 is stored inside newlist
		newList.getTail().setNext(n2.getHead());//newlists's tail now pointing towards n2head
		newList.setTail(n2.getTail());
		
		
		return newList;
	}

}
