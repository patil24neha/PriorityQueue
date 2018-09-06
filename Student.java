/* Neha Ashok Patil
 * Red Id - 821545485
 * Fall 2018 - CS 635 : ADV OBJ ORIENT DSGN PROG
 * Enrolled to the course
 */
package Assignment1;

//This is Student class separated from Main Priority Queue logic to have modularity.

public class Student {

	/* Below are student class's private instance variables which are accessible
	 only through public getter/setter methods. */
	private int redid;
	private String name;
	private String emailid;
	private double gpa;
	private int units;
	private double priority;

	/**
	 * This is a class constructor to initialize instance variables whenever new
	 * class object is created.
	 */
	public Student(int redid, String name, String emailid, double gpa, int units) {
		checkGpa(gpa);
		checkUnits(units);
		this.redid = redid;
		this.name = name;
		this.emailid = emailid;
		this.gpa = gpa;
		this.units = units;
		this.priority = calculatePriority(gpa,units);
	}// end of public constructor

	/*Below are public getter/setter methods to access private instance variables
	 of class.*/
	public int getRedId() {
		return redid;
	}

	public void setRedId(int redid) {
		this.redid = redid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPriority() {
		return priority;
	}

	/**
	 * To validate units value while object creation. Throws an exception if value
	 * is out of range.
	 */
	public void checkUnits(int units) {
		int MIN_UNITS = 0, MAX_UNITS = 150;

		// Compares given units value with MIN and MAX values.
		if (units < MIN_UNITS || units > MAX_UNITS) {
			throw new IllegalArgumentException("Invalid value " + units + " for Units. Units must be between 0 and 150.");
		}
	}// end of checkUnits method

	/**
	 * To validate gpa value while object creation. Throws an exception if value is
	 * out of range.
	 */
	public void checkGpa(double gpa) {
		double MIN_GPA = 0.0, MAX_GPA = 4.0;
		
		// Compares given gpa value with MIN and MAX values.
		if (gpa < MIN_GPA || gpa > MAX_GPA) {
			throw new IllegalArgumentException("Invalid value " + gpa + " for GPA. GPA must be between 0.0 and 4.0.");
		}
	}// end of checkGpa method

	
	/** Calculates priority from Units and GPA */
	public double calculatePriority(double gpa, int units) {
		double MAX_UNITS = 150.0, MAX_GPA = 4.0;
		int unitsPercentage = 70, gpaPercentage = 30;

		// Takes 70% of units and 30% of gpa to get the actual priority.
		double calculatedPriority = ((units / MAX_UNITS) * unitsPercentage) + ((gpa / MAX_GPA) * gpaPercentage);
		return calculatedPriority;
	}// end of calculatePriority method

}// end of Student class
