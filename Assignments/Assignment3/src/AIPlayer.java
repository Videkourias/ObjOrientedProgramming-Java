/**
    Computer player in Tic Tac Toe game
    @author Dean Willavoys - 105003751
    @since Nov, 13 2019 
*/
import java.util.Random;
public class AIPlayer extends Player implements Global{
    private int complexity;
   

    //Default constructor
    public AIPlayer(){
        super();
        complexity = 1;
    }
    
    public AIPlayer(int complexity) {
        this();
        this.complexity = complexity;
    }


    /**
     * Method to allow AI player to make a move, randomly chooses a position
     * @param gameBoard Takes a Board to act on as input
     */
    public void play(Board gameBoard){
        switch(complexity) {
            case 1: //Random 
                randomMove(gameBoard); //Simply chooses position at random
                break;
            case 2: //Tries to find win, if not tries to block, if not chooses randomly
                int viaX = -1; //The current most viable x y coordinate
                int viaY = -1;
                for(int i = 0; i < size; i++) { //Check every cell
                    for(int j = 0; j < size; j++) {
                        int v = viable(i,j,gameBoard); //Get viability of current cell
                        if(v == 2) { //Immediatly claim if cell has win viability
                            gameBoard.makeMove(i, j, getSymbol(), true); 
                            System.out.println(getName() + " claimed " + (i + 1) + " " + (j + 1));
                            return;
                        }
                        else if(v == 1) { //Note that current space has defence viability, may be claimed later if better space not found
                            viaX = i;
                            viaY = j;
                        }
                    }
                }
                if(viaX == -1) { //If viable coordinates unchanged, move randomly
                    randomMove(gameBoard);
                    return;
                }
                gameBoard.makeMove(viaX, viaY, getSymbol(), true); //Makes a defending move
                System.out.println(getName() + " claimed " + (viaX + 1) + " " + (viaY + 1));
        }
    }

    
    /**
     * Method to randomly choose and claim a cell on the passed Board
     * @param gameBoard A Board to act upon
     */
    private void randomMove(Board gameBoard) {
        Random rm = new Random();
        boolean valid = false;
        int x, y;
        do{
            x = rm.nextInt(size); //Randomly chooses X and Y
            y = rm.nextInt(size);
            valid = gameBoard.makeMove(x,y, getSymbol(), true); //Returns whether or not the move was valid
        }while(!valid);
        System.out.println(getName() + " claimed " + (x + 1) + " " + (y + 1)); //For clarity in output
    }

    
    /**
     * Method to test the viability of claiming a cell by comparing the cells around it
     * @param x The int x position of the cell
     * @param y The int y position of the cell
     * @param gameBoard A Board to act upon
     * @return int Returns the viability of the space, from 0 to 2, 2 being the greatest
     */
    private int viable(int x, int y, Board gameBoard) {
        if(!gameBoard.getBlockState(x,y).equals("EMPTY")) return 0; //If cell is taken, then it is not valid
        
        
        int countXR = 0; //Number of X's and O's in row
        int countOR = 0; 
        
        int countXC = 0; //Number of X's and O's in column
        int countOC = 0;
        
        int countXD1 = 0; //Diagonal X and O count
        int countOD1 = 0; 
        
        int countXD2 = 0; //2nd diagonal X and O count
        int countOD2 = 0;
        
        
        //Analysis of current cell
        for(int i = 0; i < size; i++) { //Tests the surrounding blocks
            if(gameBoard.getBlockState(i, y).equals("X")) countXC++; //Counts column of current cell
            else if(gameBoard.getBlockState(i, y).equals("O")) countOC++;
            
            if(gameBoard.getBlockState(x, i).equals("X")) countXR++; //Counts row of current cell
            else if(gameBoard.getBlockState(x, i).equals("O")) countOR++;

            if(x == y) { //Only tests the below if cell is on diagonal
                if(gameBoard.getBlockState(i, i).equals("X")) countXD1++; //Counts left diagnoal
                else if(gameBoard.getBlockState(i, i).equals("O")) countOD1++;
            }    
            else if(x == ((size-1) - y)) { //Only tests if cell is on other diagonal
                if(gameBoard.getBlockState(i, (size-1) - i).equals("X")) countXD2++; //Counts right diagonal
                else if(gameBoard.getBlockState(i, (size-1) - i).equals("O")) countOD2++;
        
            }
        }
        

        
        //Decision of viability based on previous analysis
        int des = size - 1; //Desired amount of occupied cells surrounding current cell for viability to be > 0
        /* ie.
         *  - - -
         *  x - x
         *  - - -
         *  If any 2(des) cells in any row, column, or diagonal are of the same type (like above), the third cell in that
         *  row, col, diag has some viability. If the occupied cells are of the same type as the caller, viability is 2(win),
         *  if they are both of the opposite type then viability is 1(block). In any other case viability is 0.
         */
        
        if(getSymbol().equals("X")) { //Case for player X
            if(countXC == des || countXR == des || countXD1 == des || countXD2 == des) return 2; //Possible win
            else if(countOC == des || countOR == des || countOD1 == des || countOD2 == des) return 1; //Possible block
        }
        
        else { //Case for player Y
            if(countOC == des || countOR == des || countOD1 == des || countOD2 == des) return 2; //Possible win
            else if(countXC == des || countXR == des || countXD1 == des || countXD2 == des) return 1; //Possible block
        }
        
        return 0; //Returns 0(no viability) if nothing better found
    }
    
    
}




