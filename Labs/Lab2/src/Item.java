import java.util.*;

/**
Represents an item with a price, name, and quantity
@author Dean Willavoys - 105003751
@since 2019-09-21
*/
public class Item {
//ATTRIBUTES
	private String name; //Name of item, non-empty
	private int quantity; //Quantity of item, greater than 0
	private double price; //Price of item, greater than 0


//METHODS
  //CONSTRUCTORS

	/**
	 * Default Constructor for Item object 
	 */
	public Item(){
		name = "ITEM_01";
		quantity = 0;
		price = 0.00;
	}

	/**
	 * Overloaded Constructor
	 * @param name A non-empty string, the products name
	 * @param quantity Integer quantity of the product, greater than 0
	 * @param price Double price of the product, greater than 0
	 */
	public Item(String name, int quantity, double price){
		this(); //Bad entry prevention
		setName(name);
		setQuantity(quantity);
		setPrice(price);
	}

  //ACCESS
	/**
	 * Gets the parameters of this item from the user and sets them using private methods
	 * @param n An integer representing the number of the item to be populated
	 * @return int The number of the item that was populated
	 */
	public int populateItem(int n) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input name of item " + n + ": ");
		setName(sc.nextLine());
		
		System.out.print("Input quantity of item " + n + ": ");
		setQuantity(sc.nextInt());
		
		System.out.print("Input price of item " + n + ": ");
		setPrice(sc.nextDouble());
		
		return n;
		
	}
	/**
	 * Sets the name of the Item, does nothing if name is empty
	 * @param name A string for the name of the item
	 * @return String Returns the passed name
	 */
	private String setName(String name){
		if(!name.isEmpty()){
			this.name = name;
		}
		return name;
	}	

	/**
	 * Sets the quantity of the Item, does nothing if quantity is less than or equal to zero
	 * @param quantity An integer for Item quantity
	 * @return int Returns the passed quantity
	 */
	private int setQuantity(int quantity){
		if(quantity > 0){
			this.quantity = quantity;
		}
		return quantity;
	}	

	/**
	 * Sets the price of the Item, does nothing if price is less than or equal to zero
	 * @param price A double for the price of the item
	 * @return double Returns the passed price
	 */
	private double setPrice(double price){
		if(price > 0){
			this.price = price;
		}
		return price;
	}





	/**
	 * Gets the name of the item
	 * @return String The name of the item
	 */
	public String getName(){
		return name;
	}	

	
	/**
	 * Gets the quantity of the item
     * @return int The quantity of the item
	 */
	public int getQuantity(){
		return quantity;
	}

	
	/**
	 * Gets the price of the item
	 * @return double The price of the item
	 */
	public double getPrice(){
		return price;
	}

	/**
	 * Gets the total cost of the Item based on quantity
	 * @return double The total cost of the item
	 */
	public double getTotal() {
		return calcTotal();
	}

  //UTILITY
	/**
	 * Overrides default toString method, instead returns attributes of Item object
 	 * @return String - Returns the attributes of the object passed
	 */ 
	public String toString(){
		return name + "\t" + quantity + "\t$" + price + "\t" + calcTotal();
	}
	
	/**
	 * Calculates the total cost of an item based on quantity
	 * @return double The total cost of the item
	 */
	private double calcTotal() {
		double total = 0.0;
		for(int i = 0; i < quantity; i++) {
			total += price;
		}
		return total;
	}

}