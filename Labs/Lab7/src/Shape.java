/**
 * Abstract class for shape object
 * @author Dean Willavoys - 105003751
 * @since 2019-10-29
 */
public abstract class Shape implements Comparable<Shape> {
    private static int unique = 0; //Unique id's
    private int id; //A unique integer ID 
    private String label;
    
    //Default Constructor
    public Shape() {
        label = "DEFAULT_OBJECT_LABEL";  //Default label
        id = ++unique;  //Unique ID
    }
    
   /**
    * Getter for label attribute
    * @return String Returns the label of the shape
    */
    public String getLabel() {
        return label;
    }
    
    /**
     * Getter for id attribute
     * @return int Returns the id of the shape
     */
    public int getId() {
        return id;
    }
    
    
    /**
     * Setter for label of shape
     * @param label The label of the object
     * @return String Returns the label of object
     */
    public String setLabel(String label) {
        if(!label.isEmpty()) {
            this.label = label;
        }
        return label;
    }
    
    
    /**
     * Abstract method to calculate the area of shape
     * @return double The area of the given shape
     */
    abstract public double calculateArea();
    
    /**
     * Implements compareTo method of Comparable interface
     * Appears in parent class to be inherited
     * @param Shape Takes a shape object
     * @return int Returns the same as Java standard compareTo
     */
    public int compareTo(Shape s) {
        if(calculateArea() == s.calculateArea()) {
            return 0;
        }
        else if(calculateArea() > s.calculateArea()) {
            return -1;
        }
        else {
            return 1;
        }
    }
    
    
    
    //Checks that the given int is positive
    protected boolean validMagnitude(int num) {
        return num > 0;
    }
    
    //Checks that the given double is positive
    protected boolean validMagnitude(double num) {
        return num > 0.0;
    }
    
    //Checks that the given String is non-empty
    protected boolean validString(String s) {
        return !s.isEmpty();
    }
    
    
}
