package hyundai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import utility.GetScreenshot;

public class HyundaiLoginPage {
	
	public WebDriver driver;
	
	public HyundaiLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Log in")
	public WebElement LogIn;
	//Click on Login Link
	public void loginLink()
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in")));
			LogIn.click();
		}catch(Exception e){			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="username")
	public WebElement uId;
	//Enter User Name
	public void userID(String userName)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			uId.sendKeys(userName);
		}catch(Exception e){			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="password")
	public WebElement pass;
	//Enter Password
	public void userPassword(String userPass)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			pass.sendKeys(userPass);
		}catch(Exception e){			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement submitButton;
	//Click on Submit Button
	public void loginToSafeGuard()
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			submitButton.click();
		}catch(Exception e){			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	public void redirectRateLookUp()
	{
		try{
			
			
		}catch(Exception e){			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
