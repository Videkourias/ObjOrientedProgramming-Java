
public class Palindrome {
        private String text; //Non-empty
        private boolean palindrome;
        private boolean mirrored;
        
        /**
         * Default constructor
         */
        public Palindrome() {
            setText("DEFAULT");
            palindrome = false;
            mirrored = false;
        }
        
        /**
         * Overloaded constructor
         * @param text A non-empty string
         */
        public Palindrome(String text) {
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
            String selfMirr = "AHIMOTUVWXY18"; //Self mirroring characters
            String mirr = "E3JLS2Z5";  //Partnered Set
            String mirrCompliment = "3ELJ2S5Z"; //Partnered Set
            StringBuilder sb = new StringBuilder();
            

            char normal[] = text.toCharArray();

            for(char c: normal){
                if(selfMirr.indexOf(c) != -1){ //Char is self mirrored
                    sb.append(c);
                }
                else if(mirr.indexOf(c) != -1){ //Char has a mirror
                    sb.append(mirrCompliment.charAt(mirr.indexOf(c)));
                }
                else{
                    return false;
                }
            }
            sb.reverse();
            if(text.compareTo(sb.toString()) != 0){ //If string mirrored and read backwards does not equal original string
                return false;
            }
            return true;
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
               return String.format("%s -- is a mirrored palindrome.\n", text);
            }
            else if(palindrome) {
               return String.format("%s -- is a regular palindrome.\n", text); 
            }
            else if(mirrored) {
                return String.format("%s -- is a mirrored string.\n", text); 
             }
            else {
                return String.format("%s -- is not a palindrome.\n", text);
            }
        }
        
        
        //Helper to validate text is non-empty
        private boolean valid(String text) {
            return !text.isEmpty();
        }

  

}
