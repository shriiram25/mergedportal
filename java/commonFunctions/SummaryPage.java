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

public class SummaryPage {
	
	public WebDriver driver;
	
	public SummaryPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);	
	}
		
	@FindBy(id="go-to-summary") //To locate the button with id 'go-to-summary' in DOM
	public WebElement gosummary; //Declaring a WebElement named gosummary
		
	public void goSummary(){
		 try{
			 WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver			 
			 wait.until(ExpectedConditions.elementToBeClickable(gosummary)); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			 gosummary.click();  //clicking the button of  gosummary
			 Thread.sleep(2000);
		 }
		 catch(Exception e){
			 GetScreenshot.captureScreenshot(); // Get the  Screen shot
			 Assert.assertTrue(e.getMessage(),false);	
		 }	
	}	
	
	//<<<-- Click the Manage Saved eContract button
	@FindBy(id="gotoSavedContract") //To locate the button with id 'gotoSavedContract' in DOM
	public WebElement manageSavedEContracts; //Declaring a WebElement named manageSavedEContracts
		
	public void clickManageSavedEContracts(){
		 try{
			 WebDriverWait wait = new WebDriverWait(driver, 20); //Setting waiting time of web driver
			 wait.until(ExpectedConditions.visibilityOf(manageSavedEContracts)); //Instructing web driver to wait until the visibility of element by its locator before it throws error
			 manageSavedEContracts.click();  //clicking on the button Manage Saved eContracts
			 Thread.sleep(2000);
		 }
		 catch(Exception e){
			 GetScreenshot.captureScreenshot(); // Get the  Screen shot
			 Assert.assertTrue(e.getMessage(),false);	
		 }	
	}	
	
}
