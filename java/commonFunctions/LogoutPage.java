package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

import utility.GetScreenshot;

public class LogoutPage {

	public WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		/*
		  Finding  linkText of the  logout element 
		 */
	
	@FindBy(linkText="Logout") //To locate the button with id 'Logout' in DOM
	public WebElement userlogout; //Declaring a WebElement named userlogout
	//click logout
	public void logout() //Function for click logout
	{
		try{
		driver.switchTo().defaultContent();// switching to the default frame.
		WebDriverWait wait = new WebDriverWait(driver, 30);//Setting waiting time of web driver
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
		userlogout.click();  //clicking the logout.
		Thread.sleep(1000L);
		Log.log.debug("Passed: Click on Logout button User Logout Successfully ");
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); // get screen shot
			Log.log.debug("Failed: Unable to Click on Logout button");
			Assert.assertTrue(e.getMessage(),false);		
		}
	}
}
