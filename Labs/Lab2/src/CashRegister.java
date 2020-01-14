/**
Main Class of the program, serves as entry point.
Serves as a cash register for the user.

@author Dean Willavoys - 105003751
@since 2019-09-21
*/
public class CashRegister{
	public static void main(String[] args){
		int numItems = 3;		//Constant for this program, could be user entered
		Invoice iv = new Invoice(numItems);
//		iv.out(); //DEBUG
		iv.bill();

	}
}