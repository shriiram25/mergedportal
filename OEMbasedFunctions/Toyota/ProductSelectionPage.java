package Toyota;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import configurations.Hooks;
import utility.Log;
import utility.CurrentDateSelection;
import utility.GetScreenshot;

public class ProductSelectionPage {
	
	public WebDriver driver;
	
	public ProductSelectionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="saleDate")
	public WebElement sale;
	
	@FindBy(className="ui-datepicker-trigger")
	public WebElement date;
	
	public void enterSaleDate()
	{
		try{			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-trigger")));
			String toDay=CurrentDateSelection.getCurrentDate();
			sale.sendKeys(toDay);
			//sale.sendKeys(Keys.TAB);
			date.click();
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
//	@FindBy(id="form")
//	public WebElement pro;
	@FindBy(name="form")
	public WebElement pro;
	
	@SuppressWarnings("deprecation")
	public void selectProduct(String SP)
	{
		
		try{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.pollingEvery(2, TimeUnit.MILLISECONDS);
			wait.withTimeout(20, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class); // We need to ignore this exception.

			Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					System.out.println("Checking for the object!!");
//					WebElement element = driver.findElement(By.id("form"));
					WebElement element = driver.findElement(By.name("form"));
					if (element != null) {
						System.out.println("Object is found." + element);						
				}
					return element;
				}
			};
			wait.until(function);
			Select sel=new Select(pro);
			sel.selectByVisibleText(SP);
					
		
		/*	WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form")));
			Select sel=new Select(pro);
			sel.selectByVisibleText(SP);
			Log.log.debug("Select product as:- "+SP); */
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="coverage")
	public WebElement cov;
	
	@SuppressWarnings("deprecation")
	public void selectCoverage(String SC)
	{
		try{
			
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.pollingEvery(2, TimeUnit.MILLISECONDS);
			wait.withTimeout(30, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class); // We need to ignore this exception.

			Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					System.out.println("Checking for the object!!");
					WebElement element = driver.findElement(By.id("coverage"));
					if (element != null) {
						System.out.println("Object is found.");						
				}
					return element;
				}
			};
			wait.until(function);
			Select sel=new Select(cov);
			sel.selectByVisibleText(SC);
			//cov.sendKeys(Keys.TAB);
			Log.log.debug("Select coverage as:- "+SC);
			
			/*WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coverage")));
			Select sel=new Select(cov);
			sel.selectByVisibleText(SC); */
			Log.log.debug("Select coverage as:- "+SC);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement sub;
	
	@FindBy(id="term")
	public WebElement ter;	
	

	public void selectTerm(String TM)
	{
		try{
						
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(sub));
			wait.until(ExpectedConditions.elementToBeClickable(ter));			
			ter.sendKeys(TM); 
			Log.log.debug("Enter Term as:- "+TM); 
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	
	public void submitButton()
	{
		try{
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(sub));
			sub.click();
			Log.log.debug("Click On Submit Button");
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
