package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ForgotPasswordPage {

public WebDriver driver;  //Creating object for WebDriver
	
	
/* Constructor to initialize the object created for WebDriver */
public ForgotPasswordPage(WebDriver driver)
{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")  //To locate the textbox with id 'username' in DOM
	public WebElement userName;	//Declaring a WebElement named userName
	public void giveUserName(String username)  //Function to type text in textbox with id username
	{
		try{	
			
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			userName.sendKeys(username);  //Sending the given text to the textbox with id username
		}
		catch(Exception e){
			
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	@FindBy(id="captcha")  //To locate the textbox with id 'captcha' in DOM
	public WebElement captcha;  //Declaring a WebElement named captcha
	public void enterCaptcha(String captchastring)  //Function to type text in textbox with id captcha
	{
		try{	
			
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captcha")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			captcha.sendKeys(captchastring);  //Sending the given text to the textbox with id captcha 
		}
		catch(Exception e){
			
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	@FindBy(id="resetpassoword")  //To locate the button with id 'resetpassoword' in DOM
	public WebElement resetPassword;  //Declaring a WebElement named resetPassword	
	public void resetpassword()  //Function to click on the button with id resetpassoword
	{
		try{	
			
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetpassoword")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			resetPassword.click();  //Clicking on button with id resetpassoword 
		}
		catch(Exception e){
			
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	
	
	@FindBy(xpath="//*[@id='forgotPasswordForm']/span/center/button[1]")  //To locate the button with xpath '//*[@id='forgotPasswordForm']/span/center/button[1]' in DOM
	public WebElement goBackButton;	 //Declaring a WebElement named goBackButton	
	public void goBack()  //Function to click on the button with xpath //*[@id='forgotPasswordForm']/span/center/button[1]
	{
		try{	
			
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='forgotPasswordForm']/span/center/button[1]")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			goBackButton.click();  //Clicking on button with xpath //*[@id='forgotPasswordForm']/span/center/button[1]
		}
		catch(Exception e){
			
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
}
