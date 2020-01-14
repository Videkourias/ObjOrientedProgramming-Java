/**
    Human player in Tic Tac Toe game
    @author Dean Willavoys - 105003751
    @since Nov, 13 2019 
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player implements Global{

    //Default constructor
    public HumanPlayer() {
        super();
    }
    
    
    /**
     * Method to allow human player to make a move
     * @param gameBoard Takes a Board as input to act on
     * @throws InputMismatchException User input is not of valid type
     * @throws IndexOutOfBoundsException User input not within scope of gameboard
     */
    public void play(Board gameBoard) throws IndexOutOfBoundsException, InputMismatchException {
        Scanner sc = new Scanner(System.in);
        boolean valid = false; //Whether or not the x y position is valid(unoccupied, in range)
        int x, y;  //x and y positions on the game board
        
        while(!valid) {
            System.out.print(getName() + ", enter the coordinates of the cell you want to claim: ");
        
            //Get an X and Y from the user
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        
            if(x < 0 || x > size -1 || y < 0 || y > size - 1) { //X or Y exceed given bounds
                throw new IndexOutOfBoundsException();
            }

            valid = gameBoard.makeMove(x, y, this.getSymbol(), false); //Check if choice was valid
        }
    }

}
