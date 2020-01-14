/**
 * Program to use Name class in various capacities
 * @author Dean Willavoys - 105003751
 * @since 2019-11-26
 */
import java.io.*;
import java.util.*;

public class Driver {
    
    
    /**
     * Method to write data contained within Name object to specified file
     * @param file A String representing the name of the file to write to
     * @param person A Name object to be written to file
     * @return int Returns 0 on success
     * @throws IOException
     */
    public static int writeToFile(String file, Name person) throws IOException{
        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s,%s,%s\n", person.getFname(), person.getLname(), person.getDob());
        printWriter.println(""); //Newline
        printWriter.close();
        return 0;
    }
    
    /**
     * Method to read formatted data from specified file
     * @param fileName A String representing the name of the file to read from
     * @param list A LinkedList to store the objects in
     * @return int Returns the number of objects successfully read
     * @throws IOException
     */
    public static int readFromFile(String fileName, LinkedList<Name> list) throws IOException{
        File file = new File(fileName);
        Scanner ic = new Scanner(file);
        ic.useDelimiter("\\n|,");
        
        
        int i = 0;
        //Read all entries from saved file
        while(ic.hasNext()) {
            try {
                list.add(new Name(ic.next(),ic.next(),ic.next()));
                ic.next();
                i++;
            }
            catch(InvalidDateException e) { //If date has been modified, throw error
                System.out.println("Read error... Entry Skipped");
            }
        }
        ic.close();
        return i;
    }
    
    /**
     * Method to edit a single entry of a Name
     * @param n A Name to edit
     * @return String Returns the current String of the attribute to be edited
     */
    public static String editEntry(Name n) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nChoose which to edit\n1 - First name\n2 - Last Name\n3 - Date of Birth\nInput: ");
        int choice = sc.nextInt();
        String out = "";
        
        switch(choice) {
        case 1: //Change first name
            System.out.print("Enter a new first name: ");
            out = n.setFname(sc.next());
            break;
            
        case 2: //Change last name
            System.out.print("Enter a new last name: ");
            out = n.setLname(sc.next());
            break;
            
        case 3: //Change DOB
            System.out.print("Enter a new date of birth(mm/dd/yyyy): ");
            try{
                out = n.setDob(sc.next());
            }
            catch(InvalidDateException e) {
                System.out.println("Invalid date");
            }
            break;
            
        default: //Invalid entry
            System.out.println("Invalid option\n");
        }
        System.out.println("");
        
        return out;
    }
    
    
    //Entry point for program
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Name n; //Name object to be written to file
        String fname, lname, dob; //Information to be passed to Name object
        int current = 0; //The currently viewed entries index
        
        boolean run = true; //boolean for main loop
        int input; //User input choice
        
        String file; //File to interract with
        String baseFile = "base" + System.currentTimeMillis() + ".txt"; //Base file for entries
        
        
        
        LinkedList<Name> names = new LinkedList<Name>(); //LinkedList of current entries

        
        
        while(run) {
            System.out.print("1 - Add entry\n2 - Display All Entries\n3 - Display Current Entry\n4 - Next Entry\n5 - Previous Entry\n");
            System.out.print("6 - Edit Entry\n7 - Save to File\n8 - Load from File\n9 - Exit\nInput: ");
            input = sc.nextInt();
            
            
            switch (input) {
            case 1: //Add item(also write to file)
                while (true) {
                    try { // Get Name info from user
                        System.out.print("\nEnter a first name: ");
                        fname = sc.next();

                        System.out.print("Enter a last name: ");
                        lname = sc.next();

                        System.out.print("Enter a date of birth(mm/dd/yyyy): ");
                        dob = sc.next();

                        n = new Name(fname, lname, dob);
                        writeToFile(baseFile, n); // Add name to sequential text file
                        names.add(n); //Add name to linked list for local use
                        
                        System.out.println("\nAdded!\n");
                        break;
                    } catch (IOException e) { // File related error
        
                        System.out.println("File error...");
                    } catch (InvalidDateException e) { // Invalid date provided
                        System.out.println("Date validity error...");
                    } catch (InputMismatchException e) { // Bad input
                        System.out.println("Invalid Input...");
                    }
                }
                break;

            case 2: //Sort and display all entries
                Collections.sort(names); //Sorts current entries
                ListIterator<Name> it = names.listIterator(); //Iterator to move with
                
                
                System.out.println("");
                while(it.hasNext()) { //Print all entries
                    System.out.println(it.next());
                }
                
                System.out.println("");
                break;

            case 3: //Display Current Entry
                if(names.size() != 0) {
                    System.out.println("\n" + names.get(current));
                }
                System.out.println("");
                break;
                
            case 4: //Move to next entry
                if(names.size() == 0) { //Nothing to iterate over
                    break;
                }
                if(++current >= names.size()) { //Wrap around if end was reached
                    current = 0;
                }
                System.out.println("\nMoved!\n");
                break;
                
            case 5: //Move to previous entry
                if(names.size() == 0) { //Nothing to iterate over
                    break;
                }
                if(--current < 0) { //Wrap around if start was reached
                    current = names.size() - 1;
                }
                System.out.println("\nMoved!\n");
                break;
                
            case 6: //Edit Entry
                editEntry(names.get(current));
                break;
                
            case 7: //Save to file   
                if(names.size() == 0) {
                    System.out.println("\nNothing to save!\n");
                    break;
                }
                System.out.print("\nFile to write to: "); //Get file user wants to read
                file = sc.next();
                
                File delFile = new File(file);
                delFile.delete(); //Delete file if already exists
                
                //Write all entries to file
                for(int i = 0; i < names.size(); i++) {
                    try {
                        writeToFile(file, names.get(i));
                    }
                    catch(IOException e){
                        System.out.println("File write error...");
                    }
                }
                System.out.println("Saved Successfully!\n");
                break;
            
            case 8: //Load from file
                names.clear(); //Clear existing entries
                
                System.out.print("\nFile to read: "); //Get file user wants to read
                file = sc.next();
                
                // Read entries from file
                try {
                    readFromFile(file, names);
                } 
                catch (IOException e) {
                    System.out.println("File error...");
                }
                System.out.println("Loaded Successfully!\n");
                break;
                
            case 9: //Exit
                run = false;
                break;
            }
        }
         sc.close();    
    }

}
