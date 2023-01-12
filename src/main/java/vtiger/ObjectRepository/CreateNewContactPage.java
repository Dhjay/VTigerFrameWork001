package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastnametxt;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement orglookupicon;
	
	@FindBy(name = "leadsource")
	private WebElement leadsrcdropdown;
	
	@FindBy(id = "search_txt")
	private WebElement searchtxt;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savbtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastnametxt() {
		return lastnametxt;
	}

	public WebElement getOrglookupicon() {
		return orglookupicon;
	}

	public WebElement getLeadsrcdropdown() {
		return leadsrcdropdown;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSavbtn() {
		return savbtn;
	}
	
	public void createNewContact(String lastname) {
		lastnametxt.sendKeys(lastname);
		savbtn.click();
	}
	
	public void createNewContact(String lastname,WebDriver driver,String OrgName) {
		lastnametxt.sendKeys(lastname);
		orglookupicon.click();
		switchToWindow(driver, "Accounts");
		searchtxt.sendKeys(OrgName);
		searchbtn.click();
		driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		savbtn.click();
	}
	
	
	
	
}
