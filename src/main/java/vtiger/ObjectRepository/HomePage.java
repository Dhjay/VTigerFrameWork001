package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//Declaration
	
	@FindBy(linkText = "Leads")
	private WebElement leadslnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationlnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOuticon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutbtn;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getLeadslnk() {
		return leadslnk;
	}

	public WebElement getOrganizationlnk() {
		return organizationlnk;
	}

	public WebElement getContactslnk() {
		return contactslnk;
	}
	
	//Business methods
	
	public void clickContactsLink() {
		contactslnk.click();
	}
	
	public void clickOrganizationLink() {
		organizationlnk.click();
	}
	
	public void leadsLink() {
		leadslnk.click();
	}
	
	/**
	 * This method is used to signout from the application
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver) {
		mouseHover(driver, signOuticon);
		signoutbtn.click();
	}
	
	
	
	
	

}
