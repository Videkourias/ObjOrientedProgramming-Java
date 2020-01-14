import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * Creates an interactive interface to interact with other obects present in package 
 * @author Dean Willavoys - 105003751
 * @since 2019-11-12
 */
public class Store{
    
    /**
     * Method to display option menu for user
     * Returns nothing, prints menu to standard out
     */
    public static void displayMenu() {
        System.out.print("\t\tMENU\n");
        System.out.print("1. Add item to inventory\n2. Display items\n3. Books sorted by Author\n");
        System.out.print("4. Gift cards sorted by Label\n5. Shoes sorted by size\n6. Delete item\n");
        System.out.print("7. Purchase item\n8. Save Inventory\n9. Load Inventory\n-1. Exit\nInput: ");
        
    }
    
    /**
     * Method to add an Item to an ArrayList
     * @param item The numberic representation of the type of item to be added to the ArrayList, bounded by 0 and 3 inclusive
     * @param al An ArrayList to add the item to
     * @return int Returns the numeric representation of the type of the item added
     */
    public static int addItem(int item, ArrayList<Item> al) {
        Scanner sc = new Scanner(System.in);
        int quantity; //Quantity of the item
        double price; //Price of the item
        switch(item) {
            case 0: //Cancel
                return item;
            case 1: //Book
                //Get title, author, and release from user
                System.out.print("Enter an author: ");
                String auth = sc.nextLine(); 
                System.out.print("Enter a title: ");
                String title = sc.nextLine();
                System.out.print("Enter a release year: ");
                int year = sc.nextInt();
                
                //Get price and quantity
                System.out.print("Enter the price of the item and the quantity: ");
                price = sc.nextDouble();
                quantity = sc.nextInt();
                
                al.add(new Book(price, quantity, auth, title, year)); //Add the book to the array
                break;
                
            case 2: //Gift Card
                //Get label and manufacturer
                System.out.print("Enter a label: ");
                String label = sc.nextLine();
                System.out.print("Enter a manufacturer: ");
                String manufacturer = sc.nextLine();
                
                //Get price and quantity
                System.out.print("Enter the price of the item and the quantity: ");
                price = sc.nextDouble();
                quantity = sc.nextInt();
                
                al.add(new GiftCard(price, quantity, label, manufacturer)); //Add the GiftCard to the array
                break;
                
            case 3: //Shoe
                //Get colour and size
                System.out.print("Enter a colour: ");
                String colour = sc.nextLine();
                System.out.print("Enter a size: ");
                int size = sc.nextInt();
                
                //Get price and quantity
                System.out.print("Enter the price of the item and the quantity: ");
                price = sc.nextDouble();
                quantity = sc.nextInt();
                
                al.add(new Shoe(price, quantity, colour, size)); //Add the shoe to the array
                break;
                
        }
        return item;
    }
    

    public static void main(String[] args) {
        int input; //User input var
        ArrayList<Item> inventory = new ArrayList<Item>(); //List of items
        Scanner sc = new Scanner(System.in);
        double cost = 0; //Total amount spent
        boolean shopping = true; //boolean to keep user in menu
    
        
        while(shopping) {
            displayMenu(); //Display options
        
            try { //Get user choice
                input = sc.nextInt();
            }
            catch(InputMismatchException e){ //catches invalid type errors
                continue;
            }
            if(input != -1 && (input > 9 || input < 1)) continue; //catches out of bound errors
            
            
            switch(input) { //User choice menu
                case -1: //Exit from program
                    shopping = false;
                    break;
                    
                case 1: //Add item to inventory
                    System.out.print("\n0 - Cancel\n1 - Book\n2 - Gift Card\n3 - Shoe\n");
                    int choice;
                    while(true) { //Gets valid choice from user
                            System.out.print("Enter the number of the item you would like to add: ");
                            choice = sc.nextInt();
                            if(-1 < choice && choice < 4) { //If choice is in valid range (0,3)
                                break;
                            }
                            System.out.println("Enter a valid number");
                    }
                    while(true) { //Try catch loop that calls addItem function
                        try {
                            addItem(choice, inventory);
                            break;
                        }
                        catch(InputMismatchException e) { //Exception if type doesn't match
                            System.out.println("Input of invalid type");
                        }
                    }
                    break;
                        
                case 2: //Displays all items in inventory
                    for(Item i: inventory) {
                        i.Display();
                    }
                    break;
                    
                case 3: //Displays only books, sorted by author name
                    ArrayList<Book> books = new ArrayList<>();
                    for(Item i: inventory)  //Loops through entire inventory
                        if(i.getTitle().compareTo("Book") == 0) {  //Adds only books to new Array List
                            books.add((Book)i);}
                        
                    books.sort(Book.authorComparator); //Sorts books by author
                    
                    for(Book b: books) //Prints the books
                        b.Display();
                    
                    break;
                    
                case 4: //Displays only gift cards, sorted by label
                    ArrayList<GiftCard> cards = new ArrayList<>();
                    for(Item i: inventory)  //Loops through entire inventory
                        if(i.getTitle().compareTo("Gift Card") == 0) {  //Adds only gift cards to new Array List
                            cards.add((GiftCard)i);}
                        
                    cards.sort(GiftCard.labelComparator); //Sorts gift cards by label
                    
                    for(GiftCard g: cards) //Prints the gift cards
                        g.Display();
                    break;
                    
                case 5: //Displays only shoes, sorted by size
                    ArrayList<Shoe> shoes = new ArrayList<>();
                    for(Item i: inventory)  //Loops through entire inventory
                        if(i.getTitle().compareTo("Shoe") == 0) {  //Adds only shoes to new Array List
                            shoes.add((Shoe)i);}
                        
                    shoes.sort(Shoe.sizeComparator); //Sorts shoes by size
                    
                    for(Shoe s: shoes) //Prints the shoes
                        s.Display();
                    break;
                    
                case 6: //Removes item with given id
                    System.out.print("Enter the id of the item you would like to remove: ");
                    try { //Tries to remove element matching given id
                        int id = sc.nextInt();
                        for(int i = 0; i < inventory.size(); i++) {
                            if(inventory.get(i).getID() == id)
                                inventory.remove(inventory.get(i));
                        }
                        
                    }
                    catch(IndexOutOfBoundsException e) {
                        System.out.println("No such element");
                    }
                    break;
                    
                case 7: //Removes one of an item and adds its price to cost, removes item from inventory if quantity is zero or less
                    System.out.print("Enter the ID of the item you would like to purchase: ");
                    try { //Tries to remove one of the specified item
                        int id = sc.nextInt();
                        for(int i = 0; i < inventory.size(); i ++) { //loop through inventory
                            if(inventory.get(i).getID() == id) { //if item has ID that matches user input
                                cost += inventory.get(i).Purchase(); 
                                inventory.remove(i);
                            }
                        }
                        
                    }
                    catch (IndexOutOfBoundsException e) { //Invalid index
                        System.out.println("Index error");
                    }
                    catch (InputMismatchException e) { //Invalid type
                        System.out.println("Invalid input type");
                    }
                    break;
                    
                case 8: //Save inventory to file (serialization)
                    System.out.print("Provide a valid file name to write to: ");
                    try { //Tries to open file and write object to it
                        String fileName = sc.next();
                        FileOutputStream file = new FileOutputStream(fileName); //Initialize streams
                        ObjectOutputStream out = new ObjectOutputStream(file);
                        
                        out.writeObject(inventory); //Write object
                        
                        out.close(); //Close streams
                        file.close();
                    }
                    catch(IOException e) {
                        System.out.println("IOException, aborting...");
                        break;
                    }
                    System.out.println("Data saved to file successfully");
                    break;
                    
                case 9: //Load inventory from file (deserialization)
                    System.out.print("Provide a valid file name to read from: ");
                    try { //Tries to open file and read object from it
                        String fileName = sc.next();
                        FileInputStream file = new FileInputStream(fileName); //Initialize streams
                        ObjectInputStream in = new ObjectInputStream(file);
                        
                        inventory = (ArrayList<Item>)in.readObject(); //Read object
                        
                        in.close(); //Close streams
                        file.close();
                    }
                    catch(IOException e) {
                        System.out.println("IOException, aborting...");
                        break;
                    }
                    catch(ClassNotFoundException e) {
                        System.out.println("ClassNotFoundException, aborting...");
                        break;
                    }
                    System.out.println("Data read from file successfully");
                    break;
            }
        }
        System.out.println("You spent $" + cost + "!\nCome Again!");
        sc.close();
    }
}
