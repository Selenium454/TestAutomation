package testCases;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import reports.AdvExtentReports;
import webPages.HMSLoginPage;
import webPages.HomePage;

public class AmazonOrders extends AdvExtentReports {

	

	@Test
	public void myAmazonOrders() throws Exception {

		try {
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			HMSLoginPage login = PageFactory.initElements(driver, HMSLoginPage.class);
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			ArrayList<WebElement> ele = new ArrayList<WebElement>();
			
			String num = "9966890198";

			// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='nav-tools']/a[1]")).click();
			driver.findElement(By.cssSelector("input[id='ap_email']")).sendKeys(num);
			driver.findElement(By.cssSelector(".a-button-input")).click();
			driver.findElement(By.cssSelector("#ap_password")).sendKeys(num);
			driver.findElement(By.cssSelector("#signInSubmit")).click();
			driver.findElement(By.xpath("//div[@id='nav-tools']/a[1]")).click();
			driver.findElement(By.xpath("//h2[contains(text(),'Your Orders')]")).click();

			String orders = driver.findElement(By.xpath("//label[@for='orderFilter']/span")).getText();
			String order[] = orders.split(" ");
			System.out.println(order[0]);

			List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='a-pagination']/li"));
			
			
			for(int i=2;i<pages.size();i++) {
				
				WebElement number = driver.findElement(By.xpath("//ul[@class='a-pagination']/li["+i+"]"));
				
				number.click();
				
				ele.addAll(home.getAmazonOrders());
			}
			
			System.out.println(ele.size());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		driver.close();
		
		

	}

}
