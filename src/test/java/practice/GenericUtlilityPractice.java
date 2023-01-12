package practice;

import java.io.IOException;

import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtlilityPractice {

	public static void main(String[] args) throws IOException {

		JavaUtility jLib = new JavaUtility();
		 int ran = jLib.getRandomNumber();
		 System.out.println(ran);
		 
		 String date = jLib.getSystemDate();
		 System.out.println(date);
		 
		 String currentdate = jLib.getSystemDateInFormat();
		 System.out.println(currentdate);
		 
		 PropertyFileUtility pObj = new PropertyFileUtility();
		String BROWSER = pObj.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
	}

}
