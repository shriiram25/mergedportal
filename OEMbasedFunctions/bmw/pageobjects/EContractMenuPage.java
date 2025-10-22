package bmw.pageobjects;

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
import utility.GetScreenshot;
import utility.Log;

public class EContractMenuPage {
	
	public WebDriver driver;
	
	public EContractMenuPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//@FindBy(linkText="E-Submissions")
	//@FindBy(xpath="//*[@id='nav_wrapper']/ul/li[6]/a") //*[@id='nav_wrapper']/ul/li[5]/a
	@FindBy(css="[href='/menu/list/id/212'],[title='E-Submissions']")
	//@FindBy(css="[title='E-Submissions']")
	public WebElement eCon;
	
	//@FindBy(linkText="Add New E-submission")
	//@FindBy(xpath="//*[@id='nav_wrapper']/ul/li[6]/ul/li[1]/a")  //*[@id='nav_wrapper']/ul/li[5]/ul/li[1]/a
	@FindBy(css="[href='/form/remit/select'],[title='Add New E-submission']")
	//@FindBy(css="[title='Add New E-submission']")
	public WebElement addECon;
	
	public void clickEContract()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("E-Submissions")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav_wrapper']/ul/li[6]/a")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/menu/list/id/212'],[title='E-Submissions']")));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='E-Submissions']")));		
			Actions action=new Actions(driver);
			action.moveToElement(eCon).perform();
			addECon.click();
			
			
			
			Log.log.debug("Click on Add New E-submission Menu");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
