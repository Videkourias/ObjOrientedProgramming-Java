/**
    Abstract class for a player
    @author Dean Willavoys - 105003751
    @since Nov, 13 2019 
*/

public abstract class Player{
    private String symbol; //The symbol the player uses on the Board, X or O (EMPTY by default)
    private String name; //The name of the player
    

    //Default constructor
    public Player(){
        symbol = "EMPTY";
        name = "DEFAULT_NAME";           
    }




    /**
     * Setter for symbol attribute
     * @param symbol A string symbol for the player to use, only X or O are valid (EMPTY is default symbol)
     * @return String Returns the current symbol of the player
    */
    public String setSymbol(String symbol){
        if(symbol.compareTo("X") == 0 || symbol.compareTo("O") == 0 || symbol.compareTo("EMPTY") == 0){
            this.symbol = symbol;
        }
        return this.symbol;
    }



    /**
     * Setter for the name attribute
     * @param name A string name for the player, non-empty
     * @return String Returns the current name of the player
    */
    public String setName(String name){
        if(!name.isEmpty()){
            this.name = name;
        }
        return this.name;
    }


    /**
     * Getter for the symbol attribute
     * @return String Returns the symbol of the player
    */
    public String getSymbol(){
        return symbol;
    }


    /**
     *  Getter for the name attribute
     *  @return String Returns the name of the player
    */
    public String getName(){
        return name;
    }


    //Abstract method that allows player action
    abstract void play(Board gameBoard);


}




