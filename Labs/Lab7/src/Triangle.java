/**
 * Sub class of Shape, keeps information of a triangle
 * @author Dean Willavoys - 105003751
 * @since 2019-10-29
 */
public class Triangle extends Shape{
    private double base; //Base of triangle, greater than 0
    private double height; //Height of triangle, greater than 0
    
    //Default constructor 
    public Triangle() {
        base = 1;
        height = 1;
        setLabel("Triangle");
    }
    
    //Overloaded constructor
    public Triangle(double base, double height) {
        this();
        setBase(base);
        setHeight(height);
    }
    
    
    /**
     * Getter method for the base attribute
     * @return double Returns the base length of the object
     */
    public double getBase() {
        return base;
    }
    
    /**
     * Getter method for height attribute
     * @return double Returns the height of the object
     */
    public double getHeight() {
        return height;
    }
    
    
    /**
     * Setter method for base attribute
     * @param base A double representing triangle's base length
     * @return double Returns the passed double
     */
    public double setBase(double base) {
        if(validMagnitude(base)) {
            this.base = base;
        }
        return base;
    }
    
    /**
     * Setter method for height attribute
     * @param height A double representing height of the triangle
     * @return double Returns the passed double
     */
    public double setHeight(double height) {
        if(validMagnitude(height)) {
            this.height = height;
        }
        return height;
    }
    
 
    /**
     * Method to calculate area of the the object
     * @param double Returns the area as a double
     */
    public double calculateArea() {
        return (base * height)/2;
    }
    
}
