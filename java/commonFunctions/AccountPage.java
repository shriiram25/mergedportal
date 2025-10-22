package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utility.ErrorMessage;
import utility.GetScreenshot;

public class AccountPage {
	
	
public WebDriver driver; //Declaring object for WebDriver
	
	/* Constructor to initialize the object created for WebDriver */	
   public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(linkText="Account") //To locate the linkText named account in DOM
	public WebElement Account;  //Declaring a web element named Account
	
	public void clickAccount()  //Function to click on the linkText named account
	{
		try{
		driver.switchTo().defaultContent();  //instructing driver to Switch to default content from frame
		WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Account"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
		Account.click(); //Clicking on linkText named Account
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			ErrorMessage.captureErrorMessage("errorMsg"); //Capturing error message
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(linkText="Change Password") //To locate the linkText named Change Password in DOM
	public WebElement changepassword;   //Declaring a web element named changepassword
	
	public void clickChangePassword()   //Function to click on the linkText named Change Password
	{
		try{
		WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Change Password"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
		changepassword.click();  //Clicking linkText named Change Password
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(linkText="Logout")  //To locate the linkText named Logout in DOM
	public WebElement logout;   //Declaring a web element named logout
	
	public void Logout(){       //Function to click on the linkText named Change Password
		try{
		driver.switchTo().defaultContent();  //instructing driver to Switch to default content from frame
		WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
		logout.click();  //Clicking linkText named Logout
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
