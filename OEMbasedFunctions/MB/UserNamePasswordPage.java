package MB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import MB.Hooks;
import junit.framework.Assert;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

public class UserNamePasswordPage {
	
	public WebDriver driver;
	
	public UserNamePasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement user;
	
	public void enterUserName(String UN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			user.sendKeys(UN);
			
			Log.log.debug("Enter User Name");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="password")
	public WebElement pass;
	
	public void enterPassword(String PASS)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			pass.sendKeys(PASS);
			
			Log.log.debug("Enter Password");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement sub;
	
	public void clickSubmit()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			sub.click();
			
			Log.log.debug("Click on Submit button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
