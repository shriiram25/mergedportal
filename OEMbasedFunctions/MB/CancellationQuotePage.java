package MB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

public class CancellationQuotePage {

public WebDriver driver;
	
	public CancellationQuotePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//@FindBy(linkText="Reports")
	@FindBy(css="[title='Reports']")
	public WebElement ReportCQ;
	
	@FindBy(linkText="Cancellation Quote")
	//@FindBy(css="[title='Cancellation Quote']")
	public WebElement CQuote;
	
	public void clickECancellationQuote()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Reports")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Reports']")));
			
			Actions action=new Actions(driver);
			action.moveToElement(ReportCQ).perform();
			CQuote.click();			
			
			Log.log.debug("Click on Cancellation Quote Menu");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="fname")
	public WebElement enterFname;
	
	public void enterFName(String FN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname")));
			enterFname.sendKeys(FN);
			
			Log.log.debug("Enter First Name as:- "+FN);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="lname")
	public WebElement enterLname;
	
	public void enterLName(String LN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lname")));
			enterLname.sendKeys(LN);
			
			Log.log.debug("Enter Last Name as:- "+LN);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="vin")
	public WebElement enterVin;
	
	public void enterVin(String V)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vin")));
			enterVin.sendKeys(V);
			
			Log.log.debug("Enter Last Name as:- "+V);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="submit")
	public WebElement sbmt;
	
	public void clickSubmit()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			sbmt.click();
						
			Log.log.debug("Click on Submit Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	public void clickContractID(String CID)
	{
		try{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(CID)));
		driver.findElement(By.linkText(CID)).click();
		}
		catch(Exception e)
		{
			System.out.println("User is in Contract Details Page");
		}
	}	
	
	@FindBy(id="quoteButton")
	public WebElement QButton;
	
	public void clickCancellationQuote()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quoteButton")));
			QButton.click();
			Thread.sleep(5000L);
			Log.log.debug("Click on Cancellation Quote Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="f-calendar-field-1")
	public WebElement eDate;
	
	public void enterDate(String ED)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("f-calendar-field-1")));
			eDate.clear();
			eDate.sendKeys(ED);
			
			Log.log.debug("Enter Date as:- "+ED);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="method-0")
	public WebElement Prorata;
	
	@FindBy(id="method-1")
	public WebElement Rule78;
	
	public void clickMethodOfCancellation(String MOC)
	{
		if(MOC.equalsIgnoreCase("Pro-rata"))
		{
			if(!Prorata.isSelected())
			{				
			    Prorata.click();
			}
		}
		
		if(MOC.equalsIgnoreCase("Rule of 78"))
		{
			if(!Rule78.isSelected())
			{				
				Rule78.click();
			}			
		}
		
		Log.log.debug("Select Method of Cancellation as:- "+MOC);
	}
	
	
	@FindBy(id="cost")
	public WebElement eCost;
	
	public void enterCost(String EC)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cost")));
			eCost.clear();
			eCost.sendKeys(EC);
			
			Log.log.debug("Enter Cost as:- "+EC);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="reason")
	public WebElement CReason;
	
	public void selectCancellationReason(String SCR)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reason")));
			Select select=new Select(CReason);
			select.selectByVisibleText(SCR);
			
			Log.log.debug("Select CancellationReason as:- "+SCR);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

	@FindBy(id="quoteSubmit")
	public WebElement qsbmt;
	
	@FindBy(id="quoteTable")
	public WebElement qTable;
		
	public void clickQuoteSubmit()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quoteSubmit")));
			qsbmt.click();
			//Thread.sleep(3000L);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quoteTable")));
			
			Log.log.debug("Click on Submit Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(xpath="//*[@id='quoteTableTbody']/tr/td[2]")
	public WebElement ActFactor;
			
	@FindBy(xpath="//*[@id='quoteTableTbody']/tr/td[4]")
	public WebElement ActDealerRefund;
	
	@FindBy(xpath="//*[@id='quoteTableTbody']/tr/td[5]")
	public WebElement ActCustomerRefund;
	
	@FindBy(id="quoteTable")
	public WebElement QuoteTable;	
			
}
