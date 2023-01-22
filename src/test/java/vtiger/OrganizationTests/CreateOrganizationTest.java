package vtiger.OrganizationTests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createOrgTest() throws IOException {

		String ORGNAME = eLib.readDataFromExcel("Organization", 4, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---organization link clicked---", true);

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOrganizationButton();
		Reporter.log("---organization lookup icon clicked---", true);

		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrganization(ORGNAME);

		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeaderText();
		if (orgHeader.contains(ORGNAME)) {
			Reporter.log("---Organization created successfully---test passed");
		} else
			Reporter.log("---Organization not created successfully---test failed");

	}
	
	@Test(groups = "RegressionSuite")
	public void demoRegressionTest() {
		System.out.println("This is demo regression");
	}
}
