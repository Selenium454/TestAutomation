package genericFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import reports.AdvExtentReports;

public class Libraries extends AdvExtentReports {

	/*
	 * This Method Performs SendKeys Param: WebElement, TestData, FieldName
	 */

	public static void input(WebElement ele, String testData, String fieldName) {

		if (ele.isDisplayed()) {

			ele.clear();
			ele.sendKeys(testData);
			logger.log(Status.INFO, "Entered " + testData + " in " + fieldName);
		}

	}

	public static void click(WebElement ele, String fieldName) {

		if (ele.isDisplayed()) {
			elementToBeClick(ele);
			ele.click();
			logger.log(Status.INFO, "Clicked On " + fieldName);
		}

	}

	public void selectByText(WebElement ele, String testData, String fieldName) {
		try {
			if (ele.isDisplayed()) {
				new Select(ele).selectByVisibleText(testData);
				logger.log(Status.INFO, "Entered " + testData + " in " + fieldName);
			}
		} catch (Exception e) {
			logger.log(Status.FAIL, "Element is not displayed or wrong locator "+ele);
			//Assert.fail("Failed due to "+e.getMessage());
		}

	}

	public void selectByValue(WebElement ele, String testData, String fieldName) {

		if (ele.isDisplayed()) {
			new Select(ele).selectByValue(testData);
			logger.log(Status.INFO, "Entered " + testData + " in " + fieldName);
		}

	}

	public WebElement explicitWait(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static WebElement elementToBeClick(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public String getText(WebElement ele) {
		String text = null;
		if (ele.isDisplayed()) {

			text = ele.getText().trim();
		}
		return text;
	}
	
	public String getFirstSelectedOption(WebElement ele) {
		
		return new Select(ele).getFirstSelectedOption().getText().trim();
	}
	
	public void delay(int time) {
		
		try {
			Thread.sleep(time+000);
		} catch (Exception e) {
			
		}
	}
	
	public void acceptAlert() {
		
		driver.switchTo().alert().accept();
	}
	
	public void mouseHover(WebElement ele) {
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	public String title() {
		
		return driver.getTitle().trim();
	}

}
