package vtiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListenersImplementation.class)
public class CreateContactWithOrgTest extends BaseClass  {

		@Test
		public void createContactWithOrgTest() throws IOException {
	
		String ORGNAME = eLib.readDataFromExcel("Contact", 4, 3)+jLib.getRandomNumber();
		String LASTNAME = eLib.readDataFromExcel("Contact", 4, 2);
		
		//Navigate to Organizations page
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---click on organization link---",true);
		
		//Click on new organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOrganizationButton();
		Reporter.log("---click on organization lookup icon---",true);
		
		//Create new organization with mandatory fields and save
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrganization(ORGNAME);
		
		//validating the created organization
		OrgInfoPage oip = new OrgInfoPage(driver);
		String ORGTEXT = oip.getOrgHeaderText();
		if(ORGTEXT.contains(ORGNAME)) {
			Reporter.log("---Organization created succesfully---",true);
		}
		else {
			Reporter.log("---Organization not created---",true);
		}
		
		//Navigate to contacts link
		hp.clickContactsLink();
		//Assert.fail();
		
		//click on create contact button
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact();
		
		//create new contact with organization
		CreateNewContactPage ccn = new CreateNewContactPage(driver);
		ccn.createNewContact(LASTNAME, driver, ORGNAME);
		
		//Step-7: validating the created contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String CONTACTHEADER = cip.getContactHeader();
		System.out.println(CONTACTHEADER);
		if(CONTACTHEADER.contains(LASTNAME)) {
			Reporter.log("contact created --- Test passed---",true);
		}
		else {
			Reporter.log("---Test failed---",true);
		}
		
	}

}
