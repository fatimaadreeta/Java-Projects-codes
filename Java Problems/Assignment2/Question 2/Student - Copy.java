package Assignment2;

public class Student {
	private int id;
	private String name;
	private double cgpa;
	
	public Student(int id, String name, double cgpa) {
		setId(id);
		setName(name);
		setCgpa(cgpa);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the cgpa
	 */
	public double getCgpa() {
		return cgpa;
	}

	/**
	 * @param cgpa the cgpa to set
	 */
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public String toString() {
		return getId()+" "+getName()+" "+getCgpa();
	}
}
