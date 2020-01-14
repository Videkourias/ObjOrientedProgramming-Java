/**
    Represents the board of the tic tac toe game
    @author Dean Willavoys - 105003751
    @since Nov, 13 2019 
*/

public class Board implements Global{
    private String gameState; //condition of the board, can be EMPTY, X, O, DRAW
    private Block[][] board; //cells of the board
    private int openRemain = size * size; //Records the number of cells left open
    
    private int lastX; //Records the most recently interracted with x
    private int lastY; //Records the most recently interracted with y
    private String lastSymbol; //Records the player who last moved
    
    
      
    
    
    //Default constructor
    public Board(){
        gameState = "EMPTY";    
        board = new Block[size][size];
        for(int i = 0; i < size; i++){ //Initialize the states of all Blocks to EMPTY
            for(int j = 0; j < size; j++) {
                board[i][j] = new Block();
            }
        }
    }


    /**
     * Getter for gameState attribute
     * @return String Returns the current gameState
     */
    public String getState() {
        return gameState;
    }

    /**
     * Changes the value of a block on the game board
     * @param x The x position of the block to be changed, 0 to 2 inclusive
     * @param y The y position of the block to be changed, 0 to 2 inclusive
     * @param symbol The symbol of the player making the move
     * @param AI True if calling Player is AI, on such a case certain error messages are omitted from output
     * @return boolean Returns true on success, false if block is occupied
     */
    public boolean makeMove(int x, int y, String symbol, boolean AI){
        if(board[x][y].getState().compareTo("EMPTY") != 0) { //space occupied
            if(!AI) //Only give error message when human makes error
                System.out.println("Space Occupied");
            return false;
        }
        else {
            board[x][y].setState(symbol); //Updates symbol
            
            lastX = x; //Records position of newest symbol placement
            lastY = y;
            lastSymbol = symbol;
            
            openRemain--; //Lowers the number of remaining spaces
            return true;
        }
    }

    /**
     * Surveys the game board and updates its state accordingly
     * @return String Returns the updated state of the board, or the previous one if nothing has changed
     * 
     */
    public String updateState() {
        int minMoves = 2 * size - 1; //Calculates the min number of moves that have to be made for a win to occur
        if(openRemain > (size*size) - minMoves) return gameState; //Can not have won without a certain number of moves having been played
        boolean row = true;
        boolean col = true;
        boolean diag1 = true;
        boolean diag2 = true;
        
        
        for(int i = 0; i < size; i++) {
            if(board[i][lastY].getState().compareTo(lastSymbol) != 0) { //If the cells in the row of the newly updated cell are
                row = false;                                            // not identical, win condition not met 
            }
            if(board[lastX][i].getState().compareTo(lastSymbol) != 0) { //If the cells in the column of the newly updated cell are
                col = false;                                            // not identical, win condition not met
            }
            if(board[i][i].getState().compareTo(lastSymbol) != 0) { //Check left to right diagonal using same method as above
                diag1 = false;
            }
            if(board[i][(size-1)-i].getState().compareTo(lastSymbol) != 0) { //Check right to left diagonal using same method as above
                diag2 = false;
            }
        }
        
        
        if(row || col || diag1 || diag2) { //If at least one is still true, win condition has been met
            gameState = lastSymbol;
        }
        
        
        if(openRemain == 0 && gameState.compareTo("EMPTY") == 0) { //Conidtion for a DRAW game
            gameState = "DRAW";
        }
        return gameState;
    }
    
    /**
     * Method that determines state of the specified cell
     * @param x The integer x position of the cell
     * @param y The integer y position of the cell
     * @return String Returns the current state of the block
     */
    public String getBlockState(int x, int y) {
        return board[x][y].getState();
    }
    
    
    /**
     * Method to print the game board to standard out
     */
    public void display() {
        for(Block[] row: board) {
            for(Block b: row) { 
                    System.out.print("[" + b + "]"); //Loops through board array and prints, formated
            }
            System.out.print("\n");
        }
    }
    
    
}



