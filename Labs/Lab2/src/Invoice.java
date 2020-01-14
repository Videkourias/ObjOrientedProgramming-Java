import java.text.DecimalFormat;
import java.math.RoundingMode;
/**
Represents a bill calculated from an array of Item objects

@author Dean Willavoys - 105003751
@since 2019-09-21
*/
public class Invoice{
//ATTRIBUTES	
	private int numItems;	//The number of Items in the Item array
	private Item Item[]; //An array of Item objects
	
//METHODS
  //CONSTRUCTORS	
	/**
	 * Overloaded Constructor for invoice
	 * @param numItems The integer number of elements in the list, anything not greater than 0 causes zero elements in Invoice Item array
	 */
	public Invoice(int numItems){
		setNumItems(validateNumItems(numItems));
		setItems(this.numItems);
		populate(); //Populates the Items in Item
	} 

  //ACCESS
	/**
	 * Sets the numItems attribute to the passed value
	 * @param numItems An integer representing the number of Items in the Item array
	 * @return int The passed number of Items
	 */
	private int setNumItems(int numItems) {
		this.numItems = numItems;
		return numItems;
	}
	
	/**
	 * Populates the Item array with numItems empty Items
	 * @param numItems An integer number of items to put in the array
	 * @return int The number of Items populating the array
	 */
	private int setItems(int numItems) {
		this.Item = new Item[numItems];
		for(int i = 0; i < numItems; i++) {
			Item[i] = new Item();
		}
		return numItems;
	}
	
		
	/**
	 * Populates the items in the item array with user input using Item.populateItem
	 * @return int The number of items populated
	 */
	public int populate() {
		for(int i = 0; i < numItems; i++) {
			Item[i].populateItem(i + 1); //Calls the Item object populateItem method numItems times
		}
		return numItems;
	}
	


	
	/**
	 * Outputs the formatted invoice information to the user
	 * @return double The total of the invoice, unformatted
	 */
	public double bill() {
		double subTotal = calcTotal(Item, numItems);
		double tax = interest(subTotal, 6.25);
		double total = subTotal + tax;
		
		System.out.println("\nYour bill:");
		String output = String.format("%-30s%10s%10s%10s", "Item", "Quantity", "Price", "Total");
		System.out.println(output);
		for(Item i: Item) {
			output = String.format("%-30s%10d%10s%10s", i.getName(), i.getQuantity(), doubleFormat(i.getPrice()), doubleFormat(i.getTotal()));
			System.out.println(output);
		}
		
		output = String.format("%-50s%10s", "Subtotal", doubleFormat(subTotal));
		String taxOut = String.format("%-50s%10s", "6.25% sales tax", doubleFormat(tax));
		String totOut = String.format("%-50s%10s", "Total", doubleFormat(total));
		
		System.out.println("\n" + output + "\n" + taxOut + "\n" + totOut);
		
		return total;
	}
	
  //UTILITY

	
	/**
	 * Ensures that the number of items specified by the user is a valid amount, returns 0 if not
	 * @param num Integer entered by the user
	 * @return int Returns num parameter if valid, 0 otherwise
	 */
	private int validateNumItems(int num) {
		if(num > 0) {
			return num;
		}
		return 0;
	}
	
	
	//Outputs the information of all of the Items in the Item array, for DEBUG
	public void out() {
		for(int i = 0; i < numItems; i++) {
			System.out.println(i + ": " + Item[i].toString());
		}
	}

	/**
	 * Calculates the total cost of Items in items array before applying tax
	 * @param items Item object array, non-empty
	 * @param numItems Integer number of items in the items array, greater than 0
	 * @return double The summation of the costs of the objects
	 */
	private double calcTotal(Item[] items, int numItems){
		double total = 0; //The total price
		for(Item n: items){
			total += n.getTotal();
		}
		return total;
	}
	
	/**
	 * Calculates what 6.25% of the passed double is
	 * @param val A double to find 6.25% of
	 * @param rate A double representing interest rate, greater than zero
	 * @return double Returns 6.25% of val
	 */
	private double interest(double val, double rate) {
		return val * (rate/100.00);
	}
	
	
	/**
	 * Formats the passed integer so that it returns with 2 decimal points of precision, in String format
	 * @param num A double to be formatted
	 * @return String Returns the formatted double in String form
	 */
	private String doubleFormat(double num) {
		DecimalFormat df = new DecimalFormat("#.##"); //Formats decimal numbers with 2 points of precision
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		return df.format(num);
	}

}