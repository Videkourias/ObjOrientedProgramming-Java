/**
 * HourlyWorker class, extends Employee
 * @author Dean Willavoys - 105003751
 * @since 2019-10-8
 */
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class HourlyWorker extends Employee {
    int numHours;       //Positive, number of hours worked in a given week
    double hourlyRate;  //Positive, amount paid per hour
    
    public HourlyWorker() {
        super();
        numHours = 1;   //Defaults
        hourlyRate = 0.1;
    }
    
    //Overloaded constructor for hourlyWorker
    public HourlyWorker(String name, int age, int yearHired, int numHours, double hourlyRate) {
        this();
        setName(name);
        setAge(age);
        setHired(yearHired);
        setHours(numHours);
        setRate(hourlyRate);
    }
    
    
    /**
     * Setter for number of hours worked
     * @param numHours An integer representing the number of hours a worker worked in a given week
     * @return int Returns the passed number of hours
     */
    public int setHours(int numHours) {
        if(validate(numHours)) {
            this.numHours = numHours;
        }
        return numHours;
        
    }
    
    /**
     * Setter for hourly rate
     * @param hourlyRate A double representing the hourly rate of the worker
     * @return double Returns the passed hourly rate
     */
    public double setRate(double hourlyRate) {
        if(validate(hourlyRate)) {
            this.hourlyRate = hourlyRate;
        }
        return hourlyRate;
    }
    
    /**
     * Getter for employee hours worked
     * @return int The number of hours worked
     */
    public int getHours() {
        return numHours;
    }
    
    /**
     * Getter for employee rate
     * @return double The rate of the employee
     */
    public double getRate() {
        return hourlyRate;
    }
    
    
  /**
   * Process that calculates and outputs the pay of the employee for a given week. Sets hours worked to 0
   */
    public void PayWorker() {
        if(numHours == 0) { //Condtion for already calculated
            System.out.println(getName() + " has already been paid and needs to work more hours this week.");
            return;
        }
    //    super.PayWorker();
        
        DecimalFormat df = new DecimalFormat("#.##"); //Formats decimal numbers with 2 points of precision
        df.setRoundingMode(RoundingMode.HALF_UP);
  
        double pay = getHours() * getRate();
        numHours = 0;
        System.out.println(getName() + " is an hourly worker and is paid $" + df.format(pay));
    }
    
    
    //toString Override
    public String toString() {
        return getName() + " was hired in " + getYearHired() + " and is " + getAge() + " years old";
    }
    
    //Function to ensure passed int is positive
    private boolean validate(int numHours){
        return numHours > 0;        
    }
    
    //Function to ensure passed double is positive
    private boolean validate(double hourlyRate) {
        return hourlyRate > 0;
    }
    
    
    
}
