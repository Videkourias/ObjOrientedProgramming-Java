/**
 * Class that holds basic person information
 * @author Dean Willavoys - 105003751
 * @since 2019-11-26
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Name implements Comparable<Name>{
    private String fname; //First name, non-empty
    private String lname; //Last name, non-empty
    private String dob; //Date of birth, mm/dd/yyyy
    
    //Default constructor
    public Name() {
        fname = "DEFAULT_FNAME";
        lname = "DEFAULT_LNAME";
        dob = "01/01/0001";
    }
    
    //Overloaded Constructor, throws InvalidDateException if date is invalid
    public Name(String fname, String lname, String dob) throws InvalidDateException{
        this();
        setFname(fname);
        setLname(lname);
        setDob(dob);
    }
    
    //Copy constructor
    public Name(Name n) {
        fname = n.getFname();
        lname = n.getLname();
        dob = n.getDob();
    }
    
    /**
     * Setter for fname attribute
     * @param fname A string representing first name, non-empty
     * @return String Returns the fname attribute of the Name
     */
    public String setFname(String fname) {
        if(!fname.isEmpty()) {
            this.fname = fname;
        }
        return this.fname;
    }
    
    /**
     * Setter for the lname attribute
     * @param lname A string representing last name, non-empty
     * @return String Returns the lname attribute of the Name 
     */
    public String setLname(String lname) {
        if(!lname.isEmpty()) {
            this.lname = lname;
        }
        return this.lname;
    }
    
    /**
     * Setter for the dob attribute
     * @param dob A string representing date of birth, non-empty, valid(mm/dd/yyyy)
     * @return String Returns the dob attribute of the Name
     * @throws InvalidDateException When dob is invalid
     */
    public String setDob(String dob) throws InvalidDateException{
        if(validDate(dob, "MM/dd/yyyy")) {
            this.dob = dob;
            return this.dob;
        }
        else {
            throw new InvalidDateException();
        }
    }
    
    
    /**
     * Getter for fname
     * @return String Returns the fname attribute
     */
    public String getFname() {
        return fname;
    }
    
    
    /**
     * Getter for lname
     * @return String Returns the lname attribute
     */
    public String getLname() {
        return lname;
    }
    
    /**
     * Getter for dob
     * @return String Returns the dob attribute
     */
    public String getDob() {
        return dob;
    }
    
    /**
     * Private method to test if passed date is valid according to the given format
     * @param date A String date to test, non-empty
     * @param format A String to test the date against, non-empty
     * @return Boolean Returns true if date is valid, false otherwise
     */
    private Boolean validDate(String date, String format) {
        if(date == null || date.isEmpty()) {
            return false;
        }
        SimpleDateFormat dformat = new SimpleDateFormat(format); //Creates a date format given the passed format
        dformat.setLenient(false);
        
        try {
            Date d = dformat.parse(date); //Validates the passed date
        }
        catch(ParseException e) { //Catches the exception and returns false as date is not valid
            return false;
        }
        
        return true;
    }
    
    /**
     * Abstract method implementation for Comparable interface
     * Compares by last name, and then first name if equal(descending)
     */
    public int compareTo(Name n) {
        int c = lname.compareTo(n.getLname());
        
        if(c == 0) {
            return -(fname.compareTo(n.getLname()));
        }
        else if(c > 0) {
            return -1;
        }
        else {
            return 1;
        }
        
    }
    
    //toString override
    public String toString() {
        return getFname() + ", " + getLname() +", " + getDob();
    }
    
    
}
