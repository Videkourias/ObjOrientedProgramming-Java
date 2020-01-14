import java.util.Random;
public class TestEmployee {

    public static void main(String[] args) {
        HourlyWorker hw1 = new HourlyWorker("Jim", 19, 2017, 10, 15.75);
        
        
        System.out.println(hw1);
        
        hw1.PayWorker();
        hw1.PayWorker();

        
        
        
        
        //Payroll
        System.out.println("\nPayroll: ");
        
        Random rm = new Random();
        
        String names[] = {"Jim", "Emma", "Rich", "Julia", "Steve"};
        int ages[] = {19,32,45,23,50};
        int yearsHired[] = {2017, 1982, 2000, 2006, 2010};
        
        
        HourlyWorker workers[] = new HourlyWorker[5]; 
        for(int i = 0; i < 5; i++) {
            workers[i] = new HourlyWorker(names[i], ages[i], yearsHired[i], rm.nextInt(60), rm.nextDouble() * 100.0);
        }
        
        for(HourlyWorker w: workers) {
            w.PayWorker();
        }
        
                
    }

}
