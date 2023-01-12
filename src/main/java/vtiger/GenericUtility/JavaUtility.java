package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method will return random number
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	/**
	 * This method returns the current system date
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	public String getSystemDateInFormat() {
		Date d = new Date();
		String[] darr = d.toString().split(" ");
		String date = darr[2];
		String month = darr[1];
		String year = darr[5];
		String time = darr[3].replace(":", "-");
		String currentDate = date +" "+month+" "+year+" "+ time;
		return currentDate;
		
	}

}
