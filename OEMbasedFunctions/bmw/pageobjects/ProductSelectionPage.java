package bmw.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import org.junit.Assert;
import utility.GetScreenshot;

public class ProductSelectionPage {
	
	public WebDriver driver;
	
	public ProductSelectionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="form")
	public WebElement product;
	
	public void selectProduct(String Product)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form")));
			Select select=new Select(product);
			select.selectByVisibleText(Product);
						
			Log.log.debug("Select Product as:- "+Product);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="coverage")
	public WebElement coverage;
	
	public void selectCoverage(String Coverage)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form")));
			Select select=new Select(coverage);
			select.selectByVisibleText(Coverage);
						
			Log.log.debug("Select Coverage as:- "+Coverage);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="coverage_uvp")  
	public WebElement coverageAll;
	
	@FindBy(id="coverage_twr")   
	public WebElement coverageTW;
	
	@FindBy(id="coverage_ddp")  
	public WebElement coveragePDR;
	
	@FindBy(id="coverage_rs")   
	public WebElement coverageRA;
	
	@FindBy(id="coverage_key") 
	public WebElement coverageKey;
	
	// BMW MINI Alaska Coverage code element ID
	
	@FindBy(id="web_con_coverage")  
	public WebElement coverageAll_AK;
	
	@FindBy(id="coverage_t") 
	public WebElement coverage_T_AK;
	
	@FindBy(id="coverage_ws")
	public WebElement coverage_WS_AK;
	
	@FindBy(id="coverage_d")  
	public WebElement coverage_D_AK;
	
	@FindBy(id="coverage_k")
	public WebElement coverage_K_AK;
	
	public void clickCoverage(String Coverage)
	{
		try{
			
			if(Coverage.equalsIgnoreCase("Ultimate Vehicle Protection"))
			{
				coverageAll.click();
			}
			if(Coverage.equalsIgnoreCase("Tire and Wheel"))		
			{
				coverageTW.click();
			}
			if(Coverage.equalsIgnoreCase("Paintless Dent Repair"))		
			{
				coveragePDR.click();
			}
			if(Coverage.equalsIgnoreCase("Roadside Assistance"))
			{
				coverageRA.click();
			}
			if(Coverage.equalsIgnoreCase("Key Replacement"))
			{
				coverageKey.click();
			}
			
			// BMW MINI Alaska Coverage Code Condition
			
			if (Coverage.equalsIgnoreCase("BMW PROTECTION PACKAGE PREMIUM PLUS") || 
				Coverage.equalsIgnoreCase("BMW PROTECTION PACKAGE PREMIUM") || 
				Coverage.equalsIgnoreCase("MINI COSMETIC TIRE/WHEEL, WINDSHIELD, DENT, & KEY"))
			{
				coverageAll_AK.click();
			}
			if(Coverage.equalsIgnoreCase("BMW COSMETIC TIRE/WHEEL")||
			   Coverage.equalsIgnoreCase("MINI COSMETIC TIRE/WHEEL")||
			   Coverage.equalsIgnoreCase("BMW TIRE & WHEEL PROTECTION"))
			{
				coverage_T_AK.click();
			}
			if(Coverage.equalsIgnoreCase("WINDSHIELD PROTECTION"))
			{
				coverage_WS_AK.click();
			}
			if(Coverage.equalsIgnoreCase("DENT & DING PROTECTION"))
			{
				coverage_D_AK.click();
			}
			if(Coverage.equalsIgnoreCase("KEY REPLACEMENT"))
			{
				coverage_K_AK.click();
			}
			
			Log.log.debug("Selected coverage as:- "+Coverage);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	

	@FindBy(id="term")
	public WebElement eTrm;
	public void selectTerm(String Term)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("term")));
			Thread.sleep(5000L);
			Select select =new Select(eTrm);
			select.selectByVisibleText(Term);
			
			Log.log.debug("Select Term as:- "+Term);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="term")
	public WebElement eTerm;
	
	public void enterTerm(String TM)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_range")));
			eTerm.sendKeys(TM);
			
			Log.log.debug("Enter Term as:- "+TM);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="terms")
	public WebElement dTerm;
	public void selectDOTTerm(String Terms)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terms")));
			//Thread.sleep(5000L);
		
			Select select =new Select(dTerm);
			select.selectByVisibleText(Terms);
			
			Log.log.debug("Select DOT Term as:- "+Terms);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="rimsize")
	public WebElement rimSize;
	public void selectRimSize(String RimSize)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rimsize")));
			//Thread.sleep(5000L);
		
			Select select =new Select(rimSize);
			select.selectByVisibleText(RimSize);
			
			Log.log.debug("Select RimSize as:- "+RimSize);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="quantity")
	public WebElement qtty;
	public void selectQuantity(String Qty)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity")));
			//Thread.sleep(5000L);
		
			Select select =new Select(qtty);
			select.selectByValue(Qty);
			
			Log.log.debug("Select Quantity as:- "+Qty);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="dot1")
	public WebElement dot1;
	
	public void enterDOT1(String D1)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dot1")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dot1")));
			//Thread.sleep(3000L);
			dot1.sendKeys(D1);
			
			Log.log.debug("Enter DOT1 as:- "+D1);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="dot2")
	public WebElement dot2;
	
	public void enterDOT2(String D2)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dot2")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dot2")));
			dot2.sendKeys(D2);
			
			Log.log.debug("Enter DOT2 as:- "+D2);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="dot3")
	public WebElement dot3;
	
	public void enterDOT3(String D3)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dot3")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dot3")));
			dot3.sendKeys(D3);
			
			Log.log.debug("Enter DOT3 as:- "+D3);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="dot4")
	public WebElement dot4;
	
	public void enterDOT4(String D4)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dot4")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("dot4")));
			dot4.sendKeys(D4);
			
			Log.log.debug("Enter DOT4 as:- "+D4);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement sub;
	
	public void clickSubmit()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			sub.click();
			
			Log.log.debug("Click on Submit Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
		
	@FindBy(id="submitbtn")
	public WebElement subbtn;
	
	public void clickSubmitBtn()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitbtn")));
			subbtn.click();
			
			Log.log.debug("Click on Submit Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
}
