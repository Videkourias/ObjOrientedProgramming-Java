/**
    Represents a playable cell in the tic tac toe game
    @author Dean Willavoys - 105003751
    @since Nov, 13 2019 
*/

public class Block{
    private String state; //state of the cell, X, O, or EMPTY

    //Default constructor
    public Block(){
        this.state = "EMPTY";
    }


    /**
     * Setter for state attribute 
     * @param state A string representing the state of the cell, only X, O, and EMPTY are valid states
     * @return String Returns the state of the cell after the method is executed
    */
    public String setState(String state){
            if(state.compareTo("X") == 0 || state.compareTo("O") == 0 || state.compareTo("EMPTY") == 0)
                this.state = state;
            return this.state;
    }


    /**
     * Getter for state attribute
     * @return String Returns the current state of the cell
    */
    public String getState(){
        return state;
    }



    /**
     * toString override
     * @return String Returns the current state
    */
    public String toString(){
        if(state.compareTo("EMPTY") == 0) return " ";
        return state;
    }


}
