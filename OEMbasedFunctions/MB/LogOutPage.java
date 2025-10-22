package MB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import MB.Hooks;
import junit.framework.Assert;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

public class LogOutPage {
	
	public WebDriver driver;
	
	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Login/Account")
	public WebElement logAcc;
	
	@FindBy(linkText="Logout")
	public WebElement logOutLink;
	
	public void clickLogOutLink()
	{
		try{
			//Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login/Account")));
			Actions action=new Actions(driver);
			action.moveToElement(logAcc).perform();
			logOutLink.click();
			
			Log.log.debug("Click on Log Out Link");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
