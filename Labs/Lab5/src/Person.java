/**
 * Class for a Person
 * @author Dean Willavoys - 105003751
 * @since 2019-10-8
 */
public class Person {
	private String name; //Non=empty
	private int age; //0 to 150, exclusive
	
	//Default Constructor
	public Person() {
		name = "private contractor";
		age = 18;
	}
	
	//Overloaded Constructor
	public Person(String name, int age) {
		this();
		setName(name);
		setAge(age);
	}
	
	
	/**
	 * Method to set name of Person object
	 * @param name The String name of the Person
	 * @return String Returns the passed name
	 */
	public String setName(String name){
		if(validName(name)) {
			this.name = name;
		}
		return name;
	}
	
	
	/**
	 * Method to set the age of Person object
	 * @param age The integer age of the Person
	 * @return int Returns the passed age
	 */
	public int setAge(int age) {
		if(validAge(age)) {
			this.age = age;
		}
		return age;
	}
	
	/**
	 * Getter for age of Person
	 * @return int Age of the Person
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Getter for the name of Person
	 * @return String Name of the Person
	 */
	public String getName() {
		return name;
	}
	
	//toString override
	public String toString() {
	    return getName() + " is " + getAge() + " years old.";
	}
	
	
	
	
	//Validates age given the set conditions
	private boolean validAge(int age) {
		if(age < 150 && age > 0) {
			return true;
		}
		return false;
	}
	
	//Validates name given the set conditions	
	private boolean validName(String name) {
		return !name.isEmpty();
	}
}
