package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;


@Listeners(vtiger.GenericUtility.ListenersImplementation.class)

public class CreateContactTest extends BaseClass {


		@Test(groups = "RegressionSuite")
		public void createContactTest() throws IOException {
		
		String LASTNAME = eLib.readDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickContactsLink();
		Reporter.log("---click on contacts link---",true);
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact();
		Reporter.log("---Click on create new contact lookup icon---",true);
		
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createNewContact(LASTNAME);
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if(contactHeader.contains(LASTNAME)) {
			Reporter.log("---contact created succesfully, test passed---",true);
		}
		else
			Reporter.log("---contac not created, test failed---",true);
	}
	

}
