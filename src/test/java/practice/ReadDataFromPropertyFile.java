package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String browser = pObj.getProperty("browser");
		System.out.println(browser);
		String url = pObj.getProperty("url");
		System.out.println(url);
	}

}
