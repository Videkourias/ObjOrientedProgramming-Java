/**
 * Shoe item
 * @author Dean Willavoys - 105003751
 * @since 2019-11-12
 */
import java.util.Arrays;
import java.util.Comparator;

public class Shoe extends Item {
    private String colour; //The colour of the shoe, only valid if contained in the colours array, white by default
    private double size; //Size of shoe, positive
    private String colAr[] = {"white", "silver", "red", "beige", "brown", "blue", "black", "pink"}; //Valid colours from outline
    
    //Default constructor
    public Shoe() {
        colour = "DEFAULT_COLOUR"; //Defaults
        size = 1;
    }
    
    //Overloaded constructor
    public Shoe(double price, int quantity, String colour, int size) {
        this();
        setColour(colour);
        setSize(size);
        setTitle("Shoe");
        setPrice(price);
        setQuantity(quantity);
    }
    
    /**
     * Setter for colour attribute
     * @param colour A String indicating colour of Shoe, only valid if contained in list of valid colours specified by outline
     * @return String Returns the colour of the Shoe
     */
    public String setColour(String colour) {
        if(Arrays.asList(colAr).contains(colour.toLowerCase())) { //if colour is contained in valid colour array
            this.colour = colour;
        }
        return this.colour;
    }
    
    /**
     * Setter for size attribute
     * @param size An int representing the size of the Shoe, greater than 0
     * @return int Returns the size of the shoe
     */
    public double setSize(int size) {
        if(size > 0) {
            this.size = size;
        }
        return this.size;
    }
    
    /**
     * Getter for colour attribute
     * @return String Returns the colour of the Shoe
     */
    public String getColour() {
        return colour;
    }
    
    
    /**
     * Getter for size attribute
     * @return int Returns the size of the Shoe
     */
    public double getSize() {
        return size;
    }
    
    
    /**
     * Implementation of abstract method Display, outputs attributes of Shoe
     */
    public void Display() {
        System.out.println(getID() + ", " + getTitle() + "\nQ: " + getQuantity() + " P: $" + getPrice()); //General
        System.out.println(getColour() + ", " + getSize() + "\n"); //Specific
    }

    //Comparator for Shoe, using size attribute
    public static Comparator<Shoe> sizeComparator = new Comparator<Shoe>() {
        public int compare(Shoe s1, Shoe s2) {
            return s1.getSize() < s2.getSize() ? -1 : (s1.getSize() == s2.getSize() ? 0 : 1); //Identical to compareTo method, using int instead
        }
    };

}
