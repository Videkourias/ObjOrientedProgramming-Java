/**
 * Sub class of Shape, keeps information of a rectangle
 * @author Dean Willavoys - 105003751
 * @since 2019-10-29
 */
public class Rectangle extends Shape {
    private double length; //Length of rectangle, greater than 0
    private double width; //Width of rectangle, greater than 0
    
    //Default constructor 
    public Rectangle() {
        width = 1;
        length = 1;
        setLabel("Rectangle");
    }
    
    //Overloaded constructor
    public Rectangle(double length, double width) {
        this();
        setWidth(width);
        setLength(length);
    }
    
    /**
     * Get method for length
     * @return double The length of the rectangle
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Get method for width
     * @return double The width of the rectangle
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * Setter for the length
     * @param length A double to set the length to
     * @return double Returns the passed double
     */
    public double setLength(double length) {
        if(validMagnitude(length)) {
            this.length = length;
        }
        return length;
    }
    
    
    /**
     * Setter for the width
     * @param width A double to set the width to
     * @return double Returns the passed double
     */
    public double setWidth(double width) {
        if(validMagnitude(width)) {
            this.width = width;
        }
        return width;
        
    }
    
    
    /**
     * Method to calculate of area of object
     * @return double Returns the area as a double
     */
    public double calculateArea() {
        return length * width; 
    }

}
