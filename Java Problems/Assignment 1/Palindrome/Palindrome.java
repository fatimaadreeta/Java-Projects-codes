package Palindrome;

public class Palindrome {
	
	String WithSpaceAndPunctuation;
	String Without;
	String Reversed;
	
	//takes user string, replaces any space or punctuation with emptry string
	//first removes space, then removes punctuations;
	//[^a-zA-Z0-9]--> all non-alphabet or non-numeric character
	public String removed(String WithSpaceAndPunctuation) {
		this.Without = WithSpaceAndPunctuation.replaceAll(" ", "").replaceAll("[^a-zA-Z0-9]", "");
		return Without;
	}
	
	//then store the actual string in queue list, then dequeue it to store in a string
	
	
	//compares the two Strings to check if it is a palindrome or not
	public boolean CompareString(String actual, String reversed) {
		boolean isPalindrome = false;
		if(actual.equalsIgnoreCase(reversed)) {
			isPalindrome = true;
		}
		else {
			isPalindrome = false;
		}
		return isPalindrome;
	}

}
