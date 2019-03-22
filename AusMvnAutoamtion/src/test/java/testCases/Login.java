package testCases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Login extends TestNGAnnotation {

	
	@Test(priority = 0, groups = { "Smoke" })
	public void login() throws Exception {

		driver.get("https://paytm.com/");
		
		driver.findElement(By.xpath("//div[text()='Log In/Sign Up']")).click();

		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		driver.findElement(By.xpath("//span[text()='Login/Signup with mobile number and password']")).click();

		Thread.sleep(2000);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(src, new File("C:\\Users\\centillion\\Downloads\\DriverFiles\\test.png"));
	}

	@Test(priority = 1, dependsOnMethods = "login", groups = { "Reg" })
	public void pRegistration() {

		System.out.println("Login");
	}

	@Test(priority = 2, groups = { "Reg" })
	public void eRegistration() {

		System.out.println("Login");
	}

	

}
