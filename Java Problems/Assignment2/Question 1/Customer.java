package Assignment2;
import java.io.Serializable;


public class Customer {
	private String name;
	private double mileage;
	private int years;
	private int sequence;
	
	
	public Customer(String name, double M, int Y) {
		setName(name);
		setMileage(M);
		setYears(Y);
	}
	
	public boolean equals(Customer c2) {
		return (this.getName().equalsIgnoreCase(c2.getName()));
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mileage
	 */
	public double getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the years
	 */
	public int getYears() {
		return years;
	}

	/**
	 * @param years the years to set
	 */
	public void setYears(int years) {
		this.years = years;
	}

	/**
	 * @return the sequence
	 */
	public int getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the priority
	 */

	/**
	 * @param priority the priority to set
	 */
	public double calculatePriority(int Sequence) {
		setSequence(Sequence);//the passed parameter now the customer's sequence
		double p = getMileage()/1000 +getYears()-getSequence();
		return p;
		//calculating priority

	}
	
	public String toString() {
		return getName()+" (years: "+getYears()+
				" and mileage: "+getMileage();
	}
}
