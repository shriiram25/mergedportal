package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Log;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
	
	

	@FindBy(id = "langId")
	public WebElement Language;
	
	@FindBy(xpath = "//input[@type = 'submit' and @value = 'Continue']")
	public WebElement Cont_Btn;
	
	public void Select_Language(String language){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOf(Cont_Btn)); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Select sel = new Select(Language);
			sel.selectByVisibleText(language);
			Thread.sleep(1000L);
			Cont_Btn.click();
			Log.log.debug("Passed: Select Language:-" +language);
		}
		catch(Exception e){
			e.printStackTrace();
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Log.log.debug("Failed: Unable to Select the Language:-"+ language);
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="username") //To locate the username text field in DOM
	public WebElement uId; //Declaring a web element named uId
	public void userID(String UserName)  //Function to enter the user id.
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20); //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			uId.sendKeys(UserName);  //Sending data to the text field to the user id
			Log.log.debug("Passed: Enter the Username:-" +UserName);
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Log.log.debug("Failed: Unable to Enter the Username");
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="password")//To locate the password text field in DOM
	public WebElement password; //Declaring a web element named password
	public void userPassword(String Password) //Function to enter the password
	{
		try{	
			WebDriverWait wait = new WebDriverWait(driver,20);//Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			if(Password.contains("******")){				
				Password = "test@1234";
			}
			password.sendKeys(Password); //Sending data to the text field to the password
			Log.log.debug("Passed: Password entered successfully");
		}
		catch(Exception e)
		{
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Log.log.debug("Failed: Unable to Enter the password");
			Assert.assertTrue(e.getMessage(),false);
		}
		
	}	
	
	@FindBy(id="login") //To locate the login button in DOM
	public WebElement submitButton; //Declaring a web element named submitButton
	@SuppressWarnings("finally")
	public boolean clickLogin() //Function to click the button
	{		
		boolean flag = false;
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);	 //Setting waiting time of web driver		
			wait.until(ExpectedConditions.elementToBeClickable(submitButton)); //Instructing web driver to wait until the visibility of element by its locator before it throws error			
			submitButton.click(); //Clicking the button
			Log.log.debug("Passed: Click Login Button User login Successfully" );
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Resources")));//Instructing web driver to wait until the visibility of element by its locator before it throws error
		     flag =true;
		}
		catch (Exception e)
		{	
			Log.log.debug("Failed: User unable to Login into the portal :-");
			flag=false;
			//Assert.assertTrue(e.getMessage(),false);
		}
		finally{
			return flag;	
		}
		
	}
	
}

