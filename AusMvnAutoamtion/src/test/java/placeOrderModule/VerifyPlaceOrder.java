package placeOrderModule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericFunctions.Libraries;

public class VerifyPlaceOrder  extends Libraries{
	
	
	@Test(groups="Smoke")
	public void verifyTypedText() {
		
		driver.get("https://classic.crmpro.com/index.html");
		String userWaterMark = driver.findElement(By.name("username")).getAttribute("placeholder");
		
		System.out.println(userWaterMark);
	}

}
