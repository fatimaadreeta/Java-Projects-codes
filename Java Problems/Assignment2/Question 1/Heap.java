package Assignment2;

public class Heap {
	
	int[] Heap;//the array for insertion
	private int heapSize;//to keep track of the elements
	
	public Heap(int size) {
		Heap = new int[size];
		heapSize = 0;
	}
	
	boolean isEmpty() {
		return heapSize==0;
	}
	
	
	public void insert(int ele) {
		if(heapSize==Heap.length) {
			System.out.println("Cannot insert");
		}
		else if(heapSize<Heap.length){
			Heap[heapSize] = ele;
			heapSize++;//increment heap size
			heapifyUp();
		}
	}
	
	public int max() {
		int max = Heap[heapSize];
		return max;
	}
	
	
	
	private void heapifyUp() {
		//for max-heap
		//to place my last-inserted ele in position
		int eleIndex = heapSize-1;//last position of heap
		int ele = Heap[eleIndex];//stored to avoid data loss
		
		int parentIndex = parent(eleIndex);
		
		while(eleIndex>0 && ele > Heap[parentIndex]) {
			 int temp = Heap[parentIndex];//ele in parentIndex placed in temp
			 Heap[eleIndex] = temp;//temp is placed in eleIndex position
			eleIndex = parentIndex;//eleIndex is now parentIndex
			Heap[eleIndex] = ele;
		}
	}
	
	int parent(int index) {
		//index of child
		int parent = (index - 1)/2;
		return parent;
	}
	
	
	
	int leftChild(int index) {
		//index is that of parent
		int leftChild = 2*index + 1;
		return leftChild;
	}
	
	int rightChild(int index) {
		int rightChild = 2*index + 2;
		return rightChild;
	}
	

	public String print() {
		String print = "";
		for(int i = 0; i<heapSize; i++) {
			print += Heap[i]+" ";
		}
		return print;
	}

}
