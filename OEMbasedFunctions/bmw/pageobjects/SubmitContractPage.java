package bmw.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import utility.CurrentDateSelection;
import utility.GetScreenshot;

public class SubmitContractPage {
	
	public String status=null;
	
	public WebDriver driver;
	
	public SubmitContractPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="econRemitTable")
	public WebElement eTable;
	
	@FindBy(id="submit")
	public WebElement submitAcceptedAgreements;
	
	public void clickSubmitAcceptedAgreements()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
			submitAcceptedAgreements.click();
			Thread.sleep(10000L);
			Log.log.debug("Click on submitAcceptedAgreements Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
				
	}
	
	public void SubmitEContract(String LastName, String FirstName, String VehicleID)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("econRemitTable")));
			
			List<WebElement> tagList=eTable.findElements(By.tagName("tbody"));
			if(tagList.size()>0)
			{
				List<WebElement> trList=tagList.get(0).findElements(By.tagName("tr"));
				if(trList.size()>0)
				{
					
					for(int i=0;i<trList.size();i++)
					{
						List<WebElement> tdList=trList.get(i).findElements(By.tagName("td"));
						String webLastName=tdList.get(2).getText().trim();
						String webFirstName=tdList.get(3).getText().trim();
						String webVin=tdList.get(4).getText();						
						String webDate=tdList.get(8).getText().trim();
						
						
						if(webLastName.equalsIgnoreCase(LastName.trim()) && webFirstName.equalsIgnoreCase(FirstName.trim()) )
						{
							if(webVin.trim().equalsIgnoreCase(VehicleID.trim()) && webDate.equalsIgnoreCase(CurrentDateSelection.getCurrentDate()))
							{
								
								String rawId=trList.get(i).getAttribute("id");								
								rawId=rawId.substring(4);								
								String chkbxId="accepted_"+rawId;								
								WebElement element=driver.findElement(By.id(chkbxId));
								wait.until(ExpectedConditions.elementToBeClickable(By.id(chkbxId)));
								if(!element.isSelected()){
									//Thread.sleep(3000L)
									element.click();
									//Thread.sleep(5000L);
								}
								
								
								
							}
						}		
					}
				}
			}
			
			
			Log.log.debug("Click on check box");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	

}
