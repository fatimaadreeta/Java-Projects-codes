package Assignment2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class FlightBooked {
	static HashMap<Integer, Customer> M = new HashMap<>();
	static Scanner kbd = new Scanner(System.in);
	static Heap priorityQueueM;
	public static void main(String[] args) {
		readFromTextFile();
		
		/*storing all the keys in the hashMap inside a set
		 * then converting the set to an int array
		 */
		
		Set<Integer> keys = M.keySet();
		int keyArray[] = keys.stream().
				mapToInt(Integer::intValue).toArray();
		int size = keyArray.length;
		
		priorityQueueM = new Heap(size);
		//storing all the values in the array inside the priorityQueue

		for(int key: keyArray) {
			priorityQueueM.insert(key);
		}
		
		//Printing all the passengers according to priority
		System.out.println("Priority number of all passengers: ");
		System.out.println(priorityQueueM.print());
		do{
			System.out.println("Enter a number to view passenger details: ");
			int priority = kbd.nextInt();
			Customer c = null;
			for(int i = 0; i< keyArray.length; i++) {
				if(M.containsKey(priority)) {
					c = M.get(priority);
				}
				else {
					c = null;
				}
			}
			if(c==null) {
				System.out.println("Invalid priority number");
			}
			else {
				System.out.println(c);
			}
			size--;
		}while(size!=-1);
		
	}
	
	public static void readFromTextFile() {
		System.out.println("Reading from file...");
		System.out.print("File name? ");
		String fileName = kbd.nextLine();
		try (FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);)
		{
			String aLine = br.readLine();
			
			while (aLine != null) {
				String[] tokens = aLine.split(",");
				//creating a customer obj
				Customer c = new Customer(tokens[0],
						Double.parseDouble(tokens[1]), 
						Integer.parseInt(tokens[2]));
				int s = Integer.parseInt(tokens[3]);
				int p = (int)c.calculatePriority(s);
				M.put(p, c); //now the hashMap has the key-value pair as entry
				
				aLine = br.readLine();
				}
		br.close();
		fr.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("'" + fileName + "' does not exist.");
			//fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Error in reading....");
			}
		}
	
	
	

}