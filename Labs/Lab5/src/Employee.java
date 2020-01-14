import java.time.Year;

/**
 * Employee class, extends Person
 * @author Dean Willavoys - 105003751
 * @since 2019-10-8
 */
public class Employee extends Person {
	private int yearHired; //1900 to 2999
	private int id; //Unique positive integer ID
	private static int counter = 0; //Unique id generation, sequential
	
	//Default Constructor
	public Employee() {
		super();
		yearHired = Year.now().getValue(); //Sets default as current year
		id = ++counter;
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

	//Prints message about worker
	protected void PayWorker() {
	    System.out.println(getName() + " is an employee who needs to be paid");
	}
	
	//Validates year is between 1900 and 2999
	private boolean validYear(int year) {
	    if(year > 1900 && year < 2999) {
	        return true;
	    }
	    return false;
	}
}
