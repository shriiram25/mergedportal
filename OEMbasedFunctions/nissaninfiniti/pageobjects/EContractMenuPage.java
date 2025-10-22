package nissaninfiniti.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import utility.GetScreenshot;

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
			//wait.until(ExpectedConditions.visibilityOf(eCon));
					
			Actions action=new Actions(driver);
			action.moveToElement(eCon).perform();
			addECon.click();
			
			
			Log.log.debug("Click on Add New E-contract Menu");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
