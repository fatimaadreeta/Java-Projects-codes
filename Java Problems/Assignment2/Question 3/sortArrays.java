package Assignment2;
import java.util.Random;

public class sortArrays {
	
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
		/*	System.out.println("An array of integers(before sorting:) ");
		for(int num: array) {
			System.out.print(num+" ");
			}
		System.out.println();
		insertionSort(array);//method is called to sort array
		//printed after sorting
		System.out.println("An array of integers(after sorting:) ");
		for(int numSorted: array) {
			System.out.print(numSorted+" ");
		}*/
		
		//printed before sorting
		System.out.println("An array of random integers(before sorting:) ");
		for(int num: arrayRandom) {
			System.out.print(num+" ");
		}
		System.out.println();
		insertionSort(arrayRandom);//method to sort array
		//printed after sorting
		System.out.println("An array of random integers(after sorting:) ");
		for(int numSorted: arrayRandom) {
			System.out.print(numSorted+" ");
		}
	}

	
	/*insertion sort has two arrays - a sorted array and an unsorted array
	 * initially the sorted array is the first element a[0], and key is the 
	 * element right next to it. key is compared with the sorted element,
	 * if key is smaller than a[0], swap
	 * and the rest of the array is in unsorted array
	 */
	public static void insertionSort(int[] array) {
		int i, j, key, temp;
		
		for(i = 1; i<array.length; i++) {
			key = array[i];
			j = i - 1; //j is the element of sorted list
		
			while(j >= 0 && key < array[j]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
			}
		}
	}
}
