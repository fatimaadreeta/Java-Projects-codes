package Assignment2;

import java.util.Random;

public class MergeSort {

	static Random rand = new Random();
	static int[] array = new int[1000];
	static int[] arrayRandom = new int[1000];

	public static void main(String[] args) {
		
		/*to create an array from 0 - 1000 
		 * where elements are already sorted
		 */
		for(int i = 0; i<1000; i++) {
			array[i] = i;
		}
		//to create random array
		for(int i = 0; i<1000; i++) {
			int randomNum = rand.nextInt(1000);
			arrayRandom[i] = randomNum;
		}
		//printed before sorting
		System.out.println("An array of integers(before sorting:) ");
		for(int num: array) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		mergeSort(array);//method is called to sort array
		//printed after sorting
		System.out.println("An array of integers(after sorting:) ");
		for(int numSorted: array) {
			System.out.print(numSorted+" ");
		}
		
		/*//printed before sorting
		System.out.println("An array of random integers(before sorting:) ");
		for(int num: arrayRandom) {
			System.out.print(num+" ");
		}
		System.out.println();
		mergeSort(arrayRandom);//method to sort array
		//printed after sorting
		System.out.println("An array of random integers(after sorting:) ");
		for(int numSorted: arrayRandom) {
			System.out.print(numSorted+" ");
		}*/
	}

	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length-1);
		
	}
	
	
	public static void mergeSort(int[] arr, int lowIndex, int highIndex) {
		if(lowIndex<highIndex) {
			int midIndex = (lowIndex+highIndex)/2;
			//recursive call for lower half
			mergeSort(arr, lowIndex, midIndex);
			//recurcive call for upper half
			mergeSort(arr, midIndex+1, highIndex);
			//helper method to merge the sorted halves
			merge(arr, lowIndex, midIndex, highIndex);
		}
		
	}
	
	//helper method that combines two temporary arrays 
	//with their sorted elements
	public static void merge(int[] arr, int lowIndex, int midIndex, int highIndex) {
		int leftSize = midIndex - lowIndex+1;
		int rightSize = highIndex - midIndex;
		 
		//temporary arrays with size
		int[] leftArr = new int[leftSize];
		int[] rightArr = new int[rightSize];
		
		for(int i = 0; i<leftSize; i++) {
			leftArr[i] = arr[lowIndex+i];
		}
		
		for(int j = 0; j<rightSize; j++) {
			rightArr[j] = arr[midIndex+1+j];//cannot take mid as it is a part of leftArray
		}
		
		/*after building the arrays, we sort them
		 * i for left and j for right arrays, and k is to 
		 * compare with main array
		 */
		int i = 0; int j = 0; int k = lowIndex;
		
		
		while(i<leftSize && j<rightSize) {
			/*compare the first element of each array,
			 * whichever is the smallest, place it into parametric array
			 * then increment i&k or j&k
			 * only applicable if both arrays are not empty
			 */
			if(leftArr[i]<rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
				k++;
			}
			else {
				arr[k] = rightArr[j];
				j++;
				k++;
			}
		}
		
		/*if rightArray has no more elements, but left-array has
		 * unvisited elements 
		*/
		while(i<leftSize) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		/*if leftArray has no more elements, but right-array has
		 * unvisited elements 
		*/
		while(j<rightSize) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
		
	}
			
}
