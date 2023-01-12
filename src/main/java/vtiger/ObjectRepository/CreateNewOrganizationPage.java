package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name = "accountname")
	private WebElement orgname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	
	//Implementation
	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getTypeDropDown() {
		return typeDropDown;
	}


	//Business method
	public void createOrganization(String orgName) {
		orgname.sendKeys(orgName);
		savebtn.click();
	}
	
	public void createOrganization(String orgName,String industry) {
		orgname.sendKeys(orgName);
		handleDropDown(industry, industryDropDown);
		savebtn.click();
	}
	
	public void createOrganization(String orgName,String industry,String type) {
		orgname.sendKeys(orgName);
		handleDropDown(industry, industryDropDown);
		handleDropDown(type, typeDropDown);
		savebtn.click();
	}

}
