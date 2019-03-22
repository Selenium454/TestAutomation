package genericFunctions;

import java.util.Map;

import testData.ReadData;

public class UIFunctions extends Libraries {
	
	static Map<String, String> testData = ReadData.getTestData("Sheet1", "Registration");
	
	
	public static void hmsLogin() {
		
		driver.get("http://selenium4testing.com/hms/");
		input(hmslogin.getHmsUser(), testData.get("UserName"), "UserName");
		input(hmslogin.getHmsPassword(), testData.get("Password"), "Password");
		click(hmslogin.getHmsSubmit(), "Login");
	}
	
	public static void registration() {
		
		
	}
	

}
