package vtiger.OrganizationTests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.HomePage;

public class WebTableTest extends BaseClass{
	

	@Test
	public void webTableTest() {
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---Organiztion link clicked---",true);
		
		List<WebElement> cb = driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td//input[@name='selected_id']"));
		for(WebElement cbs:cb) {
			cbs.click();
			
		}
		WebElement ele = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[22]/td/input[@name='selected_id']"));
		if(ele.isSelected()) {
			Reporter.log("---All checkboxes clicked---",true);
		}
		else {
			Reporter.log("---All checkboxes not clicked---",true);
		}
		
	}
	
	@Test
	public void checkbox5select() {
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---Organiztion link clicked---",true);
		
		WebElement ele = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td/input[@name='selected_id']"));
		ele.click();
		if(ele.isSelected()) {
			Reporter.log("---5th row selected---",true);
		}
		else {
			Reporter.log("---5th row not selected---",true);
		}
	}
	
	@Test
	public void allOrgNameWebTable() {
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---Organiztion link clicked---",true);
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
		for(WebElement name:ele) {
			String text = name.getText();
			System.out.println(text);
		}
		Reporter.log("---Printed all org names---",true);
	}
	
	@Test
	public void deleteOrgWebTable() {
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLink();
		Reporter.log("---Organiztion link clicked---",true);
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[11]/td[*]/a[text()='del']")).click();
		wLib.acceptAlert(driver);
		WebElement ele = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[11]/td[6]"));
		String actphno = ele.getText();
		String expPhno = "(489) 934-8578 ";
		Assert.assertEquals(actphno, expPhno);
		
	}

}
