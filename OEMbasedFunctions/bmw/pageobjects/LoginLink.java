package bmw.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import org.junit.Assert;
import utility.GetScreenshot;

public class LoginLink {
	
	public WebDriver driver;
	
	public LoginLink(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="log in")
	public WebElement logIn;
	
	public void clickLogInLink()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in")));
			logIn.click();
			
			Log.log.debug("Click on Log in Link");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	//
	@FindBy(css="[title='Login/Account']")
	public WebElement logAcc;
	
	@FindBy(css="[title='Login']")
	public WebElement login;

	public void clickLogin()
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Login/Account']")));
			Actions action=new Actions(driver);
			action.moveToElement(logAcc).perform();
			login.click();			
		
			Log.log.debug("Click on Login Link");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
}
