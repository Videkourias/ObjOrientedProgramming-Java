import java.util.Arrays;
import java.util.Random;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 * Driver class for the rest of the lab
 * @author Dean Willavoys - 105003751
 * @since 2019-10-29
 */
public class DrawingApp {
    public static void main(String[] args) {
        Random rm = new Random();
        DecimalFormat df = new DecimalFormat("#.##"); //Formats decimal numbers with 2 points of precision
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        Shape shapeList[] = new Shape[10];      //Creates an array of 10 shapes
        
        for(int i = 0; i < 10; i++) { //Creating 10 shapes
            int shape = rm.nextInt(3);  //Random shape
            switch(shape) {
                case 0:     //New circle of random radius between 0 and 99, inclusive 
                    shapeList[i] = new Circle(rm.nextInt(100));
                    break;
                case 1:         //New rectangle with random length and width between 0 and 99, inclusive
                    shapeList[i] = new Rectangle(rm.nextInt(100), rm.nextInt(100));
                    break;
                case 2:         //New triangle with random base and height between 0 and 99, inclusive
                    shapeList[i] = new Triangle(rm.nextInt(100), rm.nextInt(100));
                    break;
            }
            System.out.print(shapeList[i].getId() + ": ");
            System.out.println(shapeList[i].getLabel() + " is of area " + df.format(shapeList[i].calculateArea()));
        }
        
        
        
        double totArea = 0; //Total area of all shapes
        for(Shape s: shapeList) {
            totArea += s.calculateArea();
        }
        
        

        System.out.println("Total area is: " + df.format(totArea));
        
        Arrays.sort(shapeList); //Sort Shape array and output results
        for(Shape s: shapeList) {
            System.out.print("[" + s.getId() + ":" + df.format(s.calculateArea()) + "]");
        }
    }
}
