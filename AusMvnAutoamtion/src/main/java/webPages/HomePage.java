package webPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	

	//Webelement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"))
	
	@FindBy(how=How.ID,using="ctl00_mainContent_ddl_originStation1_CTXT")
	private WebElement from;
	
	public WebElement getFrom() {
		
		return from;
	}
	
	@FindBy(how=How.XPATH,using="//a[@value='HYD']")
	private WebElement fromLocation;
	
	public WebElement getFromLocation() {
		
		return fromLocation;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@text='Bengaluru (BLR)'])[2]")
	private WebElement toLocation;
	
	public WebElement getToLocation() {
		
		return toLocation;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='ui-datepicker-div']/div/div")
	private List<WebElement> dates;
	
	public List<WebElement> getDates() {
		
		return dates;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td")
	private List<WebElement> aprilDates;
	
	public List<WebElement> getAprildates() {
		
		return aprilDates;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='ordersContainer']/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div/a")
	private List<WebElement> amazonOrder;
	
	public List<WebElement> getAmazonOrders() {
		
		return amazonOrder;
	}
	
	
	
	

}
