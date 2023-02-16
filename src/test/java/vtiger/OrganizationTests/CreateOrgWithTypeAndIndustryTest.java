package vtiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithTypeAndIndustryTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void CreateOrgWithTypeAndIndustryTest() throws EncryptedDocumentException, IOException {
		
		String ORGNAME = eLib.readDataFromExcel("Organization",4 , 2) + jLib.getRandomNumber();
		String INDUSTRY = eLib.readDataFromExcel("Organization", 4, 3);
		String TYPE = eLib.readDataFromExcel("Organization", 4, 4);
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---Organization link clicked---",true);
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOrganizationButton();
		
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrganization(ORGNAME, INDUSTRY, TYPE);
		
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeaderText();
		if(orgHeader.contains(ORGNAME)) {
			Reporter.log("---created organization with industry and type dropdown, Test passed---",true);
		}
		else
			Reporter.log("---not created organization with industry and type dropdown, Test failed---",true);
	}

}
