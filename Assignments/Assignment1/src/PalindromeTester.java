import java.util.Scanner;
public class PalindromeTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        while(sc.hasNext()) {
            String text = sc.next();
            Palindrome pal = new Palindrome(text);
            pal.test();
            System.out.println(pal.formatOut());
        }
        sc.close();
        System.out.print("\n"); //Established best practice
    }

}
