package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GetScreenshot;

public class ForgotUserNamePage {
	
public WebDriver driver;
	
	public ForgotUserNamePage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="emailID") //To locate the button with id 'emailID' in DOM
	public WebElement emailID;	 //Declaring a WebElement named emailID
	
	//function to enter email id
	public void giveEmailId(String email){
		try{	
			
			WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailID"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			emailID.sendKeys(email);  // sending the data to the text field	 
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	@FindBy(id="requestUsername") //To locate the button with id 'requestUsername' in DOM
	public WebElement requestUserNameButton;//Declaring a WebElement named requestUserNameButton
	//function to click the button requestUserNameButton
	public void requestUserName(){
		try{	
			
			WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("requestUsername"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			requestUserNameButton.click();	//clicking the button called  requestUserNameButton
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	@FindBy(id="captcha") //To locate the button with id 'captcha' in DOM
	public WebElement captcha;	//Declaring a WebElement named emailID
	//function to enter captcha
	public void enterCaptcha(String captchastring){
		try{	
			GetScreenshot.captureScreenshot(); // Get screen shot.
			WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captcha"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			captcha.sendKeys(captchastring);  // sending the data to the text field
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	@FindBy(xpath="//*[@id='forgotUserNameForm']/span/center/button[1]") //To locate the button with xpath in DOM
	public WebElement backButton; //Declaring a WebElement named backButton
	// to go back to the login screen
	public void goBack(){
		try{	
			
			WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='forgotUserNameForm']/span/center/button[1]"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			backButton.click();	//clicking the button called  backButton
		} 
		catch(Exception e){
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
}
