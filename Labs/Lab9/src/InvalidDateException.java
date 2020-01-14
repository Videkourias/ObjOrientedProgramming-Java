/**
 * Exception to be thrown when date is evaluated to be invalid
 * @author Dean Willavoys - 105003751
 * @since 2019-11-26
 */
public class InvalidDateException extends Exception {
    public InvalidDateException() {
        super("Invalid Date");
    }
    
    public InvalidDateException(String errorMessage) {
        super(errorMessage);
    }
}
