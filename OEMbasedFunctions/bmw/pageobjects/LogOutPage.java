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

public class LogOutPage {
	
	public WebDriver driver;
	
	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	//@FindBy(linkText="Login/Account")
	//@FindBy(css="[href='/menu/list/id/335'],[title='Login/Account']")
	//@FindBy(linkText="Dealer Portal")
	@FindBy(css="[title='Dealer Portal']")
	public WebElement logAcc;
	
	//@FindBy(linkText="Logout")
	//@FindBy(xpath="//a[contains(text(),'Logout')])[2]")
	//@FindBy(xpath="//a[contains(@href, '/default/auth/logout')])[2]")
	//@FindBy(xpath="//*[@id='login']/a")
	@FindBy(css="[title='Logout']")
	public WebElement logOutLink;
	
	public void clickLogOutLink()
	{
		try{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login/Account")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/menu/list/id/335'],[title='Login/Account']")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']/a")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dealer Portal")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Dealer Portal']")));
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
