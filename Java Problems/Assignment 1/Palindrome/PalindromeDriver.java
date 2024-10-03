package Palindrome;
/*B1901898 - Fatima Binte Faiz Adreeta*/
import java.util.Scanner;

public class PalindromeDriver {
	
	static Palindrome tester = new Palindrome();
	static LinkedListQueue<String> queueList = new LinkedListQueue<>();
	static LinkedListStack<String> stackList = new LinkedListStack<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String []args) {
		System.out.println("Start Palindrome test<q to exit>: ");
		String input = scan.nextLine();
		while(!input.equalsIgnoreCase("q")) {
			System.out.println("Enter a String: ");
			input = scan.nextLine();
			
			//the removed() method returns the string without punctuation and space
			String checker = tester.removed(input);//will be used for both stack and queue
			String actual = "";
			String reversed = "";
			
			//storing the string in queuelist
			for(int i = 0; i<checker.length(); i++) {
				char iChar = checker.charAt(i);
	        	String iString = Character.toString(iChar);
	        	queueList.enqueue(iString);
	        }
	        
			//dequeing to store in actual String
	       while(queueList.sz()!=0) {
	    	   actual+= queueList.dequeue();
	       }
	       
	       //storing the string in stackList
	       for(int i = 0; i<checker.length(); i++) {
				char iChar = checker.charAt(i);
	       	String iString = Character.toString(iChar);
	       	stackList.push(iString);
	       }
	       
	       //popping the elements to store in reverse string
	       while(stackList.size()!=0) {
	    	   reversed+= stackList.pop();
	       }
	       
	       //passing to check the string is palindrome or not
	       boolean isPalindrome = tester.CompareString(actual, reversed);
	       
	       if(isPalindrome==true) {
	    	   System.out.println("This is a palindrome");
	       }
	       else {
	    	   System.out.println("This is not a palindrome");
	       }
		}
	}

}
