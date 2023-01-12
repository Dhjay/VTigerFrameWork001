package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createcntbtn;
	
	//Initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreatecntbtn() {
		return createcntbtn;
	}
	
	public void createContact() {
		createcntbtn.click();
	}

}
