package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonTodaysDeals extends TestNGAnnotation {



	@Test
	public void amazonDeals() {

		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[2]")).click();
		
		List<WebElement> deals = driver.findElements(By.xpath("//div[@id='widgetFilters']/div/div[2]/span/div/label/input"));
		
		System.out.println(deals.size());

	}

}
