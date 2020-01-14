/**
 * Sub class of Shape, keeps information of a circle
 * @author Dean Willavoys - 105003751
 * @since 2019-10-29
 */
public class Circle extends Shape {
    private double radius; //Radius of the circle, greater than 0
    
    //Default constructor 
    public Circle() {
        radius = 1;
        setLabel("Circle");
    }
    
    //Overloaded constructor
    public Circle(double radius) {
        this();
        setRadius(radius);
    }
    
    /**
     * Get method for radius
     * @return double The radius of the circle
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Setter for the radius
     * @param radius A double to set the radius to
     * @return double Returns the passed double
     */
    public double setRadius(double radius) {
        if(validMagnitude(radius)) {
            this.radius = radius;
        }
        return radius;
    }
    
    /**
     * Method to calculate of area of object
     * @return double Returns the area as a double
     */
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2); //Returns pi * r^2
    }

}
