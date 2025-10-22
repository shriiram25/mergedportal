package nissaninfiniti.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import org.junit.Assert;
import utility.Log;
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form")));
			wait.until(ExpectedConditions.visibilityOf(product));
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coverage")));
			wait.until(ExpectedConditions.visibilityOf(coverage));
			Select select=new Select(coverage);
			select.selectByVisibleText(Coverage);
						
			Log.log.debug("Select Coverage as:- "+Coverage);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="coverage_uvp")
	public WebElement platinumCoverage;
	
	@FindBy(id="coverage_uvp1")
	public WebElement goldCoverage;
	
	@FindBy(id="coverage_uvp2")
	public WebElement silverCoverage;
	
	@FindBy(id="coverage_twr")
	public WebElement CoverageTire;
	
	@FindBy(id="coverage_ddp")
	public WebElement coverageDent;
	
	@FindBy(id="coverage_wrp")
	public WebElement coverageWindshield;
	
	@FindBy(id="coverage_key")
	public WebElement coverageKey;
	
	public void clickCoverage(String Coverage)
	{
		try{
			
			if(Coverage.equalsIgnoreCase("Platinum"))
			{
				platinumCoverage.click();
			}
			if(Coverage.equalsIgnoreCase("Gold"))
			{
				goldCoverage.click();
			}
			if(Coverage.equalsIgnoreCase("Silver"))
			{
				silverCoverage.click();
			}
			/*if(Coverage.equalsIgnoreCase("P"))
			{
				CoverageTire.click();
			}			
			if(Coverage.equalsIgnoreCase("X"))
			{
				coverageWindshield.click();
			}
			if(Coverage.equalsIgnoreCase("D"))
			{
				coverageDent.click();
			}
			if(Coverage.equalsIgnoreCase("K"))
			{
				coverageKey.click();
			}*/
			
			if(Coverage.contains("P"))
			{
				CoverageTire.click();
			}
			if(Coverage.contains("X"))
			{
				coverageWindshield.click();
			}
			if(Coverage.contains("D"))
			{
				coverageDent.click();
			}
			if(Coverage.contains("K"))
			{
				coverageKey.click();
			}			
			
			Log.log.debug("Selected coverage as:- "+Coverage);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="term")
	public WebElement enterTerm;
	
	@FindBy(id="term_range")
	public WebElement termRange;
	
	public void enterTerm(String Term)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term_range")));
			wait.until(ExpectedConditions.visibilityOf(termRange));
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("term")));
			wait.until(ExpectedConditions.elementToBeClickable(enterTerm));
			//Thread.sleep(4000L);
			enterTerm.sendKeys(Term);
			
			Log.log.debug("Enter Term as:- "+Term);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="term")
	public WebElement selectTerm;
	
	public void selectTerm(String Term)
	{
		try{
			Thread.sleep(3000L);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("term")));
			wait.until(ExpectedConditions.visibilityOf(selectTerm));
			Select select=new Select(selectTerm);
			select.selectByVisibleText(Term);
						
			Log.log.debug("Select Term as:- "+Term);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement submit;
	
	public void clickSubmit()
	{
		try{
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
			wait.until(ExpectedConditions.elementToBeClickable(submit));
			submit.click();
			
			Log.log.debug("Click on Submit Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
		
}