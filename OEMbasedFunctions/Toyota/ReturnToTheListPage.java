package Toyota;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

import utility.GetScreenshot;

public class ReturnToTheListPage {
	
	public WebDriver driver;
	
	public ReturnToTheListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Return to the list of current contracts")
	public WebElement returnTo;
	
	public void clickReturnTo()
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(returnTo));
			returnTo.click();
			Log.log.debug("Click on Return to the list of current contracts link");
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
