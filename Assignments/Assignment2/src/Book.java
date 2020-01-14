/**
 * Book item
 * @author Dean Willavoys - 105003751
 * @since 2019-11-12
 */
import java.util.Comparator;

public class Book extends Item{
    private String author; //Author of the book, non-empty
    private String title; //Title of book, non-empty
    private int year; //Year released, non-negative
    
    
    //Default constructor
    public Book() {
        author = "DEFAULT_AUTHOR"; //Default values
        title = "DEFAULT_TITLE";
        year = 1970; //Epoch
    }

    //Overloaded constructor
    public Book(double price, int quantity, String author, String title, int year) {
        this();
        setAuthor(author);
        setTitle(title);
        setYear(year);
        super.setTitle("Book");
        setPrice(price);
        setQuantity(quantity);
    }
    
    
    /**
     * Setter for author of Book
     * @param author The string author name, has to be non-empty
     * @return String Return the author attribute of the Book
     */
    public String setAuthor(String author) {
        if(validString(author)) {
            this.author = author;
    
        }
        return this.author;
    }
    
    
    /**
     * Setter for title of Book
     * @param title The string title of the book, has to be non-empty
     * @return String Returns the title attribute of the Book 
     */
    public String setTitle(String title) {
        if(validString(title)) {
            this.title = title;
    
        }
        return this.title;
    }
    
    /**
     * Setter for the uear of Book
     * @param year The int year the book was released, non-negative
     * @return int Returns the year attribute of the Book
     */
    public int setYear(int year) {
        if(validNum(year)) {
            this.year = year;
        }
        return this.year;
    }
    
    /**
     * Getter for author attribute
     * @return String Returns the author attribute
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Getter for title attribute
     * @return String Returns the title attribute 
     */
    public String gettitle() {
        return title;
    }
    
    /**
     * Getter for the year attribute
     * @return int Returns the year attribute
     */
    public int getYear() {
        return year;
    }
    
    
    /**
     * Implementation of abstract method Display, outputs attributes of Book
     */
    public void Display() {
        System.out.println(getID() + ", " + getTitle() + "\nQ: " + getQuantity() + " P: $" + getPrice()); //General
        System.out.println(getAuthor() + ", " + gettitle() + ", " + getYear() + "\n"); //Specific
    }
    
    //Comparator for Books, using author attributes
    public static Comparator<Book> authorComparator = new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
            return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
        }
    };
    
}
