package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SpiceJetHomePage2 {
	
	
	@FindBy(how=How.ID,using="ctl00_mainContent_chk_friendsandfamily")
	private WebElement familychk;
	
	public WebElement getFamilychk() {
		
		return familychk;
	}

}
