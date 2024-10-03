package Assignment2;

import java.util.Random;

public class QuickSort {

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
		/* //array is printed before sorting
		System.out.println("An array of integers(before sorting:) ");
		for(int num: array) {
			System.out.print(num+" ");
		}
		System.out.println();
		quickSort(array); //sorting function is called to sort the array
		
		//sorted array is printed
		System.out.println("An array of integers(after sorting:) ");
		for(int numSorted: array) {
			System.out.print(numSorted+" ");
		}*/
		
		//array is printed before sorting
		System.out.println("An Array of random integers(before sorting:) ");
		for(int num: arrayRandom) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		//function is called to sort array, then sorted array is printed
		System.out.println("An array of integers(after sorting:) ");
		quickSort(arrayRandom);
		for(int numSorted: arrayRandom) {
			System.out.print(numSorted+" ");
		}
		
	}
	
	//method to call
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, array.length-1);
	}
		private static void quickSort(int array[], int low, int high) {
			/*
			 * pivot is a crucial number for quickSort. i and j are 
			 * made to store temporary start/low and end/high value at each partition
			 * temp will be used for swapping value
			 */
			/*
			 * here partition is being performed without creating another
			 * collection list - the algorithm of partition being performed in 
			 * one one collection(array) though recursion by changing i and j
			 * value with each loop
			 */
			int pivot, i, j, temp;
			
			if(low<high) {
				pivot = (low+high)/2;//mid-value is stored as pivot
				i = low;
				j = high;
				
				/*
				 * for sort to excecute, low has to be less than high
				 * i=temp-low and j=temp-high
				 */
				/*
				 * value at i has to be less or equal value at pivot position
				 * 
				 */
				while(i < j) {
					while(array[i] <= array[pivot] && i < high) {
						i++;
					}
						/*as low is lowest position, next recursion of low has
						*to be higher than low, sow i is incremented
						*/
					while(array[j] > array[pivot]) {
						j--;
					}
					/*as high is highest position, next recursion of high has
					*to be lower than high, so j is decremented
					*/
					if(i < j) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
					 /* elements between i and j position are swapped
					 * thus two separate sorted list of 
					 * low and high elements created, in respect to pivot
					 */
				}
				/*
				 * now element between j and pivot position is swapped
				 * as upon exiting, j is less than i
				 */
				temp = array[pivot];
				array[pivot] = array[j];
				array[j] = temp;
				
				/*recursively calling quicksort
				 * for two partition - L and G
				 */
				quickSort(array, low, j-1);
				quickSort(array, j+1, high);
			}
		}
	}


	
	


	


