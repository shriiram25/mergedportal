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

public class AddLienholderPage {
	
public WebDriver driver; //Declaring object for WebDriver
	
/* Constructor to initialize the object created for WebDriver */
	public AddLienholderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="lien-btn")  //To locate the button with id 'lien-btn' in DOM
	public WebElement lienbtn;  //Declaring a WebElement named lienbtn
	public void lineBtn()  //Function to click on button with id 'lien-btn'
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);	//Setting waiting time of web driver								
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-btn")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			lienbtn.click();  //Clicking on button with id lien-btn			
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="add-lien-btn")  //To locate the button with id 'add-lien-btn' in DOM
	public WebElement addlienbtn; //Declaring a WebElement named addlienbtn
	public void addLienBtn()  //Function to click on button with id 'add-lien-btn'
	{	
	try{
			WebDriverWait wait = new WebDriverWait(driver,20);	//Setting waiting time of web driver								
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-lien-btn")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			addlienbtn.click();	 //Clicking on button with id add-lien-btn			
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="lien_name")  //To locate the textbox with id 'lien_name' in DOM
	public WebElement lien_name;  //Declaring a WebElement named addlienbtn
	public void lienName(String lienname)  //Function to type text in textbox with id lien_name
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);	//Setting waiting time of web driver								
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien_name")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			lien_name.sendKeys(lienname);	 //sending text to the textbox with id lien_name				
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();   //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="lien_address")  //To locate the textbox with id 'lien_address' in DOM
	public WebElement lien_address;  //Declaring a WebElement named lien_address
	public void lienAddress(String lienaddress)  //Function to type text in textbox with id lien_address
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);	//Setting waiting time of web driver								
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien_address")));   //Instructing web driver to wait until the visibility of element by its locator before it throws error
			lien_address.sendKeys(lienaddress);	  //sending text to the textbox with id lien_address					
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="lien_zip")   //To locate the textbox with id 'zip' in DOM
	public WebElement lien_zip; //Declaring a WebElement named lien_zip
	public void lienZip(String lienzip) //Function to click ob button with id lien-added-btn
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);	 //Setting waiting time of web driver								
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien_zip"))); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			lien_zip.sendKeys(lienzip);//Sending data to zip
			driver.findElement(By.id("lien_city")).click(); //	clicking the city field 		
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();   //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}

	@FindBy(id="lien-added-btn")   //To locate the button with id 'lien-added-btn' in DOM
	public WebElement lienaddedbtn;  //Declaring a WebElement named lienaddedbtn
	public void lienAddedBtn()  //Function to click ob button with id lien-added-btn
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);	//Setting waiting time of web driver								
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-added-btn")));  //Instructing web driver to wait until the visibility of element by its locator before it throws error
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingzip")));    //Instructing web driver to wait until the invisibility of element by its locator
			lienaddedbtn.click();	//Clicking on button with id lien-added-btn					
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();   //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
	
	@FindBy(id="lien-back-added-btn")   //To locate the button with id 'lien-back-added-btn' in DOM
	public WebElement lienbackaddedbtn;  //Declaring a WebElement named lienaddedbtn
	public void lienBackAddedBtn()   //Function to type text in textbox with id lien-added-btn
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);   //Setting waiting time of web driver									
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-back-added-btn")));	//Instructing web driver to wait until the visibility of element by its locator before it throws error		
			lienbackaddedbtn.click();	//Clicking on button with id lien-back-added-btn					
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();  //Capturing screenshot
			Assert.assertTrue(e.getMessage(),false);
		}		
	}
}

