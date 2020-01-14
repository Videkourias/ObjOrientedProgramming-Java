/**
    Controls interaction between player and board, gets user input
    @author Dean Willavoys - 105003751
    @since Nov, 13 2019 
*/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Game implements Global{
    private Board gameBoard; //The board
    private Player playerX; //The 2 game players
    private Player playerO; 
    private int style; //What type of game the player has selected through declarePlayers()
    
    
    //Default constructor
    public Game(){
        style = declarePlayers();
        gameBoard = new Board();        
    }

    /**
     * Method to declare what type of players will play in the game, player or ai
     * @return Returns the integer corresponding to the users choice of type of game
     * 1 for player vs player, 2 for player vs ai, 3 for ai vs ai
     */
    private int declarePlayers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Player vs Player\n2. Player vs AI\n3. AI vs AI\nChoose: ");
        int choice;
        int dif[] = new int[2]; //Array for AI difficulties

        //Get choice from user
        while(true) {
            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > 3) throw new IndexOutOfBoundsException();
                int i = 0;
                //If AI choice was made, get AI diffculties
                while(i < choice - 1) {
                    System.out.println("Choose a difficulty for AI" + (i + 1));
                    System.out.print("1 - Easy\n2 - Normal\nInput: ");
                    dif[i] = sc.nextInt();
                    if(dif[i] != 1 && dif[i] != 2) {
                        System.out.println("Invalid Difiiculty!");
                        continue;
                    }
                    i++;
                }
                break;
            }
            catch(IndexOutOfBoundsException e) {
                System.out.print("Invalid Input\nChoice: ");
            }
            catch(InputMismatchException e) {
                System.out.print("Invalid Input type\nChoice: ");
                sc.nextLine();
            }
        }
        //Switch statement to create players based on user choice
        switch(choice) {
            case 1:
                playerX = new HumanPlayer();
                playerO = new HumanPlayer();
                break;
            case 2:
                playerX = new HumanPlayer();
                playerO = new AIPlayer(dif[0]);
                break;
            case 3:
                playerX = new AIPlayer(dif[0]);
                playerO = new AIPlayer(dif[1]);
                break;
        }
        
        
        return choice;
    }
    
    
    /**
     * Method to initialize player names given user input
     * @return int Returns 0 on completion
    */
    private int initPlayers(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name for Player X: ");
        playerX.setName(sc.nextLine());
        playerX.setSymbol("X");

        System.out.print("Enter a name for Player O: ");
        playerO.setName(sc.nextLine());
        playerO.setSymbol("O");

        return 0;
    
    }
    
    /**
     * Function to simulate a coin flip
     * @return int Returns 0 or 1 randomly
     */
    private int coinFlip() {
        Random rm = new Random();
        return rm.nextInt(2);
    }
    

    /**
     * Method to start and run the game, initializes players and coordinates turns, also
     * deals with outputting the winner of the game
     */
    public void start(){
        initPlayers(); //Creates players
        int turn = coinFlip(); //Chooses who starts first
        if(turn == 0){
            System.out.println(playerX.getName() + " wins the coin toss, X goes first");
        }
        else{
            System.out.println(playerO.getName() + " wins the coin toss, O goes first");
        }

        
        //PLAYER ACTION
        System.out.println("This game board has bounds: [1," + size + "] [1," + size + "]");
        while(turn > -1) { //Infinite loop to play until end of game
            if(turn % 2 == 0) { //PlayerX's turn
                while(true) { //Ensures player makes a valid move
                    try {
                        playerX.play(gameBoard);
                        break;
                    }
                    catch(IndexOutOfBoundsException e) { //Player entered X or Y outside of scope of board
                        System.out.println("Input out of bounds");
                    }
                    catch(InputMismatchException e) { //Type mismatch from scanner
                        System.out.println("Invalid input type");
                    }
                }
                    
            }
            else { //PlayerO's turn
                while(true) { //Ensures player makes a valid move
                    try {
                        playerO.play(gameBoard);
                        break;
                    }
                    catch(IndexOutOfBoundsException e) { //Player entered X or Y outside of scope of board
                        System.out.println("Input out of bounds");
                    }
                    catch(InputMismatchException e) { //Type mismatch from scanner
                        System.out.println("Invalid input type");
                    }
                }
            }
            
 
            if(style != 3) gameBoard.display(); //Give visual of board, only if players aren't both ai (speeds up ai vs ai games when size is large)
            turn++; //Move to next turn
            
 
            
            //GAME STATE CHECK
            if(gameBoard.updateState().compareTo("EMPTY") != 0) { //if the update yields a result other than the default
                    System.out.print("\n\n");
                    gameBoard.display();
                    if(gameBoard.getState().compareTo("DRAW") == 0) { //Case for a draw, breaks out of game loop
                        System.out.println("The game ends in a draw...");
                        break;
                    }
                    //Prints winner, only if game state is not DRAW
                    if(gameBoard.getState() == playerX.getSymbol()) {
                        System.out.println(playerX.getName() + " wins!");
                    }
                    else {
                        System.out.println(playerO.getName() + " wins!");
                    }
                    break;
            }
        }
    }

}




