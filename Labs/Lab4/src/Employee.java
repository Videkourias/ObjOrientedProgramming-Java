import java.time.Year;

/**
 * Employee class, inherits from Person.java
 * @author Dean Willavoys - 105003751
 * @since 2019-10-8
 */
public class Employee extends Person{
	private int yearHired; //between 1900 and 2999
	private int id; //Unique positive integer ID, from counter
	private static int counter = 0; //Unique id generation, sequential
	
	//Default Constructor
	public Employee() {
		super(); //Super class defaults
		yearHired = Year.now().getValue(); //Sets default as current year
		id = ++counter; //Unique ID
	}
	
	
	//Overloaded Constructor
	public Employee(String name, int age, int yearHired) {
	        this();
	        setName(name);
	        setAge(age);
		setHired(yearHired);
	}
	
	/**
	 * Sets year hired, if provided year is valid
	 * @param yearHired The year employee was hired, between 1900 and 2999
	 * @return int The year hired currently on record
	 */
	public int setHired(int yearHired) {
	    if(validYear(yearHired)) {
	        this.yearHired = yearHired;
	    }
	    return this.yearHired;
	}
	
	
	/**
	 * Getter for employee id
	 * @return int The id of the employee
	 */
	public int getId() {
	    return id;
	}
	
	/**
	 * Getter for the year hired
	 * @return int The year employee was hired
	 */
	public int getYearHired() {
	    return yearHired;
	}
	
	//toString Override
	public String toString() {
	    return getName() + " was hired in " + getYearHired() + " and is " + getAge() + " years old";
	}
	
	
	
	
	//Validates year is between 1900 and 2999
	private boolean validYear(int year) {
	    if(year > 1900 && year < 2999) {
	        return true;
	    }
	    return false;
	}
}
