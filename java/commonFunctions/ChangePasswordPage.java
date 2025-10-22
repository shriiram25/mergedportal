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
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class ChangePasswordPage {
	
		public WebDriver driver;  //Creating an object to WebDriver
		
		//Declaring String variables to make use for the excel
		public String currpwd;
		public String newPwsd;
		public String confmPwd;
	
		/* Constructor to initialize the object created for WebDriver */
		public ChangePasswordPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);	
		}

		/* Constructor to initialize the variables declared before */
		public void changePassword(String cpwd, String npwd, String cnpwd) {
			currpwd = cpwd;
			newPwsd = npwd;
			confmPwd = cnpwd;
			currentPassword(cpwd);
			newPassword(npwd);
			confirmNewPassword(cnpwd);		
		}

		
	@FindBy(id="currPwd")  //To locate the textbox with id 'currPwd' in DOM
	public WebElement currPwd;  //Declaring a WebElement named currPwd
	 
	public void currentPassword(String cpwd)  //Function to type text in textbox with id currPwd
	{
		try{			
			driver.switchTo().frame(0);  //Instructing web driver to switch to the first frame
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("currPwd")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			currPwd.sendKeys(cpwd);  //sending text to the textbox with id currPwd
			}		
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	
	@FindBy(id="newPwd")  //To locate the textbox with id 'newPwd' in DOM
	public WebElement newPwd;  //Declaring a WebElement named newPwd
	
	public void newPassword(String npwd)  //Function to type text in textbox with id newPwd
	{
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("newPwd")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			newPwd.sendKeys(npwd);  //sending text to the textbox with id newPwd
			}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="confrmPwd")  //To locate the textbox with id 'confrmPwd' in DOM
	public WebElement confrmPwd;  //Declaring a WebElement named confrmPwd
	
	public void confirmNewPassword(String cnpwd)  //Function to type text in textbox with id confrmPwd
	{
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);   //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("confrmPwd")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			confrmPwd.sendKeys(cnpwd);    //sending text to the textbox with id confrmPwd
			}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="changePassword")   //To locate the button with id 'changePassword' in DOM	 
	public WebElement changepwdbtn;  //Declaring a WebElement named changepwdbtn
	
	public void changePwdBtn()   //Function to click on the button with id changePassword
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);   //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("changePassword")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			changepwdbtn.click();  //Clicking the button with id changePassword
			writeExcel();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Account")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			ErrorMessage.captureErrorMessage("errorMsg"); //Capturing error message
			writeExcel();  //Calling the function to write data to excel sheet
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="change_password_back")	 //To locate the button with id 'change_password_back' in DOM
	public WebElement pwdbackbtn;  //Declaring a WebElement named pwdbackbtn
	
	public void pwdBackBtn()   //Function to click on the button with id change_password_back
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);   //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("change_password_back")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			pwdbackbtn.click();  //Clicking the button with id change_password_back
			}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	public void  writeExcel()   //Function for writing data to excel sheet
	{		 
		try{	
			
			String[] valueToWriteNew=null;  //Declaring an array of string to store the data
			valueToWriteNew = new String[5]; //Initializing string with size
			valueToWriteNew[1]= newPwsd;   //Assigning data to the string array
			valueToWriteNew[2]= confmPwd; 		
			valueToWriteNew[3]= ErrorMessage.ErrorMessage;
			valueToWriteNew[4]= GetScreenshot.filename;		
 		
			//ExcelReadWrite ERW=new ExcelReadWrite();   //Creating object to the class named ExcelReadWrite
			//ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "ChangePassword",valueToWriteNew);   //Calling function to writing data to excel sheet
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}
