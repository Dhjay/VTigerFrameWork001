package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	
	@FindBy(name="user_name")
	private WebElement usernametxt;
	
	@FindBy(name="user_password")
	private WebElement passwordtxt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//Initialization
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Business library
	
	public void loginApp(String username,String password) {
		usernametxt.sendKeys(username);
		passwordtxt.sendKeys(password);
		loginbtn.click();
	}
	

}
