package Toyota;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import utility.GetScreenshot;

public class UserNamePasswordPage {
	
	public WebDriver driver;
	
	public UserNamePasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement user;
	
	public void userName(String UN)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(user));
			user.sendKeys(UN);
			Log.log.debug("Enter User Name as:- "+UN);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="password")
	public WebElement pass;
	
	public void password(String PA)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(pass));
			pass.sendKeys(PA);
			Log.log.debug("Enter Password as:- "+PA);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement sub;
	
	public void Submit()
	{
		try{
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(sub));
			sub.click();
			Log.log.debug("Click On Login Button");
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
