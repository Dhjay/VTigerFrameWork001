package vtiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgTest extends BaseClass{
	
	
	
	@Test(dataProvider = "OrgData")
	public void createMultipleOrgTest(String org,String industry) throws IOException {
		

		String ORGNAME = org+jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		
		//Click on create new organization
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOrganizationButton();
		
		//Create new organization with industry and save
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrganization(ORGNAME, industry);
		
		//validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeaderText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME)){
			Reporter.log("pass",true);
		}
		else
			Reporter.log("fail",true);
		
	}
	
	@DataProvider(name="OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		
		return eLib.readMultipleDataFromexcel("MultilpleOrg");
		
	}

}
