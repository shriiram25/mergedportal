package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utility.ErrorMessage;
import utility.GetScreenshot;
import utility.Log;

public class E_ContractingPage {

	public WebDriver driver;  //Creating object for WebDriver
	
	
	/* Constructor to initialize the object created for WebDriver */
	public E_ContractingPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="eContracting")  //To locate the linkText with name 'eContracting' in DOM
	public WebElement econ;  //Declaring a WebElement named econ
	
	public void econMenu()  //Function to click on linkText with name eContracting
	{
		try{	
			//driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("eContracting")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			econ.click();  //Clicking on linkText with name eContracting	
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			ErrorMessage.captureErrorMessage("loginFailure");  //Capturing error message
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	@FindBy(linkText="eContracting / eQuote")  //To locate the linkText with name 'eContracting' in DOM
	public WebElement econ1;  //Declaring a WebElement named econ
	
	@FindBy(linkText="Add New eContract")  //To locate the linkText with name 'Add New eContract' in DOM
	public WebElement Addnewlnk;  //Declaring a WebElement named Addnew
	
	public void econMenuVCI()  //Function to click on linkText with name eContracting
	{
		try{	
		//	driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("eContracting / eQuote")));  
			
			Actions action = new Actions(driver);		//Instructing web driver to wait until the visibility of element by its locator before it throws error
			action.moveToElement(econ1).perform();
			Addnewlnk.click();  //Clicking on linkText with name eContracting	
			Log.log.debug("Passed: Click on Add New Econtract");
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			ErrorMessage.captureErrorMessage("Unable to Click E-Contract Link");  //Capturing error message
			Log.log.debug("Failed: Unable to Click on Add New Contract");
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	
	@FindBy(linkText="Add New eContract")  //To locate the linkText with name 'Add New eContract' in DOM
	public WebElement Addnew;  //Declaring a WebElement named Addnew
	
	public void addContractbtn()  //Function to click on linkText with name Add New eContract
	{
		try{						
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New eContract")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			Addnew.click();  //Clicking on linkText with name Add New eContract
			Log.log.debug("Passed: Click on Add New Contract");
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Log.log.debug("Failed: Unable to Click on Add New Contract");
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(linkText="Submit eContracts")  //To locate the linkText with name 'Submit eContracts' in DOM
	public WebElement submitcontract;  //Declaring a WebElement named submitcontract
	
	public void clicksubmitEcontracts()  //Function to click on linkText with name Submit eContracts
	{
		try{			
			//driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Submit eContracts")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			submitcontract.click();  //Clicking on linkText with name Submit eContracts
			Log.log.debug("Passed: Click on Submit button");
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Log.log.debug("Failed: Unable to Click on Submit button");
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	//Added for Alphera portal
	@FindBy(linkText="eSubmissions(s)")  //To locate the linkText with name 'eContracting' in DOM
	public WebElement eSub;  //Declaring a WebElement named econ
	
	public void eSubmissions()  //Function to click on linkText with name eContracting
	{
		try{	
			//driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("eSubmissions(s)")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			eSub.click();  //Clicking on linkText with name eContracting
			Log.log.debug("Passed: Click on Submission button" );
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			ErrorMessage.captureErrorMessage("loginFailure");  //Capturing error message
			Log.log.debug("Failed: Unable to Click on Submit button");
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	
	@FindBy(linkText="Add New eSubmissions")  //To locate the linkText with name 'Add New eContract' in DOM
	public WebElement AddnewEsub;  //Declaring a WebElement named Addnew
	
	public void addNewEsubmission()  //Function to click on linkText with name Add New eContract
	{
		try{						
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New eSubmissions")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			AddnewEsub.click();  //Clicking on linkText with name Add New eContract
			Log.log.debug("Passed: Click on Add New ESubmission" );
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot(); //Capturing screenshot
			Log.log.debug("Failed: Unable to Click on Add New ESubmission");
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	// RollsRoyce
			@FindBy(linkText="eSubmission")  //To locate the linkText with name 'eContracting' in DOM
			public WebElement eSubmission;  //Declaring a WebElement named econ
			
			public void eSubmissionMenu()  //Function to click on linkText with name eContracting
			{
				try{	
					//driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
					WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
					wait.until(ExpectedConditions.visibilityOf(eSubmission));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
					eSubmission.click();  //Clicking on linkText with name eContracting	
					Log.log.debug("Passed: Click on ESubmission");
				}
				catch(Exception e){
					GetScreenshot.captureScreenshot();  //Capturing screenshot
					ErrorMessage.captureErrorMessage("loginFailure");  //Capturing error message
					Log.log.debug("Failed: Unable to Click  on ESubmission");
					Assert.assertTrue(e.getMessage(), false);			
				}
			}
			
			@FindBy(linkText="Add New eSubmission")  //To locate the linkText with name 'Add New eContract' in DOM
			public WebElement AddneweSubmission;  //Declaring a WebElement named Addnew
			
			public void addSubmissionbtn()  //Function to click on linkText with name Add New eContract
			{
				try{						
					WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
					wait.until(ExpectedConditions.visibilityOf(AddneweSubmission));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
					AddneweSubmission.click();  //Clicking on linkText with name Add New eContract
					//Log.log.debug("Passed: Click on :-" + AddneweSubmission);
				}
				catch(Exception e){
					GetScreenshot.captureScreenshot(); //Capturing screenshot
					Log.log.debug("Failed: Unable to Click on :-" + AddneweSubmission);
					Assert.assertTrue(e.getMessage(), false);
				}
			}
	
//			public void econMenuLinkPB()  //Function to click on linkText with name eContracting
//			{
//				try{	
//				//	driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
//					WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("eContracting / eQuote"))); 
//					
//					Actions action = new Actions(driver);		//Instructing web driver to wait until the visibility of element by its locator before it throws error
//					action.moveToElement(econ1).perform();
//					Addnewlnk.click();  //Clicking on linkText with name eContracting	
//					Log.log.debug("Passed: Click on Add New Econtract");
//				}
//				catch(Exception e){
//					GetScreenshot.captureScreenshot();  //Capturing screenshot
//					ErrorMessage.captureErrorMessage("Unable to Click E-Contract Link");  //Capturing error message
//					Log.log.debug("Failed: Unable to Click on Add New Contract");
//					Assert.assertTrue(e.getMessage(), false);			
//				}
//			}
			
//			
			public void econMenuLink()  //Function to click on linkText with name eContracting
			{
				try{	
				//	driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
					WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("eContracting"))); 
					
					Actions action = new Actions(driver);		//Instructing web driver to wait until the visibility of element by its locator before it throws error
					action.moveToElement(econ).perform();
					Addnewlnk.click();  //Clicking on linkText with name eContracting	
					Log.log.debug("Passed: Click on Add New Econtract");
				}
				catch(Exception e){
					GetScreenshot.captureScreenshot();  //Capturing screenshot
					ErrorMessage.captureErrorMessage("Unable to Click E-Contract Link");  //Capturing error message
					Log.log.debug("Failed: Unable to Click on Add New Contract");
					Assert.assertTrue(e.getMessage(), false);			
				}
			}
			
			public void eSubsMenuLink()  //Function to click on linkText with name eContracting
			{
				try{	
				//	driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
					WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("eSubmissions(s)"))); 
					
					Actions action = new Actions(driver);		//Instructing web driver to wait until the visibility of element by its locator before it throws error
					action.moveToElement(eSub).perform();
					AddnewEsub.click();  //Clicking on linkText with name eSub	
					Log.log.debug("Passed: Click on Add New Submission");
				}
				catch(Exception e){
					GetScreenshot.captureScreenshot();  //Capturing screenshot
					ErrorMessage.captureErrorMessage("Unable to Click E-Submission Link");  //Capturing error message
					Log.log.debug("Failed: Unable to Click on Add New Submission");
					Assert.assertTrue(e.getMessage(), false);			
				}
			}
			
			public void eSubmissionMenuLink()  //Function to click on linkText with name eContracting
			{
				try{	
				//	driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
					WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("eSubmission"))); 
					
					Actions action = new Actions(driver);		//Instructing web driver to wait until the visibility of element by its locator before it throws error
					action.moveToElement(eSubmission).perform();
					AddneweSubmission.click();  //Clicking on linkText with name eSub	
					Log.log.debug("Passed: Click on Add New Submission");
				}
				catch(Exception e){
					GetScreenshot.captureScreenshot();  //Capturing screenshot
					ErrorMessage.captureErrorMessage("Unable to Click E-Submission Link");  //Capturing error message
					Log.log.debug("Failed: Unable to Click on Add New Submission");
					Assert.assertTrue(e.getMessage(), false);			
				}
			}
			
	
	@FindBy(linkText="Submit eSubmissions")  //To locate the linkText with name 'Submit eContracts' in DOM
	public WebElement submitEsum;  //Declaring a WebElement named submitcontract
	
	public void submitEsubmission()  //Function to click on linkText with name Submit eContracts
	{
		try{			
			//driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Submit eSubmissions")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			submitEsum.click();  //Clicking on linkText with name Submit eContracts
			Log.log.debug("Passed: Click on :-" + submitEsum);
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Log.log.debug("Failed: Unable to Click on :-" + submitEsum);
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	//<<<-- Created WebElement & Method for Create New eContract under E-Contracting Menu	
	@FindBy(linkText="Create New eContract")  //To locate the linkText with name 'Create New eContract' in DOM
	public WebElement create_New_eContract;  //Declaring a WebElement named create_New_eContract	
	
	public void econMenuLinkBMW()  //Function to click on linkText with name eContracting
	{
		try{	
		//	driver.switchTo().defaultContent();  //Instructing driver object to switch to default content
			WebDriverWait wait = new WebDriverWait(driver,20);  //Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOf(econ1)); 
			
			Actions action = new Actions(driver);		//Instructing web driver to wait until the visibility of element by its locator before it throws error
			action.moveToElement(econ1).perform();
			create_New_eContract.click();  //Clicking on linkText with name eContracting	
			Log.log.debug("Passed: Click on Create New eContract");
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			ErrorMessage.captureErrorMessage("Unable to Click E-Contract Link");  //Capturing error message
			Log.log.debug("Failed: Unable to Click on Create New eContract");
			Assert.assertTrue(e.getMessage(), false);			
		}
	}
	
	
}
