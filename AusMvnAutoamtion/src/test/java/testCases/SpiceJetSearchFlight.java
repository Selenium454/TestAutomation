package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import reports.AdvExtentReports;
import webPages.HomePage;
import webPages.SpiceJetHomePage2;

public class SpiceJetSearchFlight extends AdvExtentReports {

	public HomePage home = null;
	public SpiceJetHomePage2 test = null;

	@BeforeMethod
	public void initApplication() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\centillion\\Downloads\\DriverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
	}

	@Test
	public void verifySearch() {
		
		logger = extent.createTest("SearchForFlight");
		
		home = PageFactory.initElements(driver, HomePage.class);

		home.getFrom().click();
		logger.log(Status.INFO, "Click on From");
		home.getFromLocation().click();
		logger.log(Status.INFO, "Selected From Flight");
		home.getToLocation().click();
		logger.log(Status.INFO, "Selected To Flight");
		for (int i = 1; i <= home.getDates().size(); i++) {

			WebElement ele = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[" + i + "]/div"));
			String month = ele.getText().trim();
			if (month.contains("April")) {

				for (WebElement ele1 : home.getAprildates()) {

					if (!ele1.getText().isEmpty()) {

						if (ele1.getText().trim().equals("25")) {

							ele1.click();
							logger.log(Status.INFO, "Clicked on Date");
							break;
						}

					}
				}

			}
		}
	}

}
