package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import genericFunctions.Libraries;

public class HMSLoginPage extends Libraries {
	
	
	public HMSLoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Registration']")
	public WebElement preg;
	
	
	@FindBy(how=How.XPATH,using="//a[text()='Registration']")
	public WebElement pregstration;
	
	@FindBy(how=How.NAME,using="username")
	private WebElement hmsUser;
	
	public WebElement getHmsUser() {
		
		return hmsUser;
		
	}
	
	@FindBy(how=How.NAME,using="password")
	private WebElement hmspassword;
	
	public WebElement getHmsPassword() {
		return hmspassword;
	}
	
	@FindBy(how=How.NAME,using="submit")
	private WebElement hmssubmit;
	
	public WebElement getHmsSubmit() {
		return hmssubmit;
		
	}
	

}
