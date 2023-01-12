package vtiger.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		//database open
	}
	
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public PropertyFileUtility pLib =new PropertyFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	public WebDriver driver = null;
	public static WebDriver sDriver;
	
	@BeforeClass
	public void bcConfig() throws IOException {
		
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("---chrome browser launched---");
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("---Firefox browser launched---");
		}
		
		else 
			System.out.println("---invalid browser name---");
		
		wLib.maximizeWindow(driver);
		wLib.waitForDomLoad(driver);
		driver.get(URL);
		sDriver = driver;
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginApp(USERNAME, PASSWORD);
		Reporter.log("---sign in successfully---",true);
		
	}
	
	@AfterMethod
	public void amConfig() {
		
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("---sign out successfully---",true);
	}
	
	@AfterClass
	public void acConfig() {
		driver.close();
		Reporter.log("---browser closed---",true);
	}
	
	@AfterSuite
	public void asConfig() {
		//database close
	}
}
