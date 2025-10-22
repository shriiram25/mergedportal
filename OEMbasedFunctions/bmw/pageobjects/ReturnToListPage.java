package bmw.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import org.junit.Assert;
import utility.GetScreenshot;

public class ReturnToListPage {
	
public WebDriver driver;
	
	public ReturnToListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Return to the list of current contracts")
	public WebElement returnTo;
	
	public void clickReturnTo()
	{
		try{
			Thread.sleep(5000L);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return to the list of current contracts")));
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Return to the list of current contracts")));
			returnTo.click();
			
			Log.log.debug("Click on Return to the list of current contracts Link");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
