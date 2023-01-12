package vtiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait for the entire dom to load
	 * @param driver
	 */
	public void waitForDomLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait till the element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to select the drop down option using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is used to select option from drop down using text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to select drop down option using value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value,WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used to perform mouse hover avction
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform doubleclick action
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method is used to perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method is used to perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	
	/**
	 * This method will press enter key and release
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method accepts the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method dismisses the alert popups
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method returns the text from alert popups
	 * @param driver
	 * @return
	 */
	public String alertGetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This method helps to switch frame based on index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver ,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method helps to handle frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will switch back to parent frame
	 */
	public void toParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch control to default frame
	 * @param driver
	 */
	public void toDefaultContentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		//Step-1: get all window ids
		Set<String> windowids = driver.getWindowHandles();
		
		//step-2: Read all the ids
		Iterator<String> it = windowids.iterator();
		
		/**
		 * This method will switch from one window to another based on partial window title
		 */
		//step-3: navigate to each window and check the title
		while(it.hasNext()) {
			String winid = it.next();
			String currentTitle = driver.switchTo().window(winid).getTitle();
			if(currentTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+screenshotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
	
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	
	
	
	
	
	
	
	

}
