package nissaninfiniti.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import org.junit.Assert;
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
	
	public void enterUserName(String UN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			wait.until(ExpectedConditions.visibilityOf(user));
			
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			wait.until(ExpectedConditions.visibilityOf(pass));
			
			pass.sendKeys(PASS);
			
			Log.log.debug("Enter Password");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement submit;
	
	public void clickSubmit()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			wait.until(ExpectedConditions.visibilityOf(submit));
			
			submit.click();
			
			Log.log.debug("Click on Submit button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
