/**
 * Gift card item
 * @author Dean Willavoys - 105003751
 * @since 2019-11-12
 */
import java.util.Comparator;

public class GiftCard extends Item {
    private static final long serialVersionUID = 3105668572760458588L;
    private String label; //Identification label, non-empty
    private String manufacturer; //Manufacturer of gift card, non-empty
    
    //Default constructor
    public GiftCard() {
        label = "DEFAULT_LABEL"; //Defaults
        manufacturer = "DEFAULT_MANUFACTURER";
    }
    
    //Overloaded constructor
    public GiftCard(double price, int quantity, String label, String manufacturer) {
        this();
        setLabel(label);
        setManufacturer(manufacturer);
        setTitle("Gift Card");
        setPrice(price);
        setQuantity(quantity);
    }
    
    /**
     * Setter for label attribute
     * @param label String for identification of gift card, has to be non-empty
     * @return String Returns the value of the label attribute
     */
    public String setLabel(String label) {
        if(validString(label)) {
            this.label = label;
        }
        return this.label;
    }
    
    /**
     * Setter for manufacturer attribute
     * @param manufacturer String for name of manufacturer, has to be non-empty
     * @return String Returns the value of the manufacturer attribute
     */
    public String setManufacturer(String manufacturer) {
        if(validString(manufacturer)) {
            this.manufacturer = manufacturer;
        }
        return this.manufacturer;
    }
    
    /**
     * Getter for the label attribute
     * @return String Returns the value of the label attribute
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * Getter for the manufacturer attribute
     * @return String Returns the value of the manufacturer attribute
     */
    public String getManufacturer() {
        return manufacturer;
    }
    
    
    /**
     * Implementation of abstract method Display, outputs attributes of GiftCard
     */
    public void Display() {
        System.out.println(getID() + ", " + getTitle() + "\nQ: " + getQuantity() + " P: $" + getPrice()); //General
        System.out.println(getLabel() + ", " + getManufacturer() + "\n"); //Specific
    }
    
    //Comparator for GiftCard, using label attribute
    public static Comparator<GiftCard> labelComparator = new Comparator<GiftCard>() {
        public int compare(GiftCard g1, GiftCard g2) {
            return g1.getLabel().compareToIgnoreCase(g2.getLabel());
        }
    };
}
