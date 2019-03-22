package testCases;

import org.testng.annotations.Test;

public class GroupsInTestNG {

	
	@Test(groups= {"Smoke"})
	public void show() {
		
		System.out.println("Create a Class For Groups");
	}
}
