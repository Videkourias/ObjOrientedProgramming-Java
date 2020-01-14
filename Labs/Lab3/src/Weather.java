import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 * Weather class as defined by Lab3 documentation  
 * @author Dean
 *
 */
public class Weather {
//ATTRIBUTES
	int tempF; //Temp in Fahrenheit
	int windSpeed; //Wind speed in MPH
	int windChill; //The windchill as calculated by the provided formula
	boolean severe; //Is the windchill severe?

//METHODS
	//CONSTRUCTORS
	//Default constructor
	public Weather() {
		tempF = 90; //Default 90F
		windSpeed = 5; //Default 5MPH
		getWindChill(); 
		isSevere();
	}
	
	//Overloaded constructor
	public Weather(int tempF, int windSpeed) {
		this();
		setTempF(tempF);
		setWindSpeed(windSpeed);
		getWindChill();
		isSevere();
	}
	
	//ACCESS
	/**
	 * Method for setting temperature in F
	 * @param tempF An integer representing temperature in F
	 * @return int Returns the temp of the object
	 */
	public int setTempF(int tempF) {
		if(tempF > -50 && tempF < 150) { //Constraint for wind speed
			this.tempF = tempF;
			updateData(); //Update related data
		}
		return this.tempF;
	}
	
	/**	Method for setting wind speed in mph
	 * 	@param windSpeed An integer representing wind speed in mph 
	 * 	@return int Returns the wind speed of the object
	 */
	public int setWindSpeed(int windSpeed) {
		if(windSpeed > 0) { //Constraint for wind speed
			this.windSpeed = windSpeed;
			updateData(); //Update related data
		}
		return this.windSpeed;
	}
	
	/**
	 * Gets temperature in F
	 * @return int Returns temperature of object in F
	 */
	public int getTempF() {
		return tempF;
	}
	
	/**
	 * Gets wind speed in mph
	 * @return int Returns wind speed of object in mph
	 */
	public int getWindSpeed() {
		return windSpeed;
	}
	
	
	/**
	 * Calculates the wind chill given the temp and wind speed of the object
	 * @return double Returns the calculated wind speed
	 */
	public double getWindChill() {
		double chill = 35.74 + (0.6215 * tempF) - (35.75 * Math.pow(windSpeed, 0.16)) + (0.4275 * tempF * Math.pow(windSpeed, 0.16)); //Provided formula
		windChill = (int) chill; 
		return chill;
	}

	/**
	 * Calculates if object has severe weather
	 * @return boolean Returns true if weather is severe, false otherwise
	 */
	public boolean isSevere() {
	        severe = false;
		if(windChill < -15) {
			severe = true;
		}
		return severe;
	}

	//toString override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##"); //Formats decimal numbers with 2 points of precision
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		return "Current temperature is " + tempF + "'F. Feels like " + df.format(getWindChill()) + "'F and Wind Speed is " + windSpeed + " mph";
	}
	
	//UTILITY
	//updates data when temp or wind speed is updated
	private void updateData() {
		getWindChill();
		isSevere();
	}
}
