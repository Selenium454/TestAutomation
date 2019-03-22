package testCases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericFunctions.Libraries;
import genericFunctions.UIFunctions;
import testData.ReadData;

public class ERegistration extends Libraries {
	
	Map<String, String> testData = ReadData.getTestData("Sheet1", "Registration");

	@Test(priority = 1)
	public void registration() {

			UIFunctions.hmsLogin();

			click(driver.findElement(By.linkText("Registration")), "Registration");

			click(driver.findElement(By.linkText("Emergency Registration")), "Emergency Registration");

			input(driver.findElement(By.xpath("//input[@placeholder='dd-mm-yyyy']")), testData.get("DOB"), "DOB");

			selectByText(driver.findElement(By.name("PATIENT_CAT")), testData.get("PatientCat"), "Patient Category");

			// System.out.println("Selected Value in Pat Categor " +
			// select.getFirstSelectedOption().getText());

			new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText(testData.get("Title"));

			String title = new Select(driver.findElement(By.name("TITLE"))).getFirstSelectedOption().getText();

			System.out.println(title);

			driver.findElement(By.xpath("//input[@name='DOB']")).sendKeys("03-06-2019");

			driver.findElement(By.name("PNT_NAME")).sendKeys("Selenium");

			driver.findElement(By.name("AGE")).sendKeys("3");

			new Select(driver.findElement(By.name("SEX"))).selectByVisibleText("Male");

			driver.findElement(By.xpath("//input[@value='Upload Image']")).click();

			try {
				Thread.sleep(2000);

				Runtime.getRuntime().exec("C:\\Users\\centillion\\Downloads\\DriverFiles\\HMSUploadFile.exe");

				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.findElement(By.name("submit")).click();

			// using Alerts

			String alertInfor = driver.switchTo().alert().getText();

			System.out.println(alertInfor);

			driver.switchTo().alert().accept();
	}

	@Test(priority = 2)
	public void show() {
		try {
			Assert.fail("Dummy Failure");
		} catch (Exception e) {

		}
	}
}
