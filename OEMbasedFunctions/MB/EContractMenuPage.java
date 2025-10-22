package MB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import MB.Hooks;
import junit.framework.Assert;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

public class EContractMenuPage {
	
	public WebDriver driver;
	
	public EContractMenuPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="E-Contracting")
	public WebElement eCon;
	
	@FindBy(linkText="Add New E-contract")
	public WebElement addECon;
	
	public void clickEContract()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("E-Contracting")));
			
			Actions action=new Actions(driver);
			action.moveToElement(eCon).perform();
			addECon.click();
			
			
			Log.log.debug("Click on Add New E-contract Menu");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

	@FindBy(xpath="//*[contains(text(),'VIEW/DOWNLOAD CUSTOMER CONTRACT')]")
	public WebElement viewDownload;
	
	@FindBy(linkText="View / Edit / Remit E-contracts")
	public WebElement viewECon;
	
	public void clickViewEContract()
	{
		try{
			Thread.sleep(10000L);			
			WebDriverWait wait = new WebDriverWait(driver, 30);			
			//wait.until(ExpectedConditions.visibilityOf(viewDownload));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("E-Contracting")));
	
			Actions action=new Actions(driver);
			action.moveToElement(eCon).perform();
			viewECon.click();
						
			Log.log.debug("Click on View / Edit / Remit E-contracts Menu");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
