/**
 * Driver to test class files demonstrating inheritance and some applications
 * @author Dean Willavoys - 105003751
 * @since 2019-10-8
 */
public class TestEmployee {

    public static void main(String[] args) {
        Employee e1 = new Employee("jim", 19, 2017); // name, age, date hired
        Employee e2 = new Employee("jenny smith", 23, 2014); // name, age, date hired
        Employee e3 = new Employee("", 185, 2777); // name, age, date hired

        System.out.println(e1); // displays: Jim was hired in 2017 and is 19 years old
        System.out.println(e2); // displays: Jenny Smith was hired in 2014 and is 23 years old
        System.out.println(e3); // displays: private contractor was hired in 2018 and is 18 years old


    }

}
