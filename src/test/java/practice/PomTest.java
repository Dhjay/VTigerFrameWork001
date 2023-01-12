package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.ObjectRepository.LoginPage;

public class PomTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		LoginPage lg = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		lg.loginApp("admin", "root");
		
	}

}
