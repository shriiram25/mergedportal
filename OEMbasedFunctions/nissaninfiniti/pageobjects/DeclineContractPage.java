package nissaninfiniti.pageobjects;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

import configurations.Hooks;
import utility.CurrentDateSelection;
import utility.GetScreenshot;

public class DeclineContractPage {
	
	public String status=null;
	
	public WebDriver driver;
	
	public DeclineContractPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="econRemitTable")
	public WebElement eTable;
	
	public void declineEContract(String FirstName, String LastName, String VehicleID)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("econRemitTable")));
			wait.until(ExpectedConditions.visibilityOf(eTable));
					
			List<WebElement> tagList=eTable.findElements(By.tagName("tbody"));
			if(tagList.size()>0)
			{
				//System.out.println("tagListSIZE:- "+tagList.size());
				List<WebElement> trList=tagList.get(0).findElements(By.tagName("tr"));
				if(trList.size()>0)
				{
					//System.out.println("trListSize:- "+trList.size());
					for(int i=0;i<trList.size();i++)
					{
						List<WebElement> tdList=trList.get(i).findElements(By.tagName("td"));
						//System.out.println("tdListSize:- "+tdList.size());
						String webLastName=tdList.get(2).getText().trim();
						String webFirstName=tdList.get(3).getText().trim();
						String webVin=tdList.get(4).getText();
						String webDealerCost=tdList.get(6).getText().trim();
						String webDate=tdList.get(8).getText().trim();
						
						/*System.out.println("webLastName:- "+webLastName);
						System.out.println("webFirstName:- "+webFirstName);
						System.out.println("webVin:- "+webVin);
						System.out.println("webDealerCost:- "+webDealerCost);
						System.out.println("webVin:- "+webVin);
						System.out.println("VehicleID:- "+VehicleID);*/
						
						/*System.out.println("LastName:- "+LastName.trim());
						System.out.println("FirstName:- "+FirstName.trim());
						System.out.println("VehicleID:- "+VehicleID.trim());*/
						if( webFirstName.equalsIgnoreCase(FirstName.trim()) && webLastName.equalsIgnoreCase(LastName.trim()) )
						{
							//System.out.println("YESsssssssssssssssssssssssssssssss");
							//Assert.assertEquals(webVin.trim(), VehicleID.trim());
							if(webVin.trim().equalsIgnoreCase(VehicleID.trim()) && webDate.equalsIgnoreCase(CurrentDateSelection.getCurrentDate()))
							{
								
								String rowId=trList.get(i).getAttribute("id");
								//System.out.println("rawId:- "+rawId);
								rowId=rowId.substring(4);
								//System.out.println("rawId:- "+rawId);
								String butnId="declined_"+rowId;
								//System.out.println("butnId:- "+butnId);
								WebElement element=driver.findElement(By.id(butnId));
								//Thread.sleep(3000L);								
								wait.until(ExpectedConditions.elementToBeClickable(By.id(butnId)));
								element.click();
								//Thread.sleep(5000L);
								wait.until(ExpectedConditions.alertIsPresent());
								Alert alert=driver.switchTo().alert();								
								alert.accept();
								Log.log.debug("Click on Alert");
							}
						}
												
					}
				}
			}
			
			
			Log.log.debug("Click on decline button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
}
