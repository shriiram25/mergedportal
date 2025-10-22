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
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class VerifyDealerCostPage {
	
	public String status=null;
	
	public WebDriver driver;
	
	public VerifyDealerCostPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="econRemitTable")
	public WebElement eTable;
	
	public void veryfyDealerCost(String LastName, String FirstName, String VehicleID, String ExpDealerCost, String Test_Case, String Dealer, String Product, String Coverage, String Term, String RimSize, String Quantity, String Portal)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("econRemitTable")));
			
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
						String WebLastName=tdList.get(2).getText().trim();
						String WebFirstName=tdList.get(3).getText().trim();
						String WebVin=tdList.get(4).getText();
						String WebDealerCost=tdList.get(6).getText().trim();
						String WebDate=tdList.get(8).getText().trim();
						
						/*System.out.println("webLastName:- "+webLastName);
						System.out.println("webFirstName:- "+webFirstName);
						System.out.println("webVin:- "+webVin);
						System.out.println("webDealerCost:- "+webDealerCost);
						System.out.println("webVin:- "+webVin);
						System.out.println("VehicleID:- "+VehicleID);*/
						
						/*System.out.println("LastName:- "+LastName.trim());
						System.out.println("FirstName:- "+FirstName.trim());
						System.out.println("VehicleID:- "+VehicleID.trim());*/
						if(WebLastName.equalsIgnoreCase(LastName.trim()) && WebFirstName.equalsIgnoreCase(FirstName.trim()) )
						{
							//System.out.println("YESsssssssssssssssssssssssssssssss");
							//Assert.assertEquals(webVin.trim(), VehicleID.trim());
							if(WebVin.trim().equalsIgnoreCase(VehicleID.trim()) && WebDate.equalsIgnoreCase(CurrentDateSelection.getCurrentDate()))
							{
								//System.out.println("YES");
								if(WebDealerCost.equals(ExpDealerCost))
								{
									status="Pass";
								}else{
									status="Fail";
								}
								
								//System.out.println("status:- "+status);
								
								String[] valueToWriteNew=null;
								valueToWriteNew = new String[15];
				        		valueToWriteNew[0]=Test_Case;
				        		valueToWriteNew[1]=Portal;
				        		valueToWriteNew[2]=Dealer;
				        		valueToWriteNew[3]=VehicleID;
				        		valueToWriteNew[4]=Product;
				        		valueToWriteNew[5]=Coverage;
				        		valueToWriteNew[6]=Term;
				        		valueToWriteNew[7]=RimSize;
				        		valueToWriteNew[8]=Quantity;
				        		valueToWriteNew[9]=FirstName;
				        		valueToWriteNew[10]=LastName;
				        		valueToWriteNew[11]=ExpDealerCost;
				        		valueToWriteNew[12]=WebDealerCost;
				        		valueToWriteNew[13]=status;
				        		valueToWriteNew[14]=CurrentDateSelection.getCurrentDate();
				        		
				        		ExcelReadWrite ERW=new ExcelReadWrite();
				        		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "MB_US_EContract_Result",valueToWriteNew);
				        		
				        		Log.log.debug("Verify Dealer Cost as:-");
				        		Log.log.debug("Expected Dealer Cost as:- "+ExpDealerCost);
				        		Log.log.debug("Actual Dealer Cost as:- "+WebDealerCost);
				        		Log.log.debug("Status as:- "+status);
				        		
							}
						}
						
						
								
					}
				}
			}
						
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	

}
