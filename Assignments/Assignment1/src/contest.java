import java.util.Scanner;

class contest {
        private String text; //Non-empty
        private boolean palindrome;
        private boolean mirrored;
        
        /**
         * Default constructor
         */
        public contest() {
            setText("");
            palindrome = false;
            mirrored = false;
        }
        
        /**
         * Overloaded constructor
         * @param text A non-empty string
         */
        public contest(String text) {
            this();
            setText(text);
        }
        
        /**
         * Setter for text attribute
         * @param text A string to test, non-empty
         * @return String Returns the passed string
         */
        public String setText(String text) {
            if(valid(text)) {
                this.text = text;
            }
            return text;
        }
        
        
        /**
         * Getter for text
         * @return String Returns the text attribute
         */
        public String getText() {
            return text;
        }
        
        
        /**
         * Method to test if the stored text is a palindrome
         * @return boolean True if text is palindrome, false otherwise
         */
        public boolean isPalindrome() {
            StringBuilder sb = new StringBuilder(text); //Reverse of text
            sb.reverse();
            if(text.compareTo(sb.toString()) != 0) { //Case for non-palindrome
                return false;
            }
            return true;
        }
             
        
        /**
         * Method to test if stored text is mirrored
         * @return boolean Returns true if text is mirrored, false otherwise
         */
        public boolean isMirrored() {
            String mirr = "E3JLS2Z5"; //Characters in this string are mirrored by those in mirrCompliment
            String mirrCompliment = "3ELJ2S5Z";
            
            int len = text.length();
            char normal[] = text.toCharArray(); //Text as an array of characters
            char mirror[] = new char[len];
                 
            
            for(int i = 0; i < len; i++) {
                if(mirr.indexOf(normal[i]) != -1) { //If char of text is in mirr string
                    mirror[i] = mirrCompliment.charAt(mirr.indexOf(normal[i])); //Replace with compliment
                }
                else {
                    mirror[i] = normal[i]; //If not in mirr string, just copy normally
                }
            }
            
            StringBuilder sb = new StringBuilder(new String(mirror)); //String Builder object with mirrored string as string
            sb.reverse(); //Need to read backwards
            if(text.compareTo(sb.toString()) == 0){ //If text reversed and read backwards is equal to text, then mirrored
                return true;
            }
            return false;
        }
        
        
        /**
         * Method to exectute the 2 String tests(isPalindrome, isMirrored) and set internal values according
         * to the results. 
        */ 
        public void test() {
            if(isPalindrome()) {
                palindrome = true;
            }
            if(isMirrored()) {
                mirrored = true;
            }
        }
        
        /**
         * Creates a formatted out based on the current attributes
         * @return String A formatted output
         */
        public String formatOut() {
            if(palindrome && mirrored) {
               return String.format("%s -- is a mirrored palindrome", text);
            }
            else if(palindrome) {
               return String.format("%s -- is a regular palindrome", text); 
            }
            else if(mirrored) {
                return String.format("%s -- is a mirrored string", text); 
             }
            else {
                return String.format("%s -- is not a palindrome", text);
            }
        }
        
        
        //Helper to validate text is non-empty
        private boolean valid(String text) {
            return !text.isEmpty();
        }

        

       public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        
            do{
                String text = sc.nextLine();
                contest pal = new contest(text);
                pal.test();
                System.out.println(pal.formatOut());
            }while(sc.hasNextLine());
            sc.close();
            System.exit(0);
        }


}
