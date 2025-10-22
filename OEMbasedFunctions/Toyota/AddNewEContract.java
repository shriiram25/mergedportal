package Toyota;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

import utility.GetScreenshot;

public class AddNewEContract {
	
	public WebDriver driver;
	
	public AddNewEContract(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="E-Contracting")
	public WebElement econ;
	
	public void eContracting()
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(econ));
			//econ.click();
			Actions action=new Actions(driver);
			action.moveToElement(econ).perform();
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(linkText="Add New E-contract")
	public WebElement addECon;
	
	public void addEContract()
	{
		try{
			//Thread.sleep(2000L);
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(addECon));
			addECon.click();
		    Log.log.debug("Click on Add New E-contract Link");
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
