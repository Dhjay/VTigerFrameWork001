package vtiger.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndustryTest extends BaseClass{


		@Test
		public void createOrgWithIndustryTest() throws IOException {
		
		String ORGNAME = eLib.readDataFromExcel("Organization", 4, 2)+ jLib.getRandomNumber();
		String INDNAME = eLib.readDataFromExcel("Organization", 4, 3);
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---clicked organization link",true);
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOrganizationButton();
		Reporter.log("---organization lookup icon clicked---",true);
		
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrganization(ORGNAME, INDNAME);
		
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeaderText();
		if(orgHeader.contains(ORGNAME)) {
			Reporter.log("---created organization with industry successfully---test passed",true);
		}
		else
			Reporter.log("---not created organization with industry successfully---test failed",true);
		
	}

}
