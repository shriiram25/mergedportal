package agents.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;
import configurations.Hooks;
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
	
	public void selectProduct(String PD)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form")));
			Select select=new Select(product);
			select.selectByVisibleText(PD);
			
			Log.log.debug("Select Product as:- "+PD);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="coverage")
	public WebElement cov;
	
	public void selectCoverage(String CV)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coverage")));
			Select select =new Select(cov);
			select.selectByVisibleText(CV);
			
			Log.log.debug("Select Coverage as:- "+CV);
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
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_range")));
			eTerm.sendKeys(TM);
			
			Log.log.debug("Enter Term as:- "+TM);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	//Selecting Term
	@FindBy(id="term")
	public WebElement eTrm;
	public void selectTerm(String TRM)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term")));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("term")));
			Thread.sleep(5000L);		
			Select select =new Select(eTrm);
			select.selectByVisibleText(TRM);
			
			Log.log.debug("Select Term as:- "+TRM);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	//Click Coverage	
	@FindBy(id="coverage_uvp")
	public WebElement CoverageAll;
	
	@FindBy (id="web_con_coverage")
	public WebElement CoverageAll_PREMIER_ULTIMATE;
	
	@FindBy(id="coverage_twr")
	public WebElement CoverageTW;
	
	@FindBy(id="coverage_t")
	public WebElement CoverageTW_PREMIER;
	
	@FindBy(id="coverage_ddp")
	public WebElement CoveragePDR;
	
	@FindBy(id="coverage_d")
	public WebElement CoverageD_DENT;
	
	/*@FindBy(id="coverage_rs")   
	public WebElement CoverageRA;*/
	
	@FindBy(id="coverage_r")   
	public WebElement CoverageRS;
	
	/*@FindBy(id="coverage_key")
	public WebElement CoverageKey;*/
	
	@FindBy(id="coverage_k")
	public WebElement CoverageKey;
	
	
	public void clickCoverage(String Coverage)
	{
		try{
			
			if(Coverage.equalsIgnoreCase("Ultimate Vehicle Protection"))
			{
				CoverageAll.click();
				
			}else {
				if(Coverage.contains("PREMIER ULTIMATE VEHICLE PROTECTION PLUS"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("web_con_coverage")));
					CoverageAll_PREMIER_ULTIMATE.click();				
				}
			if(Coverage.equalsIgnoreCase("Tire and Wheel"))
			{
				CoverageTW.click();
			}else {
				if(Coverage.contains("PREMIER TIRE & WHEEL"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_t")));
					CoverageTW_PREMIER.click();				
				}
			if(Coverage.equalsIgnoreCase("Paintless Dent Repair"))
			{
				CoveragePDR.click();
			}else {
				if(Coverage.contains("DENT & DING PROTECTION"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_d")));
					CoverageD_DENT.click();				
				}
			if(Coverage.equalsIgnoreCase("Roadside Assistance"))
			{
				CoverageRS.click();
			}/*else {
				if(Coverage.contains("ROADSIDE ASSISTANCE"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_r")));
					CoverageRS.click();				
				}*/
			if(Coverage.equalsIgnoreCase("Key Replacement"))
			{
				CoverageKey.click();
			}/*else {
				if(Coverage.contains("KEY REPLACEMENT"))
				{
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.id("coverage_k")));
					CoverageK_KEY.click();				
				}*/
			
			Log.log.debug("Selected coverage as:- "+Coverage);
		}
			}}}
			catch(Exception e){
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
			wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
			sub.click();
			
			Log.log.debug("Click on Submit Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
