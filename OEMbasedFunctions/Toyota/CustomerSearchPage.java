package Toyota;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GetScreenshot;
import utility.Log;

public class CustomerSearchPage {
	
	public WebDriver driver;
	
	public CustomerSearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	public WebElement fname;
	
	public void enterFirst(String FN)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
			fname.sendKeys(FN);
			
			Log.log.debug("Enter First Name as:- "+FN);
		}catch(Exception e)
		{
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="lastName")
	public WebElement lname;
	
	public void enterLast(String LN)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
			lname.sendKeys(LN);
			
			Log.log.debug("Enter Last Name as:- "+LN);
		}catch(Exception e)
		{
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="vin")
	public WebElement vinNumber;
	
	public void enterVinNumber(String VN)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vin")));
			vinNumber.sendKeys(VN);
			
			Log.log.debug("Enter Vin Number as:- "+VN);
		}catch(Exception e)
		{
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement search;
	
	public void clickSearch()
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			search.click();
			
			Log.log.debug("Click on Search Button");
		}catch(Exception e)
		{
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
