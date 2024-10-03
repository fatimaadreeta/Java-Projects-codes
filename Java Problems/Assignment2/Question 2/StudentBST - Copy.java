package Assignment2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentBST {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Student> students= new ArrayList<>(); //storing all the students read
	static ArrayList<Student> studentsStored= new ArrayList<>();
	static BSTNode root;
	static BinarySearchTree studentBST;
	static ArrayList<Integer> addChecker;
	
	public static void main(String[] args) {
		readFromFile();
		studentBST = new BinarySearchTree(); //new BST
		addChecker = new ArrayList<>();//to keep track of every studentID entered in BST
		int choice;
		do {
			choice = mainMenu();
			
			switch(choice) {
			case 1:
				addAStudent();
				break;
			case 2:
				removeStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				displayAllStudents();
				break;
			}
			
		}while(choice!=0);

	}


	public static int mainMenu() {
		System.out.println("Welcome to Student system!");
		System.out.println("--------------------------");
		System.out.println("1. Add a student to BST");
		System.out.println("2. Remove a student from BST");
		System.out.println("3. Search a student from BST");
		System.out.println("4. Display all students from BST");
		System.out.println();
		int choice = scan.nextInt();
		return choice;
	}
	
	/*
	 * all student IDs display. choose an ID to add
	 */
	public static void addAStudent() {
		System.out.println("All student IDs: ");
		for(int i = 0; i<students.size(); i++) {
			int id = students.get(i).getId();
			System.out.print(id+" ");
		}
		System.out.println();
		System.out.println("Select id to continue");
		int id_input = scan.nextInt();
		
		int count = 0;//to keep track how many student was found
		Student temp = null;
		for(Student st: students) {
			if(id_input == st.getId()) {
				System.out.println("Student found: "+st);
				temp = st; //storing the latest student for ID
				count++;
			}
		}
			if(count>=1) {
				studentBST.insert(temp.getId());
				addChecker.add(temp.getId());//stores the newly added id to arraylist
				studentsStored.add(temp);//only adding after it is added to BST
				System.out.println("Student "+temp.getName()+" added to BST successfully");
				
				if(studentBST.isEmpty()) {
					root = new BSTNode(temp.getId());//first node is root 
				}
			}
			else {
				System.out.println("Invalid id. Try again");
			}
		}
	
	//can only remove ID that belong in BST
	//addChecker keeps track of all Nodes added to BST
	public static void removeStudent() {
		try {
			System.out.print("Student in BST: ");
			for(int i = 0; i<addChecker.size(); i++) {
				int id = studentsStored.get(i).getId();
				System.out.println(id+" ");
			}
			System.out.println();
			System.out.println("Select id to continue");
			int id_input = scan.nextInt();
			
			for(Student st: studentsStored) {
				if(id_input == st.getId()) {
					studentBST.delete(root, id_input);
					studentsStored.remove(st);//student removed from arrayList
					addChecker.remove(id_input);//id removed from arraylist
				}
			}
		}catch(Exception e) {
			System.out.println("Student removed. Select any integer to continue");
		}
	}
	
	public static void searchStudent() {
		System.out.println("All ids: ");
		for(int i = 0; i<addChecker.size(); i++) {
			System.out.println(addChecker.get(i)+" ");
		}
		System.out.println("Enter an ID to check: ");
		int id_input = scan.nextInt();
		
		//using user input to search BST
		BSTNode studentID = studentBST.search(id_input);
		
		if(studentID == null) {
			System.out.println("id not found");
		}
		else {
			for(Student st: studentsStored) {
				if(id_input == st.getId()) {
					System.out.println("Student found: "+st);
				}
			}
		}
			
	}
	
	/*displays all the student ID in-order,
	 * displays details of particular student, when ID entered
	 */
	public static void displayAllStudents() {
		System.out.println("All student IDs in-order: ");
		studentBST.inOrder();
		int id_input;
		do{
		System.out.println("Enter id to view details(-1 to exit): ");
		id_input = scan.nextInt();
		
		for(Student st : studentsStored) {
			if(id_input == st.getId()) {
				System.out.println(st);
			}
		}
		}while(id_input!= -1);
	}
	//students read and stored in an arrayList
	public static void readFromFile() {
		System.out.println("Filename? ");
		String filename = scan.nextLine();
		
		try(FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);)
		{
		String aLine = br.readLine();
		while (aLine != null) {
			String[] tokens = aLine.split(" ");
			//creating a student obj
			Student st = new Student(Integer.parseInt(tokens[0]),
				tokens[1], Double.parseDouble(tokens[2]));
			//storing the read student into arraylist
			
			students.add(st);
	
			aLine = br.readLine();	
		}
		
		br.close();
		fr.close();
		}catch(FileNotFoundException fnfe) {
			System.out.println(filename+" does not exist");
		}catch (IOException ioe) {
			System.out.println("Error in reading....");
		}
		
	}

}
