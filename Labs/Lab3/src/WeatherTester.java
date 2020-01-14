import java.text.DecimalFormat;
import java.util.Scanner;
public class WeatherTester {

	public static void main(String[] args) {
		Weather w1 = new Weather(); //Instantiate two objects
		Weather w2 = new Weather(13, 17);
		Scanner sc = new Scanner(System.in);
		
		System.out.println(w1);
		System.out.println(w2);
		
		System.out.print("Enter new temperature: "); //Get new temp
		int temp = sc.nextInt();
		w1.setTempF(temp); //Updates weather to current Windsor weather
		
		System.out.print("Enter new wind speed: "); //Get new win speed
		int speed = sc.nextInt();
		w1.setWindSpeed(speed);
	
		System.out.println(w1);
		
		DecimalFormat df = new DecimalFormat("#.##");
		String chill = df.format(w1.getWindChill()); //Gets wind chill and severe of w2 object
		boolean severe = w1.isSevere();
		
		System.out.println("Windsor:\nWind Chill: " + chill + "\nSevere: " + severe);
		sc.close();
	}

}
