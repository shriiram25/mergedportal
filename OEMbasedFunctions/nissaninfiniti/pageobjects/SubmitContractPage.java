package nissaninfiniti.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
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
	
	@FindBy(linkText="Back to Current Agreements")
	public WebElement btca;
	
	public void clickSubmitAcceptedAgreements()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
			wait.until(ExpectedConditions.elementToBeClickable(submitAcceptedAgreements));
			submitAcceptedAgreements.click();
			//Thread.sleep(10000L);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to Current Agreements")));
			wait.until(ExpectedConditions.visibilityOf(btca));
			
			Log.log.debug("Click on submitAcceptedAgreements Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
				
	}
	
	public void submitEContract(String FirstName, String LastName, String VehicleID)
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
						
						if( webFirstName.equalsIgnoreCase(FirstName.trim()) && webLastName.equalsIgnoreCase(LastName.trim()) )
						{
							if( webVin.trim().equalsIgnoreCase(VehicleID.trim()) && webDate.equalsIgnoreCase(CurrentDateSelection.getCurrentDate()) )
							{								
								String rowId=trList.get(i).getAttribute("id");								
								rowId=rowId.substring(4);								
								String chkbxId="accepted_"+rowId;								
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
