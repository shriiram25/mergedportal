package Toyota;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GetScreenshot;

public class AgreementTabPage {
	
	public WebDriver driver;
	
	public AgreementTabPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-agreement-entry")
	public WebElement agreementTab;
	
	@FindBy(id="addNew")
	public WebElement an;
	
	public void agreeTab()
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(agreementTab));
			agreementTab.click();
			wait.until(ExpectedConditions.elementToBeClickable(an));
			an.click();
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
