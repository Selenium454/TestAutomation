package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericFunctions.Libraries;
import webPages.HMSLoginPage;

public class TestNGAnnotation extends Libraries {

	WebDriver driver;
	public HMSLoginPage login;

	@BeforeSuite(alwaysRun = true)
	public void startSuite() {

		System.out.println("startSuite Method will exexute 1");
		System.out.println("startClass Method will exexute 3");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\centillion\\Downloads\\DriverFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://selenium4testing.com/hms/");
	}

	
	@Test
	public void login(String user,String pass) {
		
		input(hmslogin.getHmsUser(), "admin", "UserName");
		
		input(hmslogin.getHmsPassword(), "admin", "PassWord");

		String beforeLogin = title();

		click(hmslogin.getHmsSubmit(), "Login");
		

		/*
		 * driver.findElement(By.xpath("xyz")); // unable to find xpath
		 * 
		 * driver.findElements(By.xpath("xyz")); // 0
		 */
	}


}
