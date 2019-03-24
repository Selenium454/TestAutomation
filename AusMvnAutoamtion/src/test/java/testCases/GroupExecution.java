package testCases;

import org.testng.annotations.Test;

import genericFunctions.Libraries;

public class GroupExecution extends Libraries {
	
	
	@Test(priority=0,groups="Smoke")
	public void login() {
		
		System.out.println("This Will verify Login Functionality");
	}
	
	@Test(priority=1,description="Add To cart functionality",dependsOnMethods="login",groups="Regression")
	public void verifyAddToCart() {
		
		System.out.println("This Will Verify Add to Cart");
	}
	
	
	@Test(priority=2,enabled=false,groups="System")
	public void verifyCheckout() {
		
		System.out.println("This Will verify Checkout");
	}
	
	
	@Test(priority=3,invocationCount=2,groups="Smoke")
	public void verifyPlaceOrder() {
		
		System.out.println("This Will Verify Place Order Functionality");
	}
	
	

}
