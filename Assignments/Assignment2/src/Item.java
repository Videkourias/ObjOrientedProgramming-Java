/**
 * Basic online store and shopping cart
 * @author Dean Willavoys - 105003751
 * @since 2019-11-12
 */
public abstract class Item implements java.io.Serializable{
    private static final long serialVersionUID = -6621632322323746507L; //Eclipse calculated UID
    private int itemID; //Uniqe item id, incremented with each object created
    private static int unique = 1; //Unique id generator 
    private double price; //Price of item, non-negative
    private int quantity; //Item quantity, non-negative
    private String Title; //Name of item, non-empty
    
    //Default constructor
    public Item() {
        itemID = unique++;
        price = 0.00; //defaults
        quantity = 0;
        Title = "DEFAULT_ITEM_TITLE";
    }
    
    //Overloaded constructor
    public Item(double price, int quantity, String Title) {
        this();
        setPrice(price);
        setQuantity(quantity);
        setTitle(Title);
    }
    
    /**
     * Setter for price attribute
     * @param price A double for the price of the object, non-negative
     * @return double Returns the price attribute of the item
     */
    public double setPrice(double price) {
        if(validNum(price)) {
            this.price = price;
        }
        return this.price;
    }
    
    /**
     * Setter for quantity attribute
     * @param quantity An int for the quantity of the item, non-negative
     * @return int Returns the quantity attribute of the item
     */
    public int setQuantity(int quantity) {
        if(validNum(quantity)) {
            this.quantity = quantity;
        }
        return this.quantity;
    }
    
    /**
     * Setter for title attribute
     * @param title The string name of the item, non-empty
     * @return String Returns the title of the item
     */
    public String setTitle(String Title) {
        if(validString(Title)) {
            this.Title = Title;
        }
        return this.Title;
    }
    
    /**
     * Getter for item price
     * @return double Returns the price of the item
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Getter for item quantity
     * @return int Returns the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Getter for item title
     * @return String Returns the title of the item
     */
    public String getTitle() {
        return Title;
    }
    
    /**
     * Getter for item id
     * @return int Returns the ID of the item
     */
    public int getID() {
        return itemID;
    }
    
    /**
     * Method to purchase an item and return its price
     * Removing the item is left to be handled by Store
     * @return double Returns the cost of purchasing the item
     */
    public double Purchase() {
        double cost = price * quantity;
        quantity = 0;
        return cost;
    }
    
    
    //Helper method to validate numbers(validates num is non-negative)
    protected boolean validNum(double num) {
        return num >= 0; 
    }
    //Overloaded validater
    protected boolean validNum(int num) {
        return num >= 0; 
    }
    
    //Helper method to validate Strings (validates string is non-empty)
    protected boolean validString(String s) {
        return !s.isEmpty();
    }
    
    
    //method to display item information
    public abstract void Display();
    
    
}
